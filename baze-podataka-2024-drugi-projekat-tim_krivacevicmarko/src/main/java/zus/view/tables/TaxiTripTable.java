package zus.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import zus.model.base.TaxiObject;
import zus.model.base.TaxiTrip;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TaxiTripTable extends TableView<TaxiTrip> {

    public TaxiTripTable(List<TaxiTrip> taxiTables){
        super(FXCollections.observableArrayList(taxiTables));

        TableColumn<TaxiTrip, Integer> taxiIdCol = new TableColumn<>("TaxiID");
        taxiIdCol.setCellValueFactory(new PropertyValueFactory<>("taxiId"));

        TableColumn<TaxiTrip, String> vehicleCodeCol = new TableColumn<>("Vehicle code");
        vehicleCodeCol.setCellValueFactory(new PropertyValueFactory<>("code"));

        TableColumn<TaxiTrip, LocalDate> dateCol = new TableColumn<>("Travel Date");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<TaxiTrip, LocalTime> timeCol = new TableColumn<>("Travel time");
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));

        TableColumn<TaxiTrip, Integer> capacityCol = new TableColumn<>("Number of passengers");
        capacityCol.setCellValueFactory(new PropertyValueFactory<>("numOfPassengers"));

        TableColumn<TaxiTrip, String> passengerNamesCol = new TableColumn<>("Passenger Names");
        passengerNamesCol.setCellValueFactory(new PropertyValueFactory<>("passengerNames"));

        TableColumn<TaxiTrip, String> nameCol = new TableColumn<>("Destination");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        super.getColumns().addAll(taxiIdCol, vehicleCodeCol, dateCol, timeCol, capacityCol, passengerNamesCol, nameCol);
    }

}
