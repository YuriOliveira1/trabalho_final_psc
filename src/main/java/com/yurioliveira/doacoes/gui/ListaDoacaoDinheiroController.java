package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.gui.util.Alerts;
import com.yurioliveira.doacoes.gui.util.Utils;
import com.yurioliveira.doacoes.model.entities.DoacaoDinheiro;
import com.yurioliveira.doacoes.model.entities.Doador;
import com.yurioliveira.doacoes.model.services.DoacaoDinheiroService;
import com.yurioliveira.doacoes.model.services.DoadorService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ListaDoacaoDinheiroController implements Initializable {

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

    private ObservableList<DoacaoDinheiro> obsDoacoes;

    private DoacaoDinheiroService doacaoDinheiroService;

    public void setDoacaoDinheiroService(DoacaoDinheiroService doacaoDinheiroService) {
        this.doacaoDinheiroService = doacaoDinheiroService;
    }

    private DoadorService doadorService;

    public void setDoadorService(DoadorService doadorService) {
        this.doadorService = doadorService;
    }

    @FXML
    public void onBtRegistrarAction(ActionEvent event) {
        Stage parent = Utils.currentStage(event);
        DoacaoDinheiro doacaoDinheiro = new DoacaoDinheiro();
        Doador doador = new Doador();
        createDoacaoDinheiroForm(doacaoDinheiro, parent);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void createDoacaoDinheiroForm(DoacaoDinheiro doacaoDinheiro, Stage parent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/yurioliveira/doacoes/DoacaoDinheiroForm.fxml"));
            Pane pane = loader.load();
            Doador doador = new Doador();

            DoacaoDinheiroFormController controller = loader.getController();

            controller.setDoadorDinheiroService(doacaoDinheiroService);
            controller.setDoadorService(doadorService);

            controller.setDoador(doador);
            controller.updateDoadorForm();

            controller.setDoacaoDinheiro(doacaoDinheiro);

            controller.subscribeDataChangeListener(this);
            controller.updateDoacaoDinheiroForm();

            Stage dialogStage = new Stage();

            dialogStage.setTitle("Cadastro de Doacao");
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
    }

    public void updateTableView() throws IllegalAccessException {
        if (doacaoDinheiroService == null) {
            throw new IllegalAccessException("Serviço com Erro");
        }

        List<DoacaoDinheiro> list = doacaoDinheiroService.findAll();
        obsDoacoes = FXCollections.observableArrayList(list);
        tableViewDoacoes.setItems(obsDoacoes);
    }
}
