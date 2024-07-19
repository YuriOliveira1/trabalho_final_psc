package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DB;
import database.DbException;
import model.dao.DAO;
import model.entities.CartaDeApoio;

public class CartaDeApoioJDBC implements DAO<CartaDeApoio> {

    private Connection conn;

    public CartaDeApoioJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(CartaDeApoio obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO cartaapoio (nomeEscritor, textoDaCarta) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getNomeEscritor());
            st.setString(2, obj.getTextoDaCarta());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setIdCarta(id);
                }
                DB.closeStatement(st);
            } else {
                throw new DbException("Unexpected error! No rows affected");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(CartaDeApoio obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE cartaapoio SET nomeEscritor = ?, textoDaCarta = ? WHERE id = ?");

            st.setString(1, obj.getNomeEscritor());
            st.setString(2, obj.getTextoDaCarta());
            st.setInt(3, obj.getIdCarta());

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
            st = conn.prepareStatement("DELETE FROM cartaapoio WHERE id = ?");

            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public CartaDeApoio findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT cartaapoio.* FROM cartaapoio WHERE id = ?");

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                CartaDeApoio cc = instatiateCartaDeApoio(rs);
                return cc;
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return null;
    }

    @Override
    public List<CartaDeApoio> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT cartaapoio.* FROM cartaapoio");

            rs = st.executeQuery();

            List<CartaDeApoio> list = new ArrayList<>();
            while (rs.next()) {
                CartaDeApoio cc = instatiateCartaDeApoio(rs);
                list.add(cc);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    public CartaDeApoio instatiateCartaDeApoio(ResultSet rs) throws SQLException{
        CartaDeApoio ca = new CartaDeApoio();

        ca.setIdCarta(rs.getInt("id"));
        ca.setNomeEscritor(rs.getString("nomeEscritor"));
        ca.setTextoDaCarta(rs.getString("textoDaCarta"));

        return ca;
    }
}
