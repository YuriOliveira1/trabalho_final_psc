package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.Main;
import com.yurioliveira.doacoes.gui.listeners.DataChangeListener;
import com.yurioliveira.doacoes.model.entities.CartaDeApoio;
import com.yurioliveira.doacoes.model.services.CartasService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CartasListaController implements Initializable {

    @FXML
    public ToolBar toolBar;

    @FXML
    public Label labelRegistro;

    @FXML
    private TableView<CartaDeApoio> tableView;

    @FXML
    private TableColumn<CartaDeApoio, Integer> tableColumnId;

    @FXML
    private TableColumn<CartaDeApoio, String> tableColumnNomeEscritor;

    @FXML
    private TableColumn<CartaDeApoio, String> tableColumnCarta;

    @FXML
    private Button btRegistrar;

    private ObservableList<CartaDeApoio> observableList;

    private CartasService cartasService;

    public void setCartaService(CartasService service){
        this.cartasService = service;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initalizeNodes();
    }

    private void initalizeNodes() {
        if (tableColumnId != null) {
            tableColumnId.setCellValueFactory(new PropertyValueFactory<CartaDeApoio, Integer>("idCarta"));
        }
        if (tableColumnNomeEscritor != null) {
            tableColumnNomeEscritor.setCellValueFactory(new PropertyValueFactory<CartaDeApoio, String>("nomeEscritor"));
        }
        if (tableColumnCarta != null) {
            tableColumnCarta.setCellValueFactory(new PropertyValueFactory<CartaDeApoio, String>("textoDaCarta"));
        }

        Main.getPrincipalScene().getWindow();
    }

    public void updateTableView(){
        if (cartasService == null){
            throw new IllegalStateException("Erro com o Serviço");
        }
        List<CartaDeApoio> listCartas = cartasService.findAll();
        observableList = FXCollections.observableArrayList(listCartas);
        tableView.setItems(observableList);
    }

    @FXML
    private void onBtRegistrarAction(ActionEvent actionEvent) {
        System.out.println("Teste");
    }

}
