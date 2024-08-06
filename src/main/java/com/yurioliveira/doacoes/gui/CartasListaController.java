package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.model.entities.CartaDeApoio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CartasListaController implements Initializable {

    @FXML
    public ToolBar toolBar;

    @FXML
    public Label labelRegistro;

    @FXML
    private TableView<CartaDeApoio> tableView;

    @FXML
    private TableColumn<CartaDeApoio, Integer> tableColumnId;

    @FXML
    private TableColumn<CartaDeApoio, String> tableColumnNomeEscritor;

    @FXML
    private TableColumn<CartaDeApoio, String> tableColumnCarta;

    @FXML
    private Button btRegistrar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initalizeNodes();
    }

    private void initalizeNodes() {

    }

    private void onBtRegistrarAction(ActionEvent actionEvent) {
        System.out.println("Teste");
    }
}
