package com.yurioliveira.doacoes.model.dao.impl;

import com.yurioliveira.doacoes.model.dao.DAO;
import com.yurioliveira.doacoes.model.entities.CartaDeApoio;


import com.yurioliveira.doacoes.database.*;
import com.yurioliveira.doacoes.model.entities.Doacao;
import com.yurioliveira.doacoes.model.entities.DoacaoDinheiro;
import com.yurioliveira.doacoes.model.entities.Doador;

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
}
