package controller;

import DatabaseHandling.DatabaseHandler;
import EntityClasses.EntityUser;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;

public class LoginPageController {

    @FXML
    private Button LoginButton;

    @FXML
    private TextField PassWorDTextBox;

    @FXML
    private TextField UserNameTextBox;

    @FXML
    private Button ViewAsAGuestButton;

    @FXML
    private Button signup;

    @FXML
    void goTOViewAsAGuest(ActionEvent event) {

    }


    @FXML
    void goToHomePage(ActionEvent event) throws IOException {
        String user_name = UserNameTextBox.getText();
        String password = PassWorDTextBox.getText();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        List<EntityUser> list = databaseHandler.userValidation(user_name);
        int size = list.size();
        if (user_name.isEmpty() || password.isEmpty() || size == 0 || !(list.get(0).getPassword().equals(password))) {
            String title, header, content;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            if (user_name.isEmpty() || password.isEmpty()) {
                title = "Missing input";
                if (user_name.isEmpty()) {
                    header = "Username is missing";
                    content = "Enter username";
                } else {
                    header = "Password is missing";
                    content = "Enter password";
                }
            } else {
                title = "Wrong input";
                header = "Password didn't match with the username";
                content = "Enter correct password";
            }
            alert.setTitle(title);
            alert.setHeaderText(header);
            alert.setContentText(content);
            alert.showAndWait();

        } else {


            Parent root = FXMLLoader.load(getClass().getResource("/views/home_page.fxml"));
            VBox Slider = (VBox) root.lookup("#Slider");
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.001));
            slide.setNode(Slider);

            slide.setToX(-177.6);
            slide.play();

            Slider.setTranslateX(0);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        }
    }


    @FXML
    void gotoSignupPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/signuppage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void goToAdminPanel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/AdminPanel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();


    }


}
