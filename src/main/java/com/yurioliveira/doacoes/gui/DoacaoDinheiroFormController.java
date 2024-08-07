package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.database.DbException;
import com.yurioliveira.doacoes.gui.util.Alerts;
import com.yurioliveira.doacoes.gui.util.Utils;
import com.yurioliveira.doacoes.model.entities.Doacao;
import com.yurioliveira.doacoes.model.entities.DoacaoDinheiro;
import com.yurioliveira.doacoes.model.entities.Doador;
import com.yurioliveira.doacoes.model.services.DoadorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DoacaoDinheiroFormController implements Initializable {

    @FXML
    private TextField txtIdDoador;

    @FXML
    private TextField txtApelidoDoador;

    @FXML
    private TextField txtContatoDoador;

    @FXML
    private TextField txtIdDoacaoDinheiro;

    @FXML
    private TextField txtValorDoacao;

    @FXML
    private TextField txtNomeConta;

    @FXML
    private DatePicker txtDataDoacao;

    @FXML
    private Button btSalvar;

    @FXML
    private Button btCancelar;

    private entityDoador;

    private DoadorService doadorService;

    private DoacaoDinheiro entityDoacaoDinheiro;

    @FXML
    public void onBtSalvarAction(ActionEvent event){
        DoacaoDinheiro doacaoD = createAndSaveDoacao();
        try {
            service.saveOrUpdate(doacaoD);
            Utils.currentStage(event).close();
        } catch (DbException | IllegalAccessException e) {
            Alerts.showAlert("Erro ao Salvar Doação", null, e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void onBtCancelarAction(ActionEvent event){
        Utils.currentStage(event).close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private DoacaoDinheiro createAndSaveDoacao() {
        DoacaoDinheiro doacao = new DoacaoDinheiro();
        entityDoador = getFormDoador();
        doadorService.saveOrUpdate(entityDoador);
        entityDoacaoDinheiro = getFormDoacaoDinheiro();
        entityDoacaoDinheiro.set


    }

    public void setDoador(Doador entityDoador) {
        this.entityDoador = entityDoador;
    }

    public void setDoadorService(DoadorService serviceDoador) {
        this.doadorService = serviceDoador;
    }

    private Doador getFormDoador() {
        Doador doador = new Doador();
        try {
            doador.setId(Utils.tryParseToInt(txtIdDoador.getText()));
            doador.setApelido(txtApelidoDoador.getText());
            doador.setContato(txtContatoDoador.getText());
        } catch (NumberFormatException e) {
            Alerts.showAlert("Erro de Formato", "ID inválido", "O ID do doador deve ser um número inteiro.", Alert.AlertType.ERROR);
        }
        return doador;
    }

    public void updateDoadorForm() {
        if (entityDoador == null) {
            throw new IllegalStateException("Doador não foi inicializado");
        }
        txtIdDoador.setText(String.valueOf(entityDoador.getId()));
        txtApelidoDoador.setText(entityDoador.getApelido());
        txtContatoDoador.setText(entityDoador.getContato());
    }

}
