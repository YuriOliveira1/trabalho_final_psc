package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.Main;
import com.yurioliveira.doacoes.model.entities.Doacao;
import com.yurioliveira.doacoes.model.services.DoacaoNormalService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class DoacaoNListaController implements Initializable {

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
    private TableColumn<Doacao, Integer> tableColumnIdDoador;

    @FXML
    private TableColumn<Doacao, Date> tableColumnDataDoacao;

    @FXML
    private Button btRegistrar;

    @FXML
    private ScrollPane scrollPane;

    private ObservableList<Doacao> obsList;

    @FXML
    public void onBtnRegistrarAction() {
        System.out.println("VAPOOOOO");
    }

    public DoacaoNListaController() {
    }

    public void setDoacaoNormalService(DoacaoNormalService doacaoNormalService) {
        this.doacaoNormalService = doacaoNormalService;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeNodes();
        tableViewDoacoes.prefWidthProperty().bind(scrollPane.widthProperty());
        tableViewDoacoes.prefHeightProperty().bind(scrollPane.heightProperty());
    }

    private void initializeNodes() {
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tableColumnQtd.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        tableColumnIdDoador.setCellValueFactory(new PropertyValueFactory<>("doadorId"));
        tableColumnDataDoacao.setCellValueFactory(new PropertyValueFactory<>("data"));

        Stage stage = (Stage) Main.getPrincipalScene().getWindow();
        tableViewDoacoes.prefWidthProperty().bind(stage.heightProperty());
        tableViewDoacoes.prefWidthProperty().bind(stage.widthProperty());
    }

    public void updateTableView() throws IllegalAccessException {
        if (doacaoNormalService == null) {
            throw new IllegalAccessException("Serviço com Erro");
        }

        List<Doacao> list = doacaoNormalService.findAll();
        obsList = FXCollections.observableArrayList(list);
        tableViewDoacoes.setItems(obsList);
    }
}
