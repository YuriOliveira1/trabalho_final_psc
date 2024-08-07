package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.model.entities.DoacaoDinheiro;
import com.yurioliveira.doacoes.model.services.DoacaoDinheiroService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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

    @FXML
    public void onBtRegistrarAction(ActionEvent event) {
        System.out.println("Teste");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void initilizeNodes(){}

    public void updateTableView() throws IllegalAccessException {
        if (doacaoDinheiroService == null) {
            throw new IllegalAccessException("Serviço com Erro");
        }

        List<DoacaoDinheiro> list = doacaoDinheiroService.findAll();
        obsDoacoes = FXCollections.observableArrayList(list);
        tableViewDoacoes.setItems(obsDoacoes);
    }
}
