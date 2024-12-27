package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class AvailableBus {

    private String from, to;

    @FXML
    private VBox contentBox;

    @FXML
    private Button modifySearch;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    void goToSearchBusPage(ActionEvent event) {
        try {
            // Load the FXML file (correct path with .fxml extension)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Find_bus_Page.fxml"));
            Parent root = loader.load();
            FindBusController findBusController = loader.getController();
            findBusController.setData(from, to);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() {
        if (from == null || to == null) {
            System.err.println("from or to not set! Please set the data before initializing.");
            return;
        }

        try {
            for (int i = 0; i < 10; i++) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/snippent.fxml"));
                Node node = loader.load();

                // Lookup and set label values
                Label fromLabel = (Label) node.lookup("#fromLabel");
                Label toLabel = (Label) node.lookup("#ToLabel");
                Label fair = (Label) node.lookup("#fair");

                if (fromLabel != null) fromLabel.setText(from);
                if (toLabel != null) toLabel.setText(to);

                int fr = 600 + new Random().nextInt(1600);
                if (fair != null) fair.setText(String.valueOf(fr + " Tk"));

                contentBox.getChildren().add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setThedata(String from, String to) {
        this.from = from;
        this.to = to;
        initialize(); // Call initialize after setting the data
    }
}
