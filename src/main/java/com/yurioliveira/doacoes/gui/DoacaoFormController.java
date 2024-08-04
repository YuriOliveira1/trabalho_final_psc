package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DoacaoFormController implements Initializable {

    @FXML
    private TextField txtIdDoador;

    @FXML
    private TextField txtApelidoDoador;

    @FXML
    private TextField txtContatoDoador;

    @FXML
    private TextField txtIdDoacao;

    @FXML
    private TextField txtTipoDoacao;

    @FXML
    private TextField txtQuantidadeDoacao;

    @FXML
    private DatePicker txtDataDoacao;

    @FXML
    private Button btSalvar;

    @FXML
    private Button btCancelar;

    @FXML
    public void onBtSalvarAction(){
        System.out.println("Salvar funcionadno");
    }

    @FXML
    public void onBtCancelarAction(){
        System.out.println("Cancelar funcionadno");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializaNodes();
    }

    private void initializaNodes(){
        Constraints.setTextFieldMaxLength(txtApelidoDoador, 20);
        Constraints.setTextFieldMaxLength(txtContatoDoador, 15);
        Constraints.setTextFieldMaxLength(txtTipoDoacao, 30);
        Constraints.setTextFieldInteger(txtQuantidadeDoacao);
    }
}
