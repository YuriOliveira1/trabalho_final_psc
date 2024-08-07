package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.Main;
import com.yurioliveira.doacoes.gui.listeners.DataChangeListener;
import com.yurioliveira.doacoes.gui.util.Alerts;
import com.yurioliveira.doacoes.gui.util.Utils;
import com.yurioliveira.doacoes.model.entities.CartaDeApoio;
import com.yurioliveira.doacoes.model.services.CartasService;
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
import java.util.ResourceBundle;

public class CartasListaController implements Initializable, DataChangeListener {

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

    @FXML
    private TableColumn<CartaDeApoio, CartaDeApoio> tableColumnEDIT;

    private ObservableList<CartaDeApoio> observableList;

    private List<DataChangeListener> listeners;

    private CartasService cartasService;

    public void setCartaService(CartasService service){
        this.cartasService = service;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initalizeNodes();
        initEditButtons();
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
        Stage parent = Utils.currentStage(actionEvent);
        CartaDeApoio carta = new CartaDeApoio();
        createCartasForm(carta, parent);
    }

    private void createCartasForm(CartaDeApoio cartaDeApoio, Stage parentStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/yurioliveira/doacoes/CartasForm.fxml"));
            Pane pane = loader.load();

            CartasFormController controller = loader.getController();

            controller.setCartasService(cartasService);

            controller.subscribeDataChangeListener(this);
            controller.updateCartasForm();

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
        tableColumnEDIT.setCellFactory(param -> new TableCell<CartaDeApoio, CartaDeApoio>() {
            private final Button button = new Button("edit");
            @Override
            protected void updateItem(CartaDeApoio obj, boolean empty) {
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

    private void updateDialogForm(CartaDeApoio obj, Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/yurioliveira/doacoes/CartasForm.fxml"));
            Pane pane = loader.load();

            CartasFormController controller = loader.getController();

            controller.setCartasService(cartasService);

            if (obj == null) {
                obj = new CartaDeApoio();
                controller.setCartaDeApoio(obj);
            } else {
                CartaDeApoio carta = cartasService.findById(obj.getIdCarta());
                controller.setCartaDeApoio(carta);
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
}
