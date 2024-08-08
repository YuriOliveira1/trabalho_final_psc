package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.Main;
import com.yurioliveira.doacoes.gui.listeners.DataChangeListener;
import com.yurioliveira.doacoes.gui.util.Alerts;
import com.yurioliveira.doacoes.gui.util.Utils;
import com.yurioliveira.doacoes.model.entities.CartaDeApoio;
import com.yurioliveira.doacoes.model.entities.Doacao;
import com.yurioliveira.doacoes.model.entities.Doador;
import com.yurioliveira.doacoes.model.services.CartasService;
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
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class DoadorListController implements Initializable, DataChangeListener {

    @FXML
    public ToolBar toolBar;

    @FXML
    public Label labelRegistro;

    @FXML
    private TableView<Doador> tableView;

    @FXML
    private TableColumn<Doador, Integer> tableColumnId;

    @FXML
    private TableColumn<Doador, String> tableColumnApelido;

    @FXML
    private TableColumn<Doador, String> tableColumnContato;

    @FXML
    private TableColumn<Doador, Doador> tableColumnEDIT;

    @FXML
    private TableColumn<Doador, Doador> tableColumnDELETE;

    private ObservableList<Doador> observableList;

    private List<DataChangeListener> listeners;

    private DoadorService doadorService;

    public void setDoadorService(DoadorService doadorService) {
        this.doadorService = doadorService;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initalizeNodes();
    }

    private void initalizeNodes() {
        if (tableColumnId != null) {
            tableColumnId.setCellValueFactory(new PropertyValueFactory<Doador, Integer>("id"));
        }
        if (tableColumnApelido != null) {
            tableColumnApelido.setCellValueFactory(new PropertyValueFactory<Doador, String>("apelido"));
        }
        if (tableColumnContato != null) {
            tableColumnContato.setCellValueFactory(new PropertyValueFactory<Doador, String>("contato"));
        }

        Main.getPrincipalScene().getWindow();
    }

    public void updateTableView() {
        if (doadorService == null) {
            throw new IllegalStateException("Erro com o Serviço");
        }
        List<Doador> listDoador = doadorService.findAll();
        observableList = FXCollections.observableArrayList(listDoador);
        tableView.setItems(observableList);
        initEditButtons();
        initRemoveButtons();
    }

    @Override
    public void onDataChanged() throws IllegalAccessException {
        updateTableView();
    }

    private void initEditButtons() {
        tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tableColumnEDIT.setCellFactory(param -> new TableCell<Doador, Doador>() {
            private final Button button = new Button("edit");

            @Override
            protected void updateItem(Doador obj, boolean empty) {
                super.updateItem(obj, empty);
                if (obj == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction(
                        event -> updateDialogForm(
                                obj, Utils.currentStage(event)));
            }
        });
    }

    private void updateDialogForm(Doador obj, Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/yurioliveira/doacoes/DoadorForm.fxml"));
            Pane pane = loader.load();

            DoadorFormController controller = loader.getController();

            controller.setDoadorService(doadorService);

            if (obj == null) {
                obj = new Doador();
                controller.setDoador(obj);
            } else {
                Doador doador = doadorService.findById(obj.getId());
                controller.setDoador(doador);
            }

            controller.subscribeDataChangeListener(this);
            controller.updateCartasForm();

            Stage dialogStage = new Stage();

            dialogStage.setTitle("Cadastro de Doacao");
            dialogStage.setScene(new Scene(pane));
            dialogStage.setResizable(false);
            dialogStage.initOwner(stage);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.showAndWait();
        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Erro de Carregamento de Tela", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private void initRemoveButtons(){
        tableColumnDELETE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tableColumnDELETE.setCellFactory(param -> new TableCell<Doador, Doador>() {
            private final Button button = new Button("delete");

            @Override
            protected void updateItem(Doador obj, boolean empty) {
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

    private void removeEntity(Doador obj) {
        Optional<ButtonType> result = Alerts.showAlertConfirmation("Confirmação", "Certeza ao deletar este item?", null);

        if (result.get() == ButtonType.OK) {
            doadorService.delete(obj);
            updateTableView();
        }
    }
}