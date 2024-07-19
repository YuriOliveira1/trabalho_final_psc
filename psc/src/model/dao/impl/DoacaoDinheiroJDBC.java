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
import model.entities.Doacao;
import model.entities.DoacaoDinheiro;
import model.entities.Doador;

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
                    "INSERT INTO dinheiro (valor, nomeConta, idDoacao, data) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setFloat(1, obj.getValor());
            st.setString(2, obj.getNomeConta());
            st.setInt(3, obj.getDoacao().getId());
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


    // Update está com erro com assosiação ao idDoacao -> Vou retirar posteriormente
    @Override
    public void update(DoacaoDinheiro obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE dinheiro SET valor = ?, nomeConta = ?, idDoacao = ?, data = ? WHERE id = ?");

            st.setFloat(1, obj.getValor());
            st.setString(2, obj.getNomeConta());
            st.setInt(3, 45);
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
                Doacao doacao = instantiateDoacao(rs, doador);
                DoacaoDinheiro dd = instatiateDoacaoDinheiro(rs, doacao);
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
                Doacao doacao = instantiateDoacao(rs, doador);
                DoacaoDinheiro dd = instatiateDoacaoDinheiro(rs, doacao);
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

    private Doacao instantiateDoacao(ResultSet rs, Doador doador) throws SQLException {
        Doacao doacao = new Doacao();

        doacao.setId(rs.getInt("id"));

        return doacao;
    }

    private Doador instantiateDoador(ResultSet rs) throws SQLException {
        Doador doador = new Doador();
        doador.setId(rs.getInt("id"));
        return doador;
    }

    private DoacaoDinheiro instatiateDoacaoDinheiro(ResultSet rs, Doacao doacao) throws SQLException {
        DoacaoDinheiro dd = new DoacaoDinheiro();

        dd.setId(rs.getInt("id"));
        dd.setValor(rs.getFloat("valor"));
        dd.setNomeConta(rs.getString("nomeConta"));
        dd.setDoacao(doacao);
        dd.setData(rs.getDate("data"));

        return dd;
    }
}
