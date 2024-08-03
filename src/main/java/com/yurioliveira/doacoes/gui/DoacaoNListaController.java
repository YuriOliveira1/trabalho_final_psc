package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.Main;
import com.yurioliveira.doacoes.model.entities.Doacao;
import com.yurioliveira.doacoes.model.entities.Doador;
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
import java.util.ResourceBundle;

public class DoacaoNListaController implements Initializable {

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

    @FXML
    public void onBtnRegistrarAction() {
        System.out.println("VAPOOOOO");
    }

    public DoacaoNListaController() {
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
}
