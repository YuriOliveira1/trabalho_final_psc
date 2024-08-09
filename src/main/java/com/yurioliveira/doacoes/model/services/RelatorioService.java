package com.yurioliveira.doacoes.model.services;

import com.yurioliveira.doacoes.model.dao.impl.DaoFactory;
import com.yurioliveira.doacoes.model.dao.impl.RelatorioJDBC;

import java.sql.SQLException;

public class RelatorioService {

    private RelatorioJDBC relatorioJDBC = DaoFactory.createRelatorioDao();

    public Integer getQtdDoacaoNormal() throws SQLException {
        return relatorioJDBC.countQtdDoacoesNormais();
    }

    public Integer getQtdDoacaoEmDinheiro() throws SQLException {
        return relatorioJDBC.countQtdDoacoesEmDinheiro();

    }

    public Integer getQtdCartasEnviadas() throws SQLException {
        return relatorioJDBC.countQtdCartasEnviadas();
    }

    public Float getValorTotal() throws SQLException {
        return relatorioJDBC.totalValorDoacaoDinheiro();
    }

    public Integer getTotalDeDoacaoEnviadas() throws SQLException {
        Integer sum = getQtdDoacaoNormal() + getQtdDoacaoEmDinheiro() + getQtdCartasEnviadas();
        return sum;
    }
}
