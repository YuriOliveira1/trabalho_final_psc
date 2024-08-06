package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CartasFormController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label label;

    @FXML
    private TextField textFieldId;

    @FXML
    private TextField textFieldNomeEscritor;

    @FXML
    private TextField textFieldTexto;

    @FXML
    private Button buttonSalvar;

    @FXML
    private Button buttonCancelar;

    @FXML
    private void onBtSalvarAction(ActionEvent event) {
        System.out.println("Teste");
    }

    @FXML
    private void onBtCancelarAction(ActionEvent event) {
        Utils.currentStage(event).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
