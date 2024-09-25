package zus.view.mainviews;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import zus.controler.AddPersonControl;

public class RegisterView extends Stage {

    private final BorderPane main = new BorderPane();
    private final TextField firstName = new TextField();
    private final TextField lastName = new TextField();

    private final TextField userName = new TextField();

    private final TextField password = new TextField();
    private final TextField repeatpassword = new TextField();

    private final Button btnSubmit = new Button("Submit");

    public RegisterView() {
        super.setTitle("Register");
        this.btnSubmit.setOnAction(new AddPersonControl(this.firstName,this.lastName,this.userName,this.password,this.repeatpassword));
        this.main.setCenter(this.registrationForm());
        super.setScene(new Scene(this.main,300,300));
    }

    private GridPane registrationForm() {
        GridPane gridPane = new GridPane();
        gridPane.addRow(0, new Label("First name:"), this.firstName);
        gridPane.addRow(1, new Label("Last name:"), this.lastName);
        gridPane.addRow(2, new Label("Username:"), this.userName);
        gridPane.addRow(3, new Label("Password:"), this.password);
        gridPane.addRow(4,new Label("Confirm password:"),this.repeatpassword);
        gridPane.add(this.btnSubmit, 1, 5);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }
}
