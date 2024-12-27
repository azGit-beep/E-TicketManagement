package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminPanelController {

    @FXML
    private Button GoToDashBoard;

    @FXML
    private TextField PassWorDTextBox;

    @FXML
    private TextField UserNameTextBox;

    @FXML
    void GoToDashBoard(MouseEvent event) throws IOException {
      Parent root = FXMLLoader.load(getClass().getResource("/views/dashboard.fxml"));
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       stage.setScene(new Scene(root));
       stage.show();

    }

}