package com.yurioliveira.doacoes.model.dao.impl;


import com.yurioliveira.doacoes.database.*;
import com.yurioliveira.doacoes.model.dao.DAO;
import com.yurioliveira.doacoes.model.entities.DoacaoDinheiro;
import com.yurioliveira.doacoes.model.entities.Doador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoacaoDinheiroJDBC implements DAO<DoacaoDinheiro> {

    private Connection conn;

    public DoacaoDinheiroJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(DoacaoDinheiro obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "INSERT INTO dinheiro (valor, nomeConta, doador_id, data) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setFloat(1, obj.getValor());
            st.setString(2, obj.getNomeConta());
            st.setInt(3, obj.getDoador().getId());
            st.setDate(4, new java.sql.Date(obj.getData().getTime()));

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("Unexpected error! No rows affected");
            }
        } catch (SQLException e) {
            e.getMessage();
        }
    }


    // Update está com erro com associação ao idDoacao -> Vou retirar posteriormente
    @Override
    public void update(DoacaoDinheiro obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE dinheiro SET valor = ?, nomeConta = ?, doador_id = ?, data = ? WHERE id = ?");

            st.setFloat(1, obj.getValor());
            st.setString(2, obj.getNomeConta());
            st.setInt(3, obj.getDoador().getId());
            st.setDate(4, new java.sql.Date(obj.getData().getTime()));
            st.setInt(5, obj.getId());
            

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM dinheiro WHERE id = ?");

            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public DoacaoDinheiro findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT dinheiro.* FROM dinheiro WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Doador doador = instantiateDoador(rs);
                DoacaoDinheiro dd = instatiateDoacaoDinheiro(rs, doador);
                return dd;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return null;
    }

    @Override
    public List<DoacaoDinheiro> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT dinheiro.* FROM Dinheiro");

            rs = st.executeQuery();

            List<DoacaoDinheiro> list = new ArrayList<>();

            while (rs.next()) {
                Doador doador = instantiateDoador(rs);
                DoacaoDinheiro dd = instatiateDoacaoDinheiro(rs, doador);
                list.add(dd);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return null;
    }

    private Doador instantiateDoador(ResultSet rs) throws SQLException {
        Doador doador = new Doador();
        doador.setId(rs.getInt("id"));
        return doador;
    }

    private DoacaoDinheiro instatiateDoacaoDinheiro(ResultSet rs, Doador doador) throws SQLException {
        DoacaoDinheiro dd = new DoacaoDinheiro();

        dd.setId(rs.getInt("id"));
        dd.setValor(rs.getFloat("valor"));
        dd.setNomeConta(rs.getString("nomeConta"));
        dd.setDoador(doador);
        dd.setData(rs.getDate("data"));

        return dd;
    }
}
