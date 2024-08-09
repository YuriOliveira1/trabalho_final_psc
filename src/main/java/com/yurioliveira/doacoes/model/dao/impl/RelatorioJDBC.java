package com.yurioliveira.doacoes.model.dao.impl;

import com.yurioliveira.doacoes.database.DB;
import com.yurioliveira.doacoes.database.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RelatorioJDBC {

    private Connection conn;

    public RelatorioJDBC(Connection conn) {
        this.conn = conn;
    }

    public Integer countQtdDoacoesNormais() throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT SUM(quantidade) AS valorDoacao FROM doacao");
            rs = st.executeQuery();
            if (rs.next()) {
                return Integer.valueOf(rs.getString(1));
            } else {
                return 0;
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    public Integer countQtdDoacoesEmDinheiro() throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT COUNT(*) FROM dinheiro");
            rs = st.executeQuery();
            if (rs.next()) {
                return Integer.valueOf(rs.getString(1));
            } else {
                return 0;
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    public Integer countQtdCartasEnviadas() throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT COUNT(*) FROM cartaapoio");
            rs = st.executeQuery();
            if (rs.next()) {
                return Integer.valueOf(rs.getString(1));
            } else {
                return 0;
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    public Float totalValorDoacaoDinheiro() throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT SUM(valor) AS valorDoacao FROM dinheiro");
            rs = st.executeQuery();
            if (rs.next()) {
                return Float.valueOf(rs.getString(1));
            } else {
                return 0f;
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }
}
