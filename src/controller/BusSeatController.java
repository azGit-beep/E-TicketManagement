package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.HashSet;
import java.util.Set;

public class BusSeatController {

    @FXML
    private GridPane seatGrid;

    @FXML
    private Label selectedCountLabel;

    private final int ROWS = 5;
    private final int COLUMNS = 4;
    private final Set<Button> selectedSeats = new HashSet<>();

    @FXML
    public void initialize() {
        // Populate seats dynamically
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                Button seat = createSeatButton("Row " + (char) ('A' + row) + (col + 1));
                seatGrid.add(seat, col, row);
            }
        }
    }

    private Button createSeatButton(String seatId) {
        Button seat = new Button(seatId);
        seat.setPrefSize(60, 40);
        seat.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-text-fill: black;");

        seat.setOnAction(event -> toggleSeatSelection(seat));
        return seat;
    }

    private void toggleSeatSelection(Button seat) {
        if (selectedSeats.contains(seat)) {
            // Deselect seat
            seat.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-text-fill: black;");
            selectedSeats.remove(seat);
        } else {
            // Select seat
            seat.setStyle("-fx-background-color: green; -fx-border-color: black; -fx-text-fill: white;");
            selectedSeats.add(seat);
        }

        // Update selected count
        selectedCountLabel.setText(selectedSeats.size() + " ticket(s) selected");
    }

    @FXML
    private void confirmSelection(ActionEvent event) {
        // Handle seat selection confirmation
        System.out.println("Selected seats: " + selectedSeats);
    }
}
