package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.gui.util.Alerts;
import com.yurioliveira.doacoes.gui.util.Utils;
import com.yurioliveira.doacoes.model.entities.CartaDeApoio;
import com.yurioliveira.doacoes.model.services.CartasService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CartasFormController implements Initializable {

    private CartasService cartasService;

    private CartaDeApoio cartaDeApoio;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label label;

    @FXML
    private TextField textFieldId;

    @FXML
    private TextField textFieldNomeEscritor;

    @FXML
    private TextArea textFieldTexto;

    @FXML
    private Button buttonSalvar;

    @FXML
    private Button buttonCancelar;

    @FXML
    private void onBtSalvarAction(ActionEvent event) {
        cartaDeApoio = getFormCarta();
        cartasService.insert(cartaDeApoio);
    }

    private CartaDeApoio getFormCarta() {
        CartaDeApoio carta = new CartaDeApoio();
        try {
            carta.setIdCarta(Utils.tryParseToInt(textFieldId.getText()));
            carta.setNomeEscritor(textFieldNomeEscritor.getText());
            carta.setTextoDaCarta(textFieldTexto.getText());
        }  catch (NumberFormatException e) {
            Alerts.showAlert("Erro de Formato", "ID inválido", "O ID do doador deve ser um número inteiro.", Alert.AlertType.ERROR);
        }
        return carta;
    }


    @FXML
    private void onBtCancelarAction(ActionEvent event) {
        Utils.currentStage(event).close();
    }

    public void setCartasService(CartasService cartasService){
        this.cartasService = cartasService;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void updateCartasForm() {
    }
}
