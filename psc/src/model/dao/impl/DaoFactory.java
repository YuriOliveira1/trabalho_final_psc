package model.dao.impl;

import database.DB;
import model.dao.DAO;
import model.entities.Doacao;
import model.entities.DoacaoDinheiro;
import model.entities.Doador;

public class DaoFactory {

    public static DAO<Doador> createDoadorDao() {
        return new DoadorJDBC(DB.getConnection());
    }

    public static DAO<Doacao> createDoacaoDao() {
        return new DoacaoJDBC(DB.getConnection());
    }

    public static DAO<DoacaoDinheiro> createDinheiroDao(){
        return new DoacaoDinheiroJDBC(DB.getConnection());
    }   
}
