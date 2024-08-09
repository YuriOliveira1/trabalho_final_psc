package com.yurioliveira.doacoes.model.dao.impl;

import com.yurioliveira.doacoes.model.dao.DAO;
import com.yurioliveira.doacoes.model.entities.*;


import com.yurioliveira.doacoes.database.*;

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

    public static DAO<CartaDeApoio> createCartaApoioDao(){
        return new CartaDeApoioJDBC(DB.getConnection());
    }

    public static RelatorioJDBC createRelatorioDao(){
        return new RelatorioJDBC(DB.getConnection());
    }
}
