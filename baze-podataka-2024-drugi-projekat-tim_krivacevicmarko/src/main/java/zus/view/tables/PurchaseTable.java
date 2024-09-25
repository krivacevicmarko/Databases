package zus.view.tables;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import zus.model.base.Purchase;

import java.time.LocalDate;
import java.util.List;

public class PurchaseTable extends TableView<Purchase> {

    public PurchaseTable(List<Purchase> purchases) {
        super(FXCollections.observableArrayList(purchases));
        TableColumn<Purchase, Integer> purchaseIdCol = new TableColumn<>("Purchase ID");
        purchaseIdCol.setCellValueFactory(new PropertyValueFactory<>("purchaseId"));

        TableColumn<Purchase, Integer> personIdCol = new TableColumn<>("Person ID");
        personIdCol.setCellValueFactory(new PropertyValueFactory<>("personId"));

        TableColumn<Purchase, Integer> buildingIdCol = new TableColumn<>("Building ID");
        buildingIdCol.setCellValueFactory(new PropertyValueFactory<>("buildingId"));

        TableColumn<Purchase, LocalDate> purchaseDateCol = new TableColumn<>("Purchase Date");
        purchaseDateCol.setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));

        super.getColumns().add(purchaseIdCol);
        super.getColumns().add(personIdCol);
        super.getColumns().add(buildingIdCol);
        super.getColumns().add(purchaseDateCol);

    }

}

