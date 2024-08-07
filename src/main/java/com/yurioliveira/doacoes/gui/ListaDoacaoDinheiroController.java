package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.model.entities.DoacaoDinheiro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Date;

public class ListaDoacaoDinheiroController {

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
    public void onBtRegistrarAction(ActionEvent event) {
        System.out.println("Teste");
    }
}
