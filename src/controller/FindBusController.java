package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class FindBusController {
    private String from, to;
    @FXML
    private ImageView homeIcon;
    @FXML
    private HBox availablebus;

    @FXML
    private TextField fromlebel;

    @FXML
    private TextField tolebel;

    @FXML
    void goToHome(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/home_page.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void goToAvailableBus(MouseEvent event) {
        try {
            // Load the FXML file (correct path with .fxml extension)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/available_bus.fxml"));
            Parent root = loader.load();
            AvailableBus availableBus = loader.getController();
            availableBus.setThedata(fromlebel.getText(), tolebel.getText());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setData(String from, String to) {
        this.from = from;
        this.to = to;
        initialize();
    }

    public void initialize() {
        if (from != null && to != null) {

            fromlebel.setText(from);
            tolebel.setText(to);
        }
    }
}