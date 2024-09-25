package zus.view.mainviews;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zus.model.base.Person;
import zus.model.base.TaxiObject;
import zus.model.jdbc.JDBCUtils;
import zus.view.tables.TaxiObjectTable;


import java.time.LocalDate;
import java.util.List;

public class TaxiView extends Stage {

    private TableView<TaxiObject> taxiTableView;
    private final Person loggedInPerson;

    private Label label1;
    private TextField textField1;

    private Label label2;
    private TextField textField2;

    private Label dateLabel;

    private Button findBtn;

    private Button buyButton;
    private Button button1;
    private Button button2;

    private DatePicker datePicker = new DatePicker(LocalDate.now().plusYears(300));

    public TaxiView(Person loggedInPerson) {
        this.loggedInPerson = loggedInPerson;
        initialize();
    }

    private void initialize() {
        setTitle("Taxi View");

        // Create TaxiTable
        List<TaxiObject> taxis = JDBCUtils.selectAllFromTaxiAndObject();
        taxiTableView = new TaxiObjectTable(taxis);
        taxiTableView.setPrefHeight(300);
        taxiTableView.setPrefWidth(300);

        // Initialize Labels and TextFields
        label1 = new Label("Number of companions:");
        textField1 = new TextField();

        label2 = new Label("Names of companions:");
        textField2 = new TextField();

        // Initialize Buttons
        buyButton = new Button("Buy");
        button1 = new Button("All taxi rides");
        button2 = new Button("Taxi rides to my Planets");

        dateLabel = new Label("Date:");
        findBtn = new Button("Find");

        // Create HBox for Buttons
        HBox buttonsHBox = new HBox(10, button1, button2);
        buttonsHBox.setAlignment(Pos.CENTER);

        // Create HBoxes for Labels and TextFields
        HBox hBox1 = new HBox(10, label1, textField1);
        hBox1.setAlignment(Pos.CENTER);
        HBox hBox2 = new HBox(10, label2, textField2);
        hBox2.setAlignment(Pos.CENTER);

        HBox hBox3 = new HBox(5,dateLabel,datePicker,findBtn);
        hBox3.setAlignment(Pos.CENTER);

        // Create VBox for TableView, HBox for Buttons, and HBoxes for Labels and TextFields
        VBox vBox = new VBox(10, hBox3, taxiTableView, buttonsHBox, hBox1, hBox2, buyButton);
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.CENTER);

        // Create main layout and set VBox as the center
        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(vBox);

        // Set the scene
        setScene(new Scene(mainLayout, 550, 500));
        button2.setOnAction(event -> updateTableContent());
        button1.setOnAction(event -> updateTableContent2());
        buyButton.setOnAction(event -> handleBuyButton());
        findBtn.setOnAction(event -> updateTableContent3());
    }

    private void handleBuyButton() {
        // Dobijanje selektovanog reda iz tabele
        TaxiObject selectedTaxi = taxiTableView.getSelectionModel().getSelectedItem();
        if (selectedTaxi != null) {
            int numOfPassengers = Integer.parseInt(textField1.getText());
            String passengersNames = textField2.getText();

            int personId = loggedInPerson.getPersonId();

            int taxiId = selectedTaxi.getTaxiId();

            JDBCUtils.insertIntoTrip(personId, taxiId, numOfPassengers, passengersNames);

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Taxi ride successfully purchased!");
            successAlert.showAndWait();

            // Ažuriranje sadržaja tabele
            updateTableContent();
        } else {
            // Ako nije izabran red u tabeli
            Alert noSelectionAlert = new Alert(Alert.AlertType.WARNING);
            noSelectionAlert.setTitle("Warning");
            noSelectionAlert.setHeaderText(null);
            noSelectionAlert.setContentText("Please select a taxi ride.");
            noSelectionAlert.showAndWait();
        }
    }

    private void updateTableContent() {
        List<TaxiObject> updatedTaxis = JDBCUtils.selectFromTaxiAndObjectAndPurchase(loggedInPerson.getPersonId());
        taxiTableView.setItems(FXCollections.observableArrayList(updatedTaxis));
    }

    private void updateTableContent2() {
        List<TaxiObject> updatedTaxis = JDBCUtils.selectAllFromTaxiAndObject();
        taxiTableView.setItems(FXCollections.observableArrayList(updatedTaxis));
    }

    private void updateTableContent3(){
        LocalDate selectedDate = datePicker.getValue();
        List<TaxiObject> updateTaxis = JDBCUtils.selectAllFromTaxiAndObjectViaDate(selectedDate);
        taxiTableView.setItems(FXCollections.observableArrayList(updateTaxis));
    }

}