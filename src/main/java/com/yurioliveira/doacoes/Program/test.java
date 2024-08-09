package com.yurioliveira.doacoes.Program;

import com.yurioliveira.doacoes.model.dao.impl.*;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {
        RelatorioJDBC relatorioJDBC = DaoFactory.createRelatorioDao();
        DoacaoDinheiroJDBC doacaoDinheiroJDBC = (DoacaoDinheiroJDBC) DaoFactory.createDinheiroDao();

        Integer qtdDoacaoNormal = relatorioJDBC.countQtdDoacoesNormais();
        Integer qtdDoacaoEmDinheiro = relatorioJDBC.countQtdDoacoesEmDinheiro();
        Integer qtdCartasEnviadas = relatorioJDBC.countQtdCartasEnviadas();
        Float valorTotal = relatorioJDBC.totalValorDoacaoDinheiro();

        System.out.println("QTD DOACAO NORMAL: " + qtdDoacaoNormal);
        System.out.println("QTD DOACAO EM DINHEIRO: " + qtdDoacaoEmDinheiro);
        System.out.println("QTD CARTAS ENVIADAS: " + qtdCartasEnviadas);
        System.out.println("VALOR TOTAL ENVIADO: " + valorTotal);
    }
}
