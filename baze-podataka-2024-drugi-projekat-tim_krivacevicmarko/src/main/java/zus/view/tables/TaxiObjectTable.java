package zus.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import zus.model.base.TaxiObject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TaxiObjectTable extends TableView<TaxiObject> {

    public TaxiObjectTable(List<TaxiObject> taxiTables){
        super(FXCollections.observableArrayList(taxiTables));

        TableColumn<TaxiObject, Integer> taxiIdCol = new TableColumn<>("TaxiID");
        taxiIdCol.setCellValueFactory(new PropertyValueFactory<>("taxiId"));

        TableColumn<TaxiObject, String> vehicleCodeCol = new TableColumn<>("Vehicle code");
        vehicleCodeCol.setCellValueFactory(new PropertyValueFactory<>("code"));

        TableColumn<TaxiObject, LocalDate> dateCol = new TableColumn<>("Travel Date");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<TaxiObject, LocalTime> timeCol = new TableColumn<>("Travel time");
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));

        TableColumn<TaxiObject, Integer> capacityCol = new TableColumn<>("Capacity"); // Ispravljen naziv stupca
        capacityCol.setCellValueFactory(new PropertyValueFactory<>("capacity")); // Ispravljen naziv atributa

        TableColumn<TaxiObject, String> objectIdCol = new TableColumn<>("Planet/Satellite destination"); // Ispravljen naziv stupca
        objectIdCol.setCellValueFactory(new PropertyValueFactory<>("name")); // Ispravljen naziv atributa

        super.getColumns().add(taxiIdCol);
        super.getColumns().add(vehicleCodeCol);
        super.getColumns().add(dateCol);
        super.getColumns().add(timeCol);
        super.getColumns().add(capacityCol);
        super.getColumns().add(objectIdCol);


    }

}
