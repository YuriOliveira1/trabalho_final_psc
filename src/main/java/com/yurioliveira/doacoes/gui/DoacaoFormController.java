package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.database.DbException;
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
import java.util.Date;
import java.util.ResourceBundle;

public class DoacaoFormController implements Initializable {

    private Doacao entityDoacao;

    private Doador entityDoador;

    private DoacaoNormalService service;

    private DoadorService doadorService = new DoadorService();

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

    public void setDoacaoService(DoacaoNormalService service) {
        this.service = service;
    }

    public void setDoacao(Doacao entityDoacao) {
        this.entityDoacao = entityDoacao;
    }

    public void setDoador(Doador entityDoador) {
        this.entityDoador = entityDoador;
    }

    @FXML
    public void onBtSalvarAction(ActionEvent event){
        Doacao doacao = createAndSaveDoacao();
        try {
            service.saveOrUpdate(doacao);
            Utils.currentStage(event).close();
        } catch (DbException e) {
            Alerts.showAlert("Erro ao Salvar Doação", null, e.getMessage(), Alert.AlertType.ERROR);
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

    private Doador getFormDoador(){
        Doador doador = new Doador();

        doador.setId(Utils.tryParseToInt(txtIdDoador.getText()));
        doador.setApelido(txtApelidoDoador.getText());
        doador.setContato(txtContatoDoador.getText());

        return doador;
    }

    private Doacao getFormDoacao() {
        Doador doador = getFormDoador();

        Doacao entity = new Doacao();

        entity.setId(Utils.tryParseToInt(txtIdDoacao.getId()));
        entity.setTipo(txtTipoDoacao.getText());
        entity.setQuantidade(Utils.tryParseToInt(txtQuantidadeDoacao.getText()));
        entity.setDoador(doador);
        entity.setData(new Date());

        return entity;
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

    public void updateDoacaoForm(){
        if (entityDoacao == null){
            throw new IllegalStateException();
        }
        txtIdDoacao.setText(String.valueOf(entityDoacao.getId()));
        txtTipoDoacao.setText(entityDoacao.getTipo());
        txtQuantidadeDoacao.setText(String.valueOf(entityDoacao.getQuantidade()));
    }

    public void updateDoadorForm(){
        if (entityDoador == null){
            throw new IllegalStateException();
        }
        txtIdDoador.setText(String.valueOf(entityDoador.getId()));
        txtApelidoDoador.setText(entityDoador.getApelido());
        txtContatoDoador.setText(entityDoador.getContato());
    }
}
