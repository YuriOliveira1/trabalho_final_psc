package com.yurioliveira.doacoes.model.services;

import com.yurioliveira.doacoes.model.dao.DAO;
import com.yurioliveira.doacoes.model.dao.impl.DaoFactory;
import com.yurioliveira.doacoes.model.entities.CartaDeApoio;
import com.yurioliveira.doacoes.model.entities.Doacao;

import java.util.List;

public class CartasService {

    private DAO<CartaDeApoio> daoCartaDeApoio = DaoFactory.createCartaApoioDao();

    public List<CartaDeApoio> findAll(){
        return daoCartaDeApoio.findAll();
    }

    public void insert(CartaDeApoio cartaDeApoio){
        daoCartaDeApoio.insert(cartaDeApoio);
    }

    public void saveOrUpdate(CartaDeApoio cartaDeApoio){
        if (cartaDeApoio.getIdCarta() == null){
            daoCartaDeApoio.insert(cartaDeApoio);
        } else {
            daoCartaDeApoio.update(cartaDeApoio);
        }
    }

    public CartaDeApoio findById(int id){
        return daoCartaDeApoio.findById(id);
    }

    public void remove(CartaDeApoio cartaDeApoio){
        daoCartaDeApoio.deleteById(cartaDeApoio.getIdCarta());
    }
}
