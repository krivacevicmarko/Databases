package zus.view.mainviews;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zus.model.base.Building;
import zus.model.base.Purchase;
import zus.model.jdbc.JDBCUtils;
import zus.view.tables.BuildingTable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BuildingView extends Stage {

    private final BorderPane root = new BorderPane();
    private final TableView<Building> tvBuildings = new BuildingTable(JDBCUtils.selectAllFromBuilding());
    private final Button btnBuy = new Button("Buy");
    private Label lblObjectId;
    private Label lblPersonId;
    private final TextField tfNumberOfCompanions = new TextField();
    private final TextField tfCompanionsName = new TextField();
    private int objectId;
    private int personId;
    private List<Purchase> allPurchases = new ArrayList<>();

    public BuildingView(int objectId, int personId) {
        super.setTitle("Building Details");
        this.objectId = objectId;
        this.personId = personId;

        lblObjectId = new Label("Object ID: " + objectId);
        lblPersonId = new Label("Person ID: " + personId);

        HBox hboxLabels = new HBox(10, lblObjectId, lblPersonId);
        hboxLabels.setPadding(new Insets(10));
        hboxLabels.setAlignment(Pos.CENTER);

        TableView<Building> tv = new BuildingTable(JDBCUtils.selectFromBuildingViaObjectId(objectId));
        tv.setPrefSize(400, 150);

        VBox vboxControls = new VBox(10, tv,btnBuy);
        vboxControls.setPadding(new Insets(10));
        vboxControls.setAlignment(Pos.CENTER);

        this.root.setTop(hboxLabels);
        this.root.setCenter(vboxControls);

        btnBuy.setOnAction(event -> handleBuyButton(tv));

        super.setScene(new Scene(this.root, 500, 300));
    }

    public BuildingView(int personId) {
        super.setTitle("Building Details");
        this.personId = personId;

        lblPersonId = new Label("Person ID: " + personId);

        HBox hboxLabels = new HBox(10, lblPersonId);
        hboxLabels.setPadding(new Insets(10));
        hboxLabels.setAlignment(Pos.CENTER);

        tvBuildings.setPrefSize(400, 250);

        VBox vboxControls = new VBox(10, tvBuildings, btnBuy);
        vboxControls.setPadding(new Insets(10));
        vboxControls.setAlignment(Pos.CENTER);

        this.root.setTop(hboxLabels);
        this.root.setCenter(vboxControls);

        btnBuy.setOnAction(event -> handleBuyButton(tvBuildings));

        super.setScene(new Scene(this.root, 500, 300));
    }

    private void handleBuyButton(TableView<Building> tableView) {
        Building selectedBuilding = tableView.getSelectionModel().getSelectedItem();
        allPurchases = JDBCUtils.selectAllFromPurchase();
        if (selectedBuilding != null) {
            int buildingId = selectedBuilding.getBuildingId();
            LocalDate futureDate = LocalDate.now().plusYears(300);
            boolean isPurchased = allPurchases.stream()
                    .anyMatch(purchase -> purchase.getBuildingId() == buildingId);
            if (isPurchased) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Building already purchased");
                alert.setContentText("The selected building has already been purchased.");
                alert.showAndWait();
                return;
            }

            // If the building is not already purchased, proceed with the purchase
            JDBCUtils.insertIntoPurchase(personId, buildingId, futureDate);
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Building successfully purchased!");
            successAlert.showAndWait();
        } else {
            System.out.println("No building selected");
        }
    }

    public BorderPane getRoot() {
        return root;
    }

    public TextField getTfNumberOfCompanions() {
        return tfNumberOfCompanions;
    }

    public TextField getTfCompanionsName() {
        return tfCompanionsName;
    }
}