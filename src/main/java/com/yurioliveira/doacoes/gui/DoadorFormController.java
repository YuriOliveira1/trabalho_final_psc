package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.gui.listeners.DataChangeListener;
import com.yurioliveira.doacoes.gui.util.Alerts;
import com.yurioliveira.doacoes.gui.util.Constraints;
import com.yurioliveira.doacoes.gui.util.Utils;
import com.yurioliveira.doacoes.model.entities.Doador;
import com.yurioliveira.doacoes.model.services.DoadorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DoadorFormController implements Initializable {

    private DoadorService doadorService;

    private Doador doador;

    private List<DataChangeListener> listeners = new ArrayList<>();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label label;

    @FXML
    private TextField textFieldId;

    @FXML
    private TextField textFieldApelido;

    @FXML
    private TextField textFieldContato;

    @FXML
    private Button buttonSalvar;

    @FXML
    private Button buttonCancelar;

    @FXML
    private void onBtSalvarAction(ActionEvent event) throws IllegalAccessException {
        doador = getFormDoador();
        doadorService.saveOrUpdate(doador);
        Utils.currentStage(event).close();
        notifyDataChangeListeners();
    }


    @FXML
    private void onBtCancelarAction(ActionEvent event) {
        Utils.currentStage(event).close();
    }


    private Doador getFormDoador() throws IllegalAccessException {
        Doador doador = new Doador();
        try {
            doador.setId(Utils.tryParseToInt(textFieldId.getText()));
            doador.setApelido(textFieldApelido.getText());
            doador.setContato(textFieldContato.getText());
        }  catch (NumberFormatException e) {
            Alerts.showAlert("Erro de Formato", "ID inválido", "O ID do doador deve ser um número inteiro.", Alert.AlertType.ERROR);
        }
        return doador;
    }


    private void notifyDataChangeListeners() throws IllegalAccessException {
        for (DataChangeListener listener : listeners) {
            listener.onDataChanged();
        }
    }

    public void setDoadorService(DoadorService doadorService){
        this.doadorService = doadorService;
    }

    public void setDoador(Doador doador){
        this.doador = doador;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeNodes();
    }

    public void initializeNodes(){
        Constraints.setTextFieldInteger(textFieldId);
        Constraints.setTextFieldMaxLength(textFieldApelido, 20);
        Constraints.setTextFieldMaxLength(textFieldContato, 20);
    }

    public void updateCartasForm() {
        if (doador == null) {
            throw new IllegalStateException("Cartas de Apoio não foi inicializado");
        }
        textFieldId.setText(String.valueOf(doador.getId()));
        textFieldApelido.setText(doador.getApelido());
        textFieldContato.setText(doador.getContato());
    }


    public void subscribeDataChangeListener(DataChangeListener dataChangeListener) {
        listeners.add(dataChangeListener);
    }
}
