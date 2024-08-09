package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.model.services.RelatorioService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RelatorioController implements Initializable {
    @FXML
    private TextField txtQtdDoacaoNormal;

    @FXML
    private TextField txtQtdDoacaoEmDinheiro;

    @FXML
    private TextField txtQtdCartasEnviadas;

    @FXML
    private TextField txtQtdTotalDoacoesFeitas;

    @FXML
    private TextField txtQtdTotalValorEmDinheiro;

    private RelatorioService relatorioService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setRelatorioService(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }
}
