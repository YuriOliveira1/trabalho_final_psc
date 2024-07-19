package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.DB;
import database.DbException;
import model.dao.DAO;
import model.entities.Doacao;
import model.entities.Doador;

public class DoacaoJDBC implements DAO<Doacao> {

    private Connection conn;

    public DoacaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Doacao obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO doacao (tipo, quantidade, doador_id, data) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getTipo());
            st.setInt(2, obj.getQuantidade());
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
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Doacao obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE doacao SET tipo = ?, quantidade = ?, doador_id = ?, data = ? WHERE id = ?");

            st.setString(1, obj.getTipo());
            st.setInt(2, obj.getQuantidade());
            st.setInt(3, obj.getDoador().getId());
            st.setDate(4, new java.sql.Date(obj.getData().getTime()));
            st.setInt(5, obj.getId());


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
            st = conn.prepareStatement("DELETE FROM doacao WHERE id = ? ");

            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Doacao findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT doacao.*, doador.id as doador_id, doador.apelido as doador_apelido, doador.contato as doador_contato "
                            +
                            "FROM doacao JOIN doador ON doacao.doador_id = doador.id " +
                            "WHERE doacao.id = ?");

            st.setInt(1, id);

            rs = st.executeQuery();
            if (rs.next()) {
                Doador doador = instantiateDoador(rs);
                Doacao doacao = instantiateDoacao(rs, doador);
                return doacao;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Doacao> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT doacao.*, doador.id as doador_id, doador.apelido as doador_apelido, doador.contato as doador_contato "
                            +
                            "FROM doacao JOIN doador ON doacao.doador_id = doador.id");

            rs = st.executeQuery();

            List<Doacao> list = new ArrayList<>();
            Map<Integer, Doador> map = new HashMap<>();

            while (rs.next()) { 
                int doadorId = rs.getInt("doador_id");
                Doador doador = map.get(doadorId);

                if (doador == null) {
                    doador = instantiateDoador(rs);
                    map.put(doadorId, doador);
                }

                Doacao objDoacao = instantiateDoacao(rs, doador);
                list.add(objDoacao);
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

    private Doacao instantiateDoacao(ResultSet rs, Doador doador) throws SQLException {
        Doacao doacao = new Doacao();

        doacao.setId(rs.getInt("id"));
        doacao.setTipo(rs.getString("tipo"));
        doacao.setQuantidade(rs.getInt("quantidade"));
        doacao.setDoador(doador);
        doacao.setData(rs.getDate("data"));

        return doacao;
    }

    private Doador instantiateDoador(ResultSet rs) throws SQLException {
        Doador doador = new Doador();
        doador.setId(rs.getInt("doador_id"));
        doador.setApelido(rs.getString("doador_apelido"));
        doador.setContato(rs.getString("doador_contato"));
        return doador;
    }
}
