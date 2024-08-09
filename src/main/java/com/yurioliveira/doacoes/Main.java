package com.yurioliveira.doacoes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Scene principalScene;

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
            ScrollPane scrollPane = loader.load();
            principalScene = new Scene(scrollPane);

            scrollPane.setFitToHeight(true);
            scrollPane.setFitToWidth(true);

            primaryStage.setScene(principalScene);
            primaryStage.setTitle("Projeto PSC");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Scene getPrincipalScene() {
        return principalScene;
    }

    public static void main(String[] args) {
        launch();
    }
}