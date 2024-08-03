package com.yurioliveira.doacoes.model.dao.impl;

import com.yurioliveira.doacoes.database.*;
import com.yurioliveira.doacoes.model.dao.DAO;
import com.yurioliveira.doacoes.model.entities.Doador;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoadorJDBC implements DAO<Doador> {

    private Connection conn;

    public DoadorJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Doador obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO doador (apelido, contato) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getApelido());
            st.setString(2, obj.getContato());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                } else {
                    throw new DbException("Unexpected error! No rows affected");
                }
                DB.closeResultSet(rs);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Doador obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE doador SET apelido = ?, contato = ? WHERE id = ?");

            st.setString(1, obj.getApelido());
            st.setString(2, obj.getContato());
            st.setInt(3, obj.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM doador WHERE id = ? ");

            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Doador findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT doador.* FROM doador WHERE id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Doador doador = instantiateDoador(rs);
                return doador;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Doador> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT doador.* FROM doador ");

            rs = st.executeQuery();

            List<Doador> list = new ArrayList<>();

            while (rs.next()) {
                Doador doador = instantiateDoador(rs);
                list.add(doador);
            }

            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    private Doador instantiateDoador(ResultSet rs) throws SQLException {
        Doador doador = new Doador();

        doador.setId(rs.getInt("id"));
        doador.setApelido(rs.getString("apelido"));
        doador.setContato(rs.getString("contato"));

        return doador;
    }
}
