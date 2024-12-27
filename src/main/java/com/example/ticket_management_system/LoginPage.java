package com.example.ticket_management_system;

import controller.dataController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPage extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("/views/loginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setTitle("MY TICKET");
        Image icon = new Image("/mainlogo.png");
        stage.getIcons().add(icon);
        stage.show();

        stage.setResizable(false);

    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        launch();
        dataController.retrive();
    }
}