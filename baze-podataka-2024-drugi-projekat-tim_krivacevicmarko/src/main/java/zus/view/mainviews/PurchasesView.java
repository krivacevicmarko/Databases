package zus.view.mainviews;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import zus.model.base.Person;

import zus.model.jdbc.JDBCUtils;
import zus.view.tables.PurchaseBuildingTable;


public class PurchasesView extends Stage {

    private final BorderPane main = new BorderPane();

    private PurchaseBuildingTable purchaseTableView;
    private final Person loggedInPerson;

    public PurchasesView(Person loggedInPerson) {
        this.loggedInPerson = loggedInPerson;
        purchaseTableView = new PurchaseBuildingTable(JDBCUtils.selectFromBuildingAndPurchase(loggedInPerson.getPersonId()));
        initialize();
    }

    private void initialize() {
        setTitle("My Purchases");
        main.setCenter(purchaseTableView);
        setScene(new Scene(main, 600, 400));
    }

}

