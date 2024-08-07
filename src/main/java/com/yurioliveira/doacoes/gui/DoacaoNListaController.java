package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.Main;
import com.yurioliveira.doacoes.database.DbException;
import com.yurioliveira.doacoes.gui.listeners.DataChangeListener;
import com.yurioliveira.doacoes.gui.util.Alerts;
import com.yurioliveira.doacoes.gui.util.Utils;
import com.yurioliveira.doacoes.model.entities.Doacao;
import com.yurioliveira.doacoes.model.entities.Doador;
import com.yurioliveira.doacoes.model.services.DoacaoNormalService;
import com.yurioliveira.doacoes.model.services.DoadorService;
import javafx.beans.property.ReadOnlyObjectWrapper;
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
import java.util.Optional;
import java.util.ResourceBundle;

public class DoacaoNListaController implements Initializable, DataChangeListener {


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
    private TableColumn<Doacao, Doacao> tableColumnEDIT;

    @FXML
    private TableColumn<Doacao, Doacao> tableColumnDELETE;

    @FXML
    private Button btRegistrar;

    private ObservableList<Doacao> obsList;

    private DoadorService doadorService;

    private DoacaoNormalService doacaoNormalService;


    @FXML
    public void onBtnRegistrarAction(ActionEvent event) {
        Stage parent = Utils.currentStage(event);
        Doacao doacao = new Doacao();
        Doador doador = new Doador();
        createDoacaoForm(doacao, parent);
    }

    public void setDoacaoNormalService(DoacaoNormalService doacaoNormalService) {
        this.doacaoNormalService = doacaoNormalService;
    }

    public void setDoadorService(DoadorService doadorService) {
        this.doadorService = doadorService;
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

        Main.getPrincipalScene().getWindow();
    }

    public void updateTableView() throws IllegalAccessException {
        if (doacaoNormalService == null) {
            throw new IllegalAccessException("Serviço com Erro");
        }

        List<Doacao> list = doacaoNormalService.findAll();
        obsList = FXCollections.observableArrayList(list);
        tableViewDoacoes.setItems(obsList);
        initEditButtons();
        initRemoveButtons();
    }

    private void createDoacaoForm(Doacao doacao, Stage parentStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/yurioliveira/doacoes/DoacaoForm.fxml"));
            Pane pane = loader.load();
            Doador doador = new Doador();

            DoacaoFormController controller = loader.getController();
            controller.setDoacaoService(doacaoNormalService);
            controller.setDoadorService(doadorService);


            controller.setDoador(doador);
            controller.updateDoadorForm();

            controller.setDoacao(doacao);

            controller.subscribeDataChangeListener(this);
            controller.updateDoacaoForm();

            Stage dialogStage = new Stage();

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

    @Override
    public void onDataChanged() throws IllegalAccessException {
        updateTableView();
    }

    private void initEditButtons() {
        tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tableColumnEDIT.setCellFactory(param -> new TableCell<Doacao, Doacao>() {
            private final Button button = new Button("edit");

            @Override
            protected void updateItem(Doacao obj, boolean empty) {
                super.updateItem(obj, empty);
                if (empty || obj == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(button);

                button.setOnAction(
                        event -> updateDoacaoForm(obj, Utils.currentStage(event)));
            }
        });
    }

    private void updateDoacaoForm(Doacao doacao, Stage parentStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/yurioliveira/doacoes/DoacaoForm.fxml"));
            Pane pane = loader.load();

            DoacaoFormController controller = loader.getController();
            controller.setDoacaoService(doacaoNormalService);
            controller.setDoadorService(doadorService);

            if (doacao == null) {
                doacao = new Doacao();
                Doador doador = new Doador();
                doacao.setDoador(doador);
                controller.setDoacao(doacao);
                controller.setDoador(doador);
            } else {
                Doador doador = doadorService.findById(doacao.getDoador().getId());
                doacao.setDoador(doador);
                controller.setDoacao(doacao);
                controller.setDoador(doador);
            }

            controller.updateDoacaoForm();
            controller.updateDoadorForm();

            Stage dialogStage = new Stage();
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

    private void initRemoveButtons(){
        tableColumnDELETE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tableColumnDELETE.setCellFactory(param -> new TableCell<Doacao, Doacao>() {
            private final Button button = new Button("delete");

            @Override
            protected void updateItem(Doacao obj, boolean empty) {
                super.updateItem(obj, empty);

                if (empty || obj == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(button);
                button.setOnAction(event -> removeEntity(obj));
            }
        });
    }

    private void removeEntity(Doacao obj) {
        Optional<ButtonType> result = Alerts.showAlertConfirmation("Confirmação", "Certeza ao deletar este item?", null);

        if (result.get() == ButtonType.OK) {
            try {
                doacaoNormalService.delete(obj);
                updateTableView();
            } catch (IllegalAccessException e ) {
                Alerts.showAlert("Error ao remover objeto", null, e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }
}
