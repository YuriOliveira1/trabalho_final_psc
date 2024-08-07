package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.gui.listeners.DataChangeListener;
import com.yurioliveira.doacoes.gui.util.Alerts;
import com.yurioliveira.doacoes.gui.util.Constraints;
import com.yurioliveira.doacoes.gui.util.Utils;
import com.yurioliveira.doacoes.model.entities.CartaDeApoio;
import com.yurioliveira.doacoes.model.services.CartasService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CartasFormController implements Initializable {

    private CartasService cartasService;

    private CartaDeApoio cartaDeApoio;

    private List<DataChangeListener> listeners = new ArrayList<>();

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
    private void onBtSalvarAction(ActionEvent event) throws IllegalAccessException {
        cartaDeApoio = getFormCarta();
        cartasService.saveOrUpdate(cartaDeApoio);
        Utils.currentStage(event).close();
        notifyDataChangeListeners();
    }


    @FXML
    private void onBtCancelarAction(ActionEvent event) {
        Utils.currentStage(event).close();
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


    private void notifyDataChangeListeners() throws IllegalAccessException {
        for (DataChangeListener listener : listeners) {
            listener.onDataChanged();
        }
    }

    public void setCartasService(CartasService cartasService){
        this.cartasService = cartasService;
    }

    public void setCartaDeApoio(CartaDeApoio cartaDeApoio){
        this.cartaDeApoio = cartaDeApoio;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeNodes();
    }

    public void initializeNodes(){
        Constraints.setTextFieldInteger(textFieldId);
        Constraints.setTextFieldMaxLength(textFieldNomeEscritor, 20);
        Constraints.setTextAreaMaxLength(textFieldTexto, 255);
    }

    public void updateCartasForm() {
        if (cartaDeApoio == null) {
            throw new IllegalStateException("Cartas de Apoio não foi inicializado");
        }
        textFieldId.setText(String.valueOf(cartaDeApoio.getIdCarta()));
        textFieldNomeEscritor.setText(cartaDeApoio.getNomeEscritor());
        textFieldTexto.setText(cartaDeApoio.getTextoDaCarta());
    }


    public void subscribeDataChangeListener(DataChangeListener dataChangeListener) {
        listeners.add(dataChangeListener);
    }
}
