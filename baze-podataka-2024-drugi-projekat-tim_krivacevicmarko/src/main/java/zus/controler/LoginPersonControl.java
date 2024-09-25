package zus.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import zus.model.base.Person;
import zus.model.jdbc.JDBCUtils;
import zus.view.mainviews.PlanetView;

public class LoginPersonControl implements EventHandler<ActionEvent> {

    private final TextField usernameTextField;
    private final TextField passwordTextField;

    public LoginPersonControl(TextField username,TextField password){
        this.usernameTextField = username;
        this.passwordTextField = password;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String username = this.usernameTextField.getText().trim();
        String password = this.passwordTextField.getText().trim();
        Person person = JDBCUtils.login(username, password);
        this.passwordTextField.clear();
        this.usernameTextField.clear();
        if (person != null) {
            PlanetView planetView = new PlanetView(person);
            planetView.show();
        }
    }
}

