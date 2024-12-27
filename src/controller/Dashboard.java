package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboard {

    @FXML
    private Button GoToVehicle;

    @FXML
    private ImageView backToHome;

    @FXML
    private TableView<?> ticketTable;

    @FXML
    void GoToVehicle(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Vehicle.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    void backToHome(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/AdminPanel.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }

}

