package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class VehicleController {

    @FXML
    private ImageView GoToDashboard;

    @FXML
    private TextField departureTimeInput;

    @FXML
    private TextField numberPlateInput;

    @FXML
    private TextField routeInput;

    @FXML
    private TextField vehicleNameInput;

    @FXML
    private TextField vehicleProviderInput;

    @FXML
    private TableView<?> vehicleTable;

    @FXML
    void GoToDashboard(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/dashboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }

}
