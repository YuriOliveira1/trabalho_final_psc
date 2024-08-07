package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.Main;
import com.yurioliveira.doacoes.gui.util.Alerts;
import com.yurioliveira.doacoes.model.services.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemDoacaoNormal;

    @FXML
    private MenuItem menuItemDoacaoDinheiro;

    @FXML
    private MenuItem menuItemDoacaoCartaApoio;

    @FXML
    private MenuItem menuItemSobre;

    @FXML
    private MenuItem menuItemBuscar;

    @FXML
    public void onMenuItemDoacaoNormalAction() {
        loadView("/com/yurioliveira/doacoes/ListaDoacaoNormal.fxml", (DoacaoNListaController controller) -> {
            DoacaoNormalService doacaoNormalService = new DoacaoNormalService();
            DoadorService doadorService = new DoadorService();

            controller.setDoacaoNormalService(doacaoNormalService);
            controller.setDoadorService(doadorService);

            try {
                controller.updateTableView();
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @FXML
    public void onMenuItemDoacaoDinheiroAction() {
        loadView("/com/yurioliveira/doacoes/ListaDoacaoDinheiro.fxml", (ListaDoacaoDinheiroController controller) -> {
            DoacaoDinheiroService doacaoDinheiroService = new DoacaoDinheiroService();
            DoadorService doadorService = new DoadorService();

            controller.setDoacaoDinheiroService(doacaoDinheiroService);
            controller.setDoadorService(doadorService);

            try {
                controller.updateTableView();
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @FXML
    public void onMenuItemDoacaoCartaApoioAction() {
        loadView("/com/yurioliveira/doacoes/ListaCartas.fxml", (CartasListaController controller) -> {
            CartasService cartasService = new CartasService();
            controller.setCartaService(cartasService);

            controller.updateTableView();
        });
    }

    @FXML
    public void onMenuItemDoadorAction() {
        loadView("/com/yurioliveira/doacoes/DoadorList.fxml", (DoadorListController controller) -> {
            DoadorService doadorService = new DoadorService();
            controller.setDoadorService(doadorService);

            controller.updateTableView();
        });
    }

    @FXML
    public void onMenuItemSobreAction() {
        loadView("/com/yurioliveira/doacoes/About.fxml", x -> {});
    }

    @FXML
    public void onMenuGerarRelatorioAction() {
        loadView("/com/yurioliveira/doacoes/RelatorioList.fxml", (RelatorioController controller) -> {
            RelatorioService relatorioService = new RelatorioService();
            controller.setRelatorioService(relatorioService);
            try {
                controller.updateTextField();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private synchronized <T>void loadView(String pathName, Consumer<T> initializingAction) {
        try {
            URL fxmlLocation = getClass().getResource(pathName);
            if (fxmlLocation == null) {
                throw new IOException("FXML file not found at specified path.");
            }
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            VBox newVBox = loader.load();

            Scene principalScene = Main.getPrincipalScene();
            VBox mainVbox = (VBox) ((ScrollPane) principalScene.getRoot()).getContent();

            Node menu = mainVbox.getChildren().get(0);
            mainVbox.getChildren().clear();
            mainVbox.getChildren().add(menu);
            mainVbox.getChildren().addAll(newVBox.getChildren());

            T controller = loader.getController();
            initializingAction.accept(controller);
        } catch (IOException e) {
            e.printStackTrace();
            Alerts.showAlert("IO Exception", "Error ao Carregar a Pagina", e.getMessage(), Alert.AlertType.ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            Alerts.showAlert("Exception", "Erro Inesperado", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
