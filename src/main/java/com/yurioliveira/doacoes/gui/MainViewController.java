package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.Main;
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
        loadView("/com/yurioliveira/doacoes/ListaDoacaoNormal.fxml");
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
        loadView("/com/yurioliveira/doacoes/About.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void loadView(String pathName) {
        try {
            URL fxmlLocation = getClass().getResource(pathName);
            if (fxmlLocation == null) {
                throw new IOException("FXML file not found at specified path.");
            }
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            VBox newVBox = loader.load();

            Scene principalScene = Main.getPrincipalScene();
            VBox mainVbox = (VBox) ((ScrollPane) principalScene.getRoot()).getContent();

            Node menu = mainVbox.getChildren().get(0);
            mainVbox.getChildren().clear();
            mainVbox.getChildren().add(menu);
            mainVbox.getChildren().addAll(newVBox.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
            Alerts.showAlert("IO Exception", "Error ao Carregar a Pagina", e.getMessage(), Alert.AlertType.ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            Alerts.showAlert("Exception", "Erro Inesperado", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
