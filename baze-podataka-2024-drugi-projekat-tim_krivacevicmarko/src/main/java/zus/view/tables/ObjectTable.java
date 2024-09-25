package zus.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import zus.model.base.Object;

import java.util.List;

public class ObjectTable extends TableView<Object> {
    public ObjectTable(List<Object> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<Object, Integer> tcObjectId = new TableColumn<>("ObjectId");
        TableColumn<Object, String> tcName = new TableColumn<>("Name");
        TableColumn<Object, String> tcType = new TableColumn<>("Type");
        TableColumn<Object, Integer> tcNumOfMissions = new TableColumn<>("NumOfMissions");

        tcObjectId.setCellValueFactory(new PropertyValueFactory<>("objectId"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tcNumOfMissions.setCellValueFactory(new PropertyValueFactory<>("nummOfMissions"));

        super.getColumns().add(tcObjectId);
        super.getColumns().add(tcName);
        super.getColumns().add(tcType);
        super.getColumns().add(tcNumOfMissions);
    }
}