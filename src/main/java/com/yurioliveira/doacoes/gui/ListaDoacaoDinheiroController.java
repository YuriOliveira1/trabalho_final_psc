package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.Main;
import com.yurioliveira.doacoes.gui.listeners.DataChangeListener;
import com.yurioliveira.doacoes.gui.util.Alerts;
import com.yurioliveira.doacoes.gui.util.Utils;
import com.yurioliveira.doacoes.model.entities.DoacaoDinheiro;
import com.yurioliveira.doacoes.model.entities.Doador;
import com.yurioliveira.doacoes.model.services.DoacaoDinheiroService;
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

public class ListaDoacaoDinheiroController implements Initializable, DataChangeListener {

    @FXML
    private TableView<DoacaoDinheiro> tableViewDoacoes;

    @FXML
    private TableColumn<DoacaoDinheiro, Integer> tableColumnId;

    @FXML
    private TableColumn<DoacaoDinheiro, Float> tableColumnValor;

    @FXML
    private TableColumn<DoacaoDinheiro, String> tableColumnNome;

    @FXML
    private TableColumn<DoacaoDinheiro, Date> tableColumnData;

    @FXML
    private Button btRegistrar;

    @FXML
    private TableColumn<DoacaoDinheiro, DoacaoDinheiro> tableColumnEDIT;

    @FXML
    private TableColumn<DoacaoDinheiro, DoacaoDinheiro> tableColumnREMOVE;

    private ObservableList<DoacaoDinheiro> obsDoacoes;

    private DoacaoDinheiroService doacaoDinheiroService;

    private DoadorService doadorService;

    public void setDoacaoDinheiroService(DoacaoDinheiroService doacaoDinheiroService) {
        this.doacaoDinheiroService = doacaoDinheiroService;
    }

    public void setDoadorService(DoadorService doadorService) {
        this.doadorService = doadorService;
    }

    @FXML
    public void onBtRegistrarAction(ActionEvent event) {
        Stage parent = Utils.currentStage(event);
        DoacaoDinheiro doacaoDinheiro = new DoacaoDinheiro();
        Doador doador = new Doador();
        createDoacaoDinheiroForm(doacaoDinheiro, doador, parent);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initilizeNodes();
    }

    private void createDoacaoDinheiroForm(DoacaoDinheiro doacaoDinheiro, Doador doador, Stage parent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/yurioliveira/doacoes/DoacaoDinheiroForm.fxml"));
            Pane pane = loader.load();

            DoacaoDinheiroFormController controller = loader.getController();

            controller.setDoadorDinheiroService(doadorService);

            controller.setDoador(doador);
            controller.updateDoadorForm();

            controller.setDoacaoDinheiro(doacaoDinheiro);

            controller.subscribeDataChangeListener(this);
            controller.updateDoacaoDinheiroForm();

            Stage dialogStage = new Stage();

            dialogStage.setTitle("Cadastro de Doacao em Dinheiro");
            dialogStage.setScene(new Scene(pane));
            dialogStage.setResizable(false);
            dialogStage.initOwner(parent);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.showAndWait();
            System.out.println(doador.getId());
        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Erro de Carregamento de Tela", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private void updateDoacaoDinheiroForm(DoacaoDinheiro doacaoDinheiro ,Stage parent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/yurioliveira/doacoes/DoacaoDinheiroForm.fxml"));
            Pane pane = loader.load();

            DoacaoDinheiroFormController controller = loader.getController();

            controller.setDoadorDinheiroService(doadorService);

            controller.setDoacaoDinheiro(doacaoDinheiro);
            controller.setDoador(doadorService.findById(50));
            if (doacaoDinheiro.getDoador() == null) {
                System.out.println("O doador em doacaoDinheiro é null.");
            } else {
                System.out.println("ID do doador: " + doacaoDinheiro.getDoador().getId());
            }
            controller.updateDoacaoDinheiroForm();
            controller.updateDoadorForm();

            controller.subscribeDataChangeListener(this);
            controller.updateDoacaoDinheiroForm();

            Stage dialogStage = new Stage();

            dialogStage.setTitle("Atualização de Doação em Dinheiro");
            dialogStage.setScene(new Scene(pane));
            dialogStage.setResizable(false);
            dialogStage.initOwner(parent);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.showAndWait();
        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Erro de Carregamento de Tela", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }


    private void initilizeNodes() {
        if (tableColumnId != null) {
            tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        }
        if (tableColumnValor != null) {
            tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        }
        if (tableColumnNome != null) {
            tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nomeConta"));
        }
        if (tableColumnData != null) {
            tableColumnData.setCellValueFactory(new PropertyValueFactory<>("data"));
        }

        Main.getPrincipalScene().getWindow();
    }

    public void updateTableView() throws IllegalAccessException {
        if (doacaoDinheiroService == null) {
            throw new IllegalAccessException("Serviço com Erro");
        }

        List<DoacaoDinheiro> list = doacaoDinheiroService.findAll();
        obsDoacoes = FXCollections.observableArrayList(list);
        tableViewDoacoes.setItems(obsDoacoes);
        initEditButtons();
        initRemoveButtons();
    }

    @Override
    public void onDataChanged() throws IllegalAccessException {
        updateTableView();
    }

    private void initEditButtons() {
        tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tableColumnEDIT.setCellFactory(param -> new TableCell<DoacaoDinheiro, DoacaoDinheiro>() {
            private final Button button = new Button("edit");

            @Override
            protected void updateItem(DoacaoDinheiro dd, boolean empty) {
                super.updateItem(dd, empty);
                if (empty || dd == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(button);

                button.setOnAction(
                        event -> updateDoacaoDinheiroForm(dd, Utils.currentStage(event)));
            }
        });
    }

    private void initRemoveButtons() {
        tableColumnREMOVE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tableColumnREMOVE.setCellFactory(param -> new TableCell<DoacaoDinheiro, DoacaoDinheiro>() {
            private final Button button = new Button("remove");

            @Override
            protected void updateItem(DoacaoDinheiro obj, boolean empty) {
                super.updateItem(obj, empty);
                if (obj == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction(event -> removeEntity(obj));
            }
        });
    }


    private void removeEntity(DoacaoDinheiro obj) {
        Optional<ButtonType> result = Alerts.showAlertConfirmation("Confirmação", "Certeza ao deletar este item?", null);

        if (result.get() == ButtonType.OK) {
            try {
                doacaoDinheiroService.delete(obj);
                updateTableView();
            } catch (IllegalAccessException e) {
                Alerts.showAlert("Error ao remover objeto", null, e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }
}

