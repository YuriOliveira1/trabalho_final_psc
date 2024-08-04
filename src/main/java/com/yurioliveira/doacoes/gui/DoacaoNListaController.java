package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.Main;
import com.yurioliveira.doacoes.gui.util.Alerts;
import com.yurioliveira.doacoes.gui.util.Utils;
import com.yurioliveira.doacoes.model.entities.Doacao;
import com.yurioliveira.doacoes.model.services.DoacaoNormalService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class DoacaoNListaController implements Initializable {

    @FXML
    public ToolBar toolBar;

    @FXML
    public Label labelRegistro;

    private DoacaoNormalService doacaoNormalService;

    @FXML
    private TableView<Doacao> tableViewDoacoes;

    @FXML
    private TableColumn<Doacao, Integer> tableColumnId;

    @FXML
    private TableColumn<Doacao, String> tableColumnTipo;

    @FXML
    private TableColumn<Doacao, Integer> tableColumnQtd;

    @FXML
    private TableColumn<Doacao, Date> tableColumnDataDoacao;

    @FXML
    private Button btRegistrar;

    @FXML
    private ScrollPane scrollPane;

    private ObservableList<Doacao> obsList;

    @FXML
    public void onBtnRegistrarAction(ActionEvent event) {
        Stage parent = Utils.currentStage(event);
        createDoacaoForm(parent);
    }

    public DoacaoNListaController() {
    }

    public void setDoacaoNormalService(DoacaoNormalService doacaoNormalService) {
        this.doacaoNormalService = doacaoNormalService;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeNodes();
    }

    private void initializeNodes() {
        if (tableColumnId != null) {
            tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        }
        if (tableColumnTipo != null) {
            tableColumnTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        }
        if (tableColumnQtd != null) {
            tableColumnQtd.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        }
        if (tableColumnDataDoacao != null) {
            tableColumnDataDoacao.setCellValueFactory(new PropertyValueFactory<>("data"));
        }

        Stage stage = (Stage) Main.getPrincipalScene().getWindow();
    }

    public void updateTableView() throws IllegalAccessException {
        if (doacaoNormalService == null) {
            throw new IllegalAccessException("Serviço com Erro");
        }

        List<Doacao> list = doacaoNormalService.findAll();
        obsList = FXCollections.observableArrayList(list);
        tableViewDoacoes.setItems(obsList);
    }

    private void createDoacaoForm(Stage parentStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/yurioliveira/doacoes/DoacaoForm.fxml"));
            Pane pane = loader.load();
            System.out.println("Pane loaded successfully");

            Stage dialogStage = new Stage();
            System.out.println("Stage loaded successfully");

            dialogStage.setTitle("Cadastro de Doacao");
            dialogStage.setScene(new Scene(pane));
            dialogStage.setResizable(false);
            dialogStage.initOwner(parentStage);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.showAndWait();
        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Erro de Carregamento de Tela", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }
}
