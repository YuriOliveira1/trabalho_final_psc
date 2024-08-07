package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.database.DbException;
import com.yurioliveira.doacoes.gui.listeners.DataChangeListener;
import com.yurioliveira.doacoes.gui.util.Alerts;
import com.yurioliveira.doacoes.gui.util.Utils;
import com.yurioliveira.doacoes.model.entities.DoacaoDinheiro;
import com.yurioliveira.doacoes.model.entities.Doador;
import com.yurioliveira.doacoes.model.services.DoacaoDinheiroService;
import com.yurioliveira.doacoes.model.services.DoadorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
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

    private Doador entityDoador;

    private DoadorService doadorService;

    private DoacaoDinheiro entityDoacaoDinheiro;

    private DoacaoDinheiroService doacaoDinheiroService;

    @FXML
    public void onBtSalvarActionD(ActionEvent event) {
        DoacaoDinheiro doacaoD = createAndSaveDoacao();
        try {
            doacaoDinheiroService.saveOrUpdate(doacaoD);
            Utils.currentStage(event).close();
        } catch (DbException e) {
            Alerts.showAlert("Erro ao Salvar Doação", null, e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void onBtCancelarActionD(ActionEvent event) {
        Utils.currentStage(event).close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private DoacaoDinheiro createAndSaveDoacao() {
        try {
            entityDoacaoDinheiro = new DoacaoDinheiro();
            entityDoador = getFormDoador();
            doadorService.saveOrUpdate(entityDoador);
            entityDoacaoDinheiro = getFormDoacaoDinheiro();
            entityDoacaoDinheiro.setDoador(entityDoador);
        } catch (DbException e) {
            Alerts.showAlert("Erro na Criação e Salvamento da Doação", null, e.getMessage(), Alert.AlertType.ERROR);

        }
        return entityDoacaoDinheiro;
    }

    private DoacaoDinheiro getFormDoacaoDinheiro() {
        try {
            entityDoacaoDinheiro.setId(Utils.tryParseToInt(txtIdDoacaoDinheiro.getText()));
            entityDoacaoDinheiro.setValor(Utils.tryParseToFloat(txtValorDoacao.getText()));
            entityDoacaoDinheiro.setNomeConta(txtNomeConta.getText());
            entityDoacaoDinheiro.setDoador(entityDoador);
            Instant instant = Instant.from(txtDataDoacao.getValue().atStartOfDay(ZoneId.systemDefault()));
            entityDoacaoDinheiro.setData(Date.from(instant));
        } catch (NumberFormatException e) {
            Alerts.showAlert("Erro de Formato", "Dados Inválidos", "Verifique se os campos de ID e quantidade estão preenchidos corretamente.", Alert.AlertType.ERROR);
        }
        return entityDoacaoDinheiro;
    }


    public void setDoador(Doador entityDoador) {
        this.entityDoador = entityDoador;
    }

    public void setDoadorService(DoadorService serviceDoador) {
        this.doadorService = new DoadorService();
    }

    public void setDoadorDinheiroService(DoacaoDinheiroService serviceDoacaoDinheiro) {
        this.doacaoDinheiroService = serviceDoacaoDinheiro;
    }

    public void setDoacaoDinheiro(DoacaoDinheiro doacaoDinheiro) {
        this.entityDoacaoDinheiro = doacaoDinheiro;
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

    public void subscribeDataChangeListener(ListaDoacaoDinheiroController listaDoacaoDinheiroController) {
    }

    public void updateDoacaoDinheiroForm() {

    }

}

