package com.yurioliveira.doacoes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

import java.awt.event.ActionEvent;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
