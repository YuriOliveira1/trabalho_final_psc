package com.yurioliveira.doacoes.model.services;

import com.yurioliveira.doacoes.model.dao.DAO;
import com.yurioliveira.doacoes.model.dao.impl.DaoFactory;
import com.yurioliveira.doacoes.model.entities.DoacaoDinheiro;

import java.util.List;

public class DoacaoDinheiroService {

    private DAO<DoacaoDinheiro> dao = DaoFactory.createDinheiroDao();

    public List<DoacaoDinheiro> findAll() {
        return dao.findAll();
    }

    public DoacaoDinheiro findById(int id) {
        return dao.findById(id);
    }

    public void saveOrUpdate(DoacaoDinheiro dinheiro) {
        if (dinheiro.getId() == null) {
            dao.insert(dinheiro);
        } else {
            dao.update(dinheiro);
        }
    }

    public void delete(DoacaoDinheiro dinheiro) {
        dao.deleteById(dinheiro.getId());
    }

}
