package com.yurioliveira.doacoes.model.services;

import com.yurioliveira.doacoes.model.dao.DAO;
import com.yurioliveira.doacoes.model.dao.impl.DaoFactory;
import com.yurioliveira.doacoes.model.entities.Doacao;
import com.yurioliveira.doacoes.model.entities.Doador;

import java.util.List;

public class DoacaoNormalService {

    private DAO<Doacao> doacaoDAO = DaoFactory.createDoacaoDao();

    public List<Doacao> findAll(){
        return doacaoDAO.findAll();
    }

    public Doacao findById(int id){
        return doacaoDAO.findById(id);
    }

    public void saveOrUpdate(Doacao doacao){
        if (doacao.getId() == null){
            doacaoDAO.insert(doacao);
        } else {
            doacaoDAO.update(doacao);
        }
    }
}
