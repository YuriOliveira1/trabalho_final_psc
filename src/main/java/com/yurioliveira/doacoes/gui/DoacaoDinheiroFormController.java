package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.database.DbException;
import com.yurioliveira.doacoes.gui.listeners.DataChangeListener;
import com.yurioliveira.doacoes.gui.util.Alerts;
import com.yurioliveira.doacoes.gui.util.Constraints;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

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


    @FXML
    public void onBtSalvarActionD(ActionEvent event) {
        DoacaoDinheiro doacaoD = createAndSaveDoacao();
        try {
            doacaoDinheiroService.saveOrUpdate(doacaoD);
            Utils.currentStage(event).close();
            notifyDataChangeListeners();
        } catch (DbException | IllegalAccessException e) {
            Alerts.showAlert("Erro ao Salvar Doação", null, e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void notifyDataChangeListeners() throws IllegalAccessException {
        for (DataChangeListener dataChangeListener : dataChangeListenerList) {
            dataChangeListener.onDataChanged();
        }
    }

    @FXML
    public void onBtCancelarActionD(ActionEvent event) {
        Utils.currentStage(event).close();
    }

    private Doador entityDoador;

    private DoadorService doadorService;

    private DoacaoDinheiro entityDoacaoDinheiro;

    private DoacaoDinheiroService doacaoDinheiroService = new DoacaoDinheiroService();

    private List<DataChangeListener> dataChangeListenerList = new ArrayList<>();

    public void subscribeDataChangeListener(DataChangeListener dataChangeListener) {
        dataChangeListenerList.add(dataChangeListener);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeNodes();
    }

    private void initializeNodes() {
        Constraints.setTextFieldFloat(txtValorDoacao);
        Constraints.setTextFieldMaxLength(txtApelidoDoador, 20);
        Constraints.setTextFieldMaxLength(txtContatoDoador, 15);
        Constraints.setTextFieldMaxLength(txtNomeConta, 15);
        txtIdDoador.setText("");
    }

    private DoacaoDinheiro createAndSaveDoacao() {
        try {
            entityDoacaoDinheiro = getFormDoacaoDinheiro();
            entityDoador = entityDoacaoDinheiro.getDoador();
            if (entityDoador != null) {
                doadorService.saveOrUpdate(entityDoador);
            }
            doacaoDinheiroService.saveOrUpdate(entityDoacaoDinheiro);
            return entityDoacaoDinheiro;
        } catch (DbException e) {
            Alerts.showAlert("Erro na Criação e Salvamento da Doação", null, e.getMessage(), Alert.AlertType.ERROR);
            return null;
        }
    }

    private DoacaoDinheiro getFormDoacaoDinheiro() {
        Doador doador = getFormDoador();
        DoacaoDinheiro doacaoDinheiro = new DoacaoDinheiro();
        try {
            doacaoDinheiro.setId(Utils.tryParseToInt(txtIdDoacaoDinheiro.getText()));
            doacaoDinheiro.setValor(Utils.tryParseToFloat(txtValorDoacao.getText()));
            doacaoDinheiro.setNomeConta(txtNomeConta.getText());
            doacaoDinheiro.setDoador(doador);
            Instant instant = Instant.from(txtDataDoacao.getValue().atStartOfDay(ZoneId.systemDefault()));
            doacaoDinheiro.setData(Date.from(instant));
        } catch (NumberFormatException e) {
            Alerts.showAlert("Erro de Formato", "Dados Inválidos", "Verifique se os campos de ID e quantidade estão preenchidos corretamente.", Alert.AlertType.ERROR);
        }
        return doacaoDinheiro;
    }

    public void setDoador(Doador entityDoador) {
        this.entityDoador = entityDoador;
        System.out.println("entityDoador inicializado com ID: " + (entityDoador != null ? entityDoador.getId() : "null"));
    }

    public void setDoadorDinheiroService(DoadorService doadorService) {
        this.doadorService = doadorService;
    }

    public void setDoacaoDinheiro(DoacaoDinheiro doacaoDinheiro) {
        this.entityDoacaoDinheiro = doacaoDinheiro;
    }


    private Doador getFormDoador() {
        Doador doador = new Doador();
        String idText = txtIdDoador.getText();
        System.out.println("Valor do campo txtIdDoador: " + idText);
        try {
            Integer id = Utils.tryParseToInt(idText);
            if (id != null) {
                doador.setId(id);
                System.out.println("ID do doador definido como: " + id);
            } else {
                System.out.println("DOACAODINHEIROFORM CONTROLLER ID do doador não foi definido. Valor do campo: " + idText);
            }
            doador.setApelido(txtApelidoDoador.getText());
            doador.setContato(txtContatoDoador.getText());
        } catch (NumberFormatException e) {
            Alerts.showAlert("Erro de Formato", "ID inválido", "O ID do doador deve ser um número inteiro.", Alert.AlertType.ERROR);
            System.out.println("Erro ao converter ID para inteiro: " + e.getMessage());
        }
        return doador;
    }

    public void updateDoadorForm() {
        if (entityDoador == null) {
            System.out.println("entityDoador não foi inicializado");
            throw new IllegalStateException("Doador não foi inicializado");
        }
        txtIdDoador.setText(String.valueOf(entityDoador.getId()));
        txtApelidoDoador.setText(entityDoador.getApelido());
        txtContatoDoador.setText(entityDoador.getContato());

        System.out.println("ID do doador atualizado para: " + entityDoador.getId());
    }
    public void updateDoacaoDinheiroForm() {
        if (entityDoacaoDinheiro == null) {
            throw new IllegalStateException("O objeto Doacao não foi inicializado.");
        }
        txtIdDoacaoDinheiro.setText(String.valueOf(entityDoacaoDinheiro.getId()));
        txtValorDoacao.setText(String.valueOf(entityDoacaoDinheiro.getValor()));
        txtNomeConta.setText(entityDoacaoDinheiro.getNomeConta());
        Locale.setDefault(Locale.US);
        if (entityDoacaoDinheiro.getData() != null) {
            java.sql.Date sqlDate = (java.sql.Date) entityDoacaoDinheiro.getData();
            LocalDate localDate = sqlDate.toLocalDate();
            txtDataDoacao.setValue(localDate);
        }
    }
}

