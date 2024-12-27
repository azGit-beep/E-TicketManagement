package controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class BusTicketBookingController {

    @FXML
    private Button Menu;

    @FXML
    private VBox Slider;

    private boolean isMenuVisible = false;

    public void initialize() {
        // Set initial position of the slider
        Slider.setTranslateX(-200);

        // Add event listener to the menu button
        Menu.setOnAction(this::toggleMenu);
    }

    private void toggleMenu(ActionEvent event) {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(Slider);

        if (isMenuVisible) {
            // Hide menu
            transition.setToX(-200);
        } else {
            // Show menu
            transition.setToX(0);
        }

        isMenuVisible = !isMenuVisible;
        transition.play();
    }
}
