package zus.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import zus.model.base.PurchaseBuildingInfo;


import java.time.LocalDate;
import java.util.List;

public class PurchaseBuildingTable extends TableView<PurchaseBuildingInfo> {

    public PurchaseBuildingTable(List<PurchaseBuildingInfo> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<PurchaseBuildingInfo, String> buildingNameCol = new TableColumn<>("Building Name");
        buildingNameCol.setCellValueFactory(new PropertyValueFactory<>("buildingName"));

        TableColumn<PurchaseBuildingInfo, String> objectTypeCol = new TableColumn<>("Object Type");
        objectTypeCol.setCellValueFactory(new PropertyValueFactory<>("objectType"));

        TableColumn<PurchaseBuildingInfo, Integer> objectCapacityCol = new TableColumn<>("Object Capacity");
        objectCapacityCol.setCellValueFactory(new PropertyValueFactory<>("objectCapacity"));

        TableColumn<PurchaseBuildingInfo, LocalDate> purchaseDateCol = new TableColumn<>("Purchase Date");
        purchaseDateCol.setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));

        TableColumn<PurchaseBuildingInfo, String> objectNameCol = new TableColumn<>("Object Name"); // Ispravljen naziv stupca
        objectNameCol.setCellValueFactory(new PropertyValueFactory<>("objectName")); // Ispravljen naziv atributa

        super.getColumns().add(buildingNameCol);
        super.getColumns().add(objectTypeCol);
        super.getColumns().add(objectCapacityCol);
        super.getColumns().add(purchaseDateCol);
        super.getColumns().add(objectNameCol); // Dodan ispravljeni stupac
    }
}