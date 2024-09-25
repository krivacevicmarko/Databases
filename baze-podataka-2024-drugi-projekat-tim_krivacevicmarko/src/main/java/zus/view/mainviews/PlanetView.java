package zus.view.mainviews;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zus.model.base.Object;
import zus.model.base.Person;
import zus.model.base.Mission;
import zus.model.base.Server;
import zus.model.jdbc.JDBCUtils;
import zus.view.tables.MissionTable;
import zus.view.tables.ObjectTable;

import java.util.ArrayList;
import java.util.List;

public class PlanetView extends Stage {

    private final BorderPane main = new BorderPane();
    private final Person loggedInPerson;

    private final TableView<Mission> tvMissions = new MissionTable(Server.SERVER.getMission());
    private final TableView<Object> tvObjects = new ObjectTable(Server.SERVER.getObjects());

    private final Button btnMyTaxiPurchases = new Button("My taxi purchases");
    private final Button btnMyResidentialUnit = new Button("My residential unit");
    private final Button btnBuyResidentialUnit = new Button("Buy residential unit");
    private final Button btnBuyTaxiToPlanet = new Button("Buy taxi to planet");
    private final Button btnShow = new Button("Show");
    private final Button btnReset = new Button("Reset");

    public PlanetView(Person person){
        super.setTitle("Planets");
        this.loggedInPerson = person;
        this.main.setLeft(this.leftBox());
        this.main.setCenter(this.centerBox());
        this.main.setRight(this.rightBox());
        super.setScene(new Scene(this.main, 1100, 450));
        this.initializeActions();
    }

    private VBox leftBox(){
        Label lblPlanets = new Label("ZUS objects");
        tvObjects.setPrefSize(300, 270);
        VBox vbox = new VBox(10, lblPlanets, tvObjects, btnMyTaxiPurchases, btnMyResidentialUnit);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        return vbox;
    }

    private VBox rightBox(){
        Label lblMissions = new Label("Missions");
        tvMissions.setPrefSize(660, 270);
        HBox hbox = new HBox(10, lblMissions, btnReset);
        hbox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(10, hbox, tvMissions, btnBuyResidentialUnit, btnBuyTaxiToPlanet);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        btnReset.setOnAction(e -> onResetButtonClick());
        return vbox;
    }

    private VBox centerBox() {
        VBox vbox = new VBox(10, btnShow);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        btnShow.setOnAction(e -> onShowButtonClick());
        return vbox;
    }

    private void onShowButtonClick() {
        Object selectedObject = tvObjects.getSelectionModel().getSelectedItem();
        if (selectedObject != null) {
            updateMissionsTable(selectedObject);
        } else {
            // Handle the case where no object is selected, if necessary
        }
    }

    private void updateMissionsTable(Object selectedObject) {
        // Dohvati misije na osnovu izabranog objekta
        List<Mission> missions = JDBCUtils.selectFromMissionViaId(selectedObject.getObjectId());
        // Ažuriraj tabelu sa dobijenim misijama
        tvMissions.getItems().setAll(missions);
    }

    private void onResetButtonClick() {
        List<Mission> allMissions = JDBCUtils.selectAllFromMissions();
        tvMissions.getItems().setAll(allMissions);
    }

    private void initializeActions() {
        btnBuyResidentialUnit.setOnAction(event -> {
            Mission selectedMission = tvMissions.getSelectionModel().getSelectedItem();
            if (selectedMission != null) {
                // Ako je selektovana misija, otvori BuildingView za tu misiju
                openBuildingViewForMission(selectedMission);
            } else {
                // Ako ništa nije selektovano, otvori BuildingView samo za trenutnog korisnika
                openBuildingViewForLoggedInPerson();
            }
        });
        btnMyResidentialUnit.setOnAction(event -> openPurchasesView());
        btnBuyTaxiToPlanet.setOnAction(event -> openTaxiView());
        btnMyTaxiPurchases.setOnAction(event -> openMyTaxiTripsView());
    }

    private void openMyTaxiTripsView(){
        MyTaxiTripsView myTaxiTripsView = new MyTaxiTripsView(loggedInPerson);
        myTaxiTripsView.show();
    }

    private void openTaxiView(){
        TaxiView taxiView = new TaxiView(loggedInPerson);
        taxiView.show();
    }

    private void openPurchasesView() {
        PurchasesView purchasesView = new PurchasesView(loggedInPerson);
        purchasesView.show();
    }

    private void openBuildingViewForMission(Mission mission) {
        // Kreiraj novi prozor BuildingView i proslijedi mu informacije o misiji i trenutno prijavljenom korisniku
        BuildingView buildingView = new BuildingView(mission.getPlanetId(), loggedInPerson.getPersonId());
        buildingView.show();
    }

    private void openBuildingViewForLoggedInPerson() {
        // Kreiraj novi prozor BuildingView samo za trenutno prijavljenog korisnika
        BuildingView buildingView = new BuildingView(loggedInPerson.getPersonId());
        buildingView.show();
    }
}