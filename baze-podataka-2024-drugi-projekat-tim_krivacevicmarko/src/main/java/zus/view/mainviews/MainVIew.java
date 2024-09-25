package zus.view.mainviews;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zus.controler.LoginPersonControl;

public class MainVIew extends Stage {


    private final BorderPane main = new BorderPane();
    private final TextField username = new TextField();
    private final TextField password = new TextField();

    private final Button btnLogin = new Button("Login");

    private final Button btnRegister = new Button("Register");

    public MainVIew(){
        super.setTitle("Homepage");
        this.main.setCenter(this.loginBox());
        this.btnLogin.setOnAction(new LoginPersonControl(this.username,this.password));
        super.setScene(new Scene(this.main,450,250));
        this.initializeActions();
    }

    private VBox loginBox(){
        GridPane gridPane = new GridPane();
        gridPane.addRow(0, new Label("Username:"), this.username);
        gridPane.addRow(1, new Label("Password:"), this.password);
        gridPane.add(this.btnLogin,1,2);
        gridPane.add(this.btnRegister,1,3);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);

        VBox buttonBox = new VBox(10);
        buttonBox.getChildren().addAll(this.btnLogin,this.btnRegister);
        buttonBox.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(gridPane, buttonBox);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        return vbox;
    }

    private void initializeActions() {
        btnRegister.setOnAction(event -> {
            RegisterView registerView = new RegisterView();
            registerView.show();
        });
    }

}
