package zus.view.mainviews;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zus.model.base.Person;
import zus.model.base.TaxiTrip;
import zus.model.jdbc.JDBCUtils;
import zus.view.tables.TaxiTripTable;

import java.util.List;

public class MyTaxiTripsView extends Stage {

    private final Person person;
    private final List<TaxiTrip> taxiTrips;

    public MyTaxiTripsView(Person person) {
        this.person = person;
        this.taxiTrips = JDBCUtils.selectFromTaxiAndTripViaPerson(person.getPersonId());
        initialize();
    }

    private void initialize() {
        setTitle("My Taxi Trips");

        Label personIdLabel = new Label("Person ID: " + person.getPersonId());
        personIdLabel.setStyle("-fx-font-weight: bold;");

        // Create TaxiTripTable
        TaxiTripTable taxiTripTable = new TaxiTripTable(taxiTrips);

        // Create VBox to hold Label and TaxiTripTable
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(personIdLabel, taxiTripTable);

        // Set VBox as the center of the BorderPane
        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(vbox);

        // Set the scene
        setScene(new Scene(mainLayout, 850, 300));
    }
}
