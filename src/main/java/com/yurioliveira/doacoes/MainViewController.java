package com.yurioliveira.doacoes;

import com.yurioliveira.doacoes.gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemDoacaoNormal;

    @FXML
    private MenuItem menuItemDoacaoDinheiro;

    @FXML
    private MenuItem menuItemDoacaoCartaApoio;

    @FXML
    private MenuItem menuItemSobre;

    @FXML
    public void onMenuItemDoacaoNormalAction() {
        System.out.println("onMenuItemDoacaoNormalAction");
    }

    @FXML
    public void onMenuItemDoacaoDinheiroAction() {
        System.out.println("onMenuItemDoacaoDinheiroAction");
    }

    @FXML
    public void onMenuItemDoacaoCartaApoioAction() {
        System.out.println("onMenuItemDoacaoCartaApoioAction");
    }

    @FXML
    public void onMenuItemSobreAction() {
        loadView();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void loadView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("About.fxml"));
            VBox newVBox = loader.load();

            Scene principalScene = Main.getPrincipalScene();
            VBox mainVbox = (VBox) ((ScrollPane) principalScene.getRoot()).getContent();

            Node menu = mainVbox.getChildren().get(0);
            mainVbox.getChildren().clear();
            mainVbox.getChildren().add(menu);
            mainVbox.getChildren().addAll(newVBox.getChildren());
        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error ao Carregar a Pagina", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
