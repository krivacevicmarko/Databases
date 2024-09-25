package zus.controler;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import zus.model.base.Person;
import zus.model.base.Server;
import zus.model.jdbc.JDBCUtils;

import java.time.LocalDate;
import java.util.List;

public class AddPersonControl implements EventHandler<ActionEvent> {

    private final TextField nameTextField;
    private final TextField surnameTextField;
    private final TextField usernameTextField;
    private final TextField passwordTextField;
    private final TextField repeatTextField;

    public AddPersonControl(TextField nameTextField, TextField surnameTextField, TextField usernameTextField, TextField passwordTextField, TextField repeatTextField) {
        this.nameTextField = nameTextField;
        this.surnameTextField = surnameTextField;
        this.usernameTextField = usernameTextField;
        this.passwordTextField = passwordTextField;
        this.repeatTextField = repeatTextField;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String name = this.nameTextField.getText().trim();
        String surname = this.surnameTextField.getText().trim();
        String username = this.usernameTextField.getText().trim();
        String password = this.passwordTextField.getText().trim();
        String repeat = this.repeatTextField.getText().trim();
        List<Person> persons = JDBCUtils.selectAllFromPerson();

        boolean isError = false; // Promenljiva za praćenje grešaka

        if (!(repeat.equals(password))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect password");
            alert.setHeaderText(null);
            alert.setContentText("You have entered the repeated password incorrectly, please try again!");
            this.repeatTextField.clear();
            alert.showAndWait();
            isError = true; // Postavljamo grešku na true
        }

        for (Person person : persons) {
            if (person.getUsername().equalsIgnoreCase(username)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Username duplicate");
                alert.setHeaderText(null);
                alert.setContentText("The entered username already exists, please try again!");
                this.usernameTextField.clear();
                alert.showAndWait();
                isError = true; // Postavljamo grešku na true
                break; // Prekidamo petlju ako se pronađe duplikat korisničkog imena
            }
        }

        // Ako nema grešaka, ubacujemo korisnika i prikazujemo poruku o uspešnoj registraciji
        if (!isError) {
            JDBCUtils.insertIntoPerson(name, surname, username, password);
            this.nameTextField.clear();
            this.surnameTextField.clear();
            this.usernameTextField.clear();
            this.passwordTextField.clear();
            this.repeatTextField.clear();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Registration Successful");
            successAlert.setHeaderText(null);
            successAlert.setContentText("You have successfully registered!");
            successAlert.showAndWait();
        }
    }
}
