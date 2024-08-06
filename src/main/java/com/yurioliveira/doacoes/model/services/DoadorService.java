package com.yurioliveira.doacoes.model.services;

import com.yurioliveira.doacoes.model.dao.DAO;
import com.yurioliveira.doacoes.model.dao.impl.DaoFactory;
import com.yurioliveira.doacoes.model.entities.Doador;

import java.util.List;

public class DoadorService {

    private DAO<Doador> doadorDAO = DaoFactory.createDoadorDao();

    public List<Doador> findAll() {
        return doadorDAO.findAll();
    }

    public Doador findById(int id) {
        return doadorDAO.findById(id);
    }

    public void saveOrUpdate(Doador doador) {
        if (doador.getId() == null) {
            doadorDAO.insert(doador);
        } else {
            doadorDAO.update(doador);
        }
    }
}
