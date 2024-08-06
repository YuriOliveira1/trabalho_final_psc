package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.database.DbException;
import com.yurioliveira.doacoes.gui.listeners.DataChangeListener;
import com.yurioliveira.doacoes.gui.util.Alerts;
import com.yurioliveira.doacoes.gui.util.Constraints;
import com.yurioliveira.doacoes.gui.util.Utils;
import com.yurioliveira.doacoes.model.entities.Doacao;
import com.yurioliveira.doacoes.model.entities.Doador;
import com.yurioliveira.doacoes.model.services.DoacaoNormalService;
import com.yurioliveira.doacoes.model.services.DoadorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class DoacaoFormController implements Initializable{

    private Doacao entityDoacao;

    private Doador entityDoador;

    private DoacaoNormalService service;

    private DoadorService doadorService;

    private List<DataChangeListener> dataChangeListenerList = new ArrayList<>();

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

    public void subscribeDataChangeListener(DataChangeListener dataChangeListener) {
        dataChangeListenerList.add(dataChangeListener);
    }

    public void setDoacaoService(DoacaoNormalService service) {
        this.service = service;
    }

    public void setDoacao(Doacao entityDoacao) {
        this.entityDoacao = entityDoacao;
    }

    public void setDoador(Doador entityDoador) {
        this.entityDoador = entityDoador;
    }

    public void setDoadorService(DoadorService serviceDoador) {
        this.doadorService = serviceDoador;
    }

    @FXML
    public void onBtSalvarAction(ActionEvent event){
        Doacao doacao = createAndSaveDoacao();
        try {
            service.saveOrUpdate(doacao);
            Utils.currentStage(event).close();
            notifyDataChangeListeners();
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
        initializaNodes();
    }

    private void initializaNodes(){
        Constraints.setTextFieldMaxLength(txtApelidoDoador, 20);
        Constraints.setTextFieldMaxLength(txtContatoDoador, 15);
        Constraints.setTextFieldMaxLength(txtTipoDoacao, 30);
        Constraints.setTextFieldInteger(txtQuantidadeDoacao);
    }


    private void notifyDataChangeListeners() throws IllegalAccessException {
        for (DataChangeListener dataChangeListener : dataChangeListenerList) {
            dataChangeListener.onDataChanged();
        }
    }

    public Doacao createAndSaveDoacao(){
        try {
            entityDoacao = new Doacao();
            entityDoador = getFormDoador();
            doadorService.saveOrUpdate(entityDoador);
            entityDoacao = getFormDoacao();
            entityDoacao.setDoador(entityDoador);
        } catch (DbException e) {
            Alerts.showAlert("Erro na Criação e Salvamento da Doação", null, e.getMessage(), Alert.AlertType.ERROR);
        }
        return entityDoacao;
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

    private Doacao getFormDoacao() {
        Doador doador = getFormDoador();
        Doacao entity = new Doacao();

        try {
            entity.setId(Utils.tryParseToInt(txtIdDoacao.getText()));
            entity.setTipo(txtTipoDoacao.getText());
            entity.setQuantidade(Utils.tryParseToInt(txtQuantidadeDoacao.getText()));
            entity.setDoador(doador);
            entity.setData(new Date());
        } catch (NumberFormatException e) {
            Alerts.showAlert("Erro de Formato", "Dados Inválidos", "Verifique se os campos de ID e quantidade estão preenchidos corretamente.", Alert.AlertType.ERROR);
        }

        return entity;
    }

    public void updateDoacaoForm() {
        if (entityDoacao == null) {
            throw new IllegalStateException("O objeto Doacao não foi inicializado.");
        }
        txtIdDoacao.setText(String.valueOf(entityDoacao.getId()));
        txtTipoDoacao.setText(entityDoacao.getTipo());
        txtQuantidadeDoacao.setText(String.valueOf(entityDoacao.getQuantidade()));
    }

}
