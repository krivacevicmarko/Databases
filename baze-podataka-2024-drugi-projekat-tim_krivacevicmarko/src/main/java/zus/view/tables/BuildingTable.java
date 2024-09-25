package zus.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import zus.model.base.Building;

import java.util.List;

public class BuildingTable extends TableView<Building> {

    public BuildingTable(List<Building> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<Building, Integer> tcBuildingId = new TableColumn<>("BuildingId");
        TableColumn<Building, String> tcBuildingName = new TableColumn<>("BuildingName");
        TableColumn<Building, Integer> tcObjectId = new TableColumn<>("ObjectId");
        TableColumn<Building, String> tcObjectType = new TableColumn<>("ObjectType");
        TableColumn<Building, Integer> tcObjectCapacity = new TableColumn<>("ObjectCapacity");

        tcBuildingId.setCellValueFactory(new PropertyValueFactory<>("buildingId"));
        tcBuildingName.setCellValueFactory(new PropertyValueFactory<>("buildingName"));
        tcObjectId.setCellValueFactory(new PropertyValueFactory<>("objectId"));
        tcObjectType.setCellValueFactory(new PropertyValueFactory<>("objectType"));
        tcObjectCapacity.setCellValueFactory(new PropertyValueFactory<>("objectCapacity"));

        super.getColumns().add(tcBuildingId);
        super.getColumns().add(tcBuildingName);
        super.getColumns().add(tcObjectId);
        super.getColumns().add(tcObjectType);
        super.getColumns().add(tcObjectCapacity);
    }

}

