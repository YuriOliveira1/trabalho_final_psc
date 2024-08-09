package com.yurioliveira.doacoes.gui;

import com.yurioliveira.doacoes.model.entities.Relatorio;
import com.yurioliveira.doacoes.model.services.RelatorioService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
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

    public void updateTextField() throws SQLException {
        if (relatorioService == null) {
            throw new IllegalStateException("Erro com o Serviço");
        }

        Relatorio relatorio = relatorioService.getRelatorio();
        if (relatorio != null) {
            txtQtdDoacaoNormal.setText(String.valueOf(relatorio.getQtdDoacaoNormais()));
            txtQtdDoacaoEmDinheiro.setText(String.valueOf(relatorio.getQtdDoacaoEmDinheiro()));
            txtQtdCartasEnviadas.setText(String.valueOf(relatorio.getQtdCartasEnviadas()));
            txtQtdTotalDoacoesFeitas.setText(String.valueOf(relatorio.getQtdDoacaoTotais()));
            txtQtdTotalValorEmDinheiro.setText(String.valueOf(relatorio.getQtdValorEmDinheiroDoado()));
        } else {
            System.out.println("Deu Pau");
        }

    }
}
