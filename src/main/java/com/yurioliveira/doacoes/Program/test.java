package com.yurioliveira.doacoes.Program;

import com.yurioliveira.doacoes.model.dao.DAO;
import com.yurioliveira.doacoes.model.dao.impl.*;
import com.yurioliveira.doacoes.model.entities.CartaDeApoio;
import com.yurioliveira.doacoes.model.entities.Doacao;
import com.yurioliveira.doacoes.model.entities.Doador;

import java.util.Date;
import java.util.List;

public class test {
    public static void main(String[] args) {

        DAO<Doacao> dao = DaoFactory.createDoacaoDao();
        DAO<Doador> doadorDAO = DaoFactory.createDoadorDao();

        Doador d = new Doador(7, "Lonfinho", "9999-9999");
        Doacao doacao = new Doacao(null, "BomBom", 2, d, new Date());

        System.out.println("TESTE 1 - INSERT");
        dao.insert(doacao);

        System.out.println("TESTE 2 - FindById");
        doacao = dao.findById(47);
        System.out.println(doacao);

        System.out.println("TESTE 3 - FindAll");
        List<Doacao> list = dao.findAll();

        for (Doacao ccd : list) {
            System.out.println(ccd);
        }

        System.out.println("TESTE 4 - DeleteById");
        doacao = dao.findById(3);
        dao.deleteById(3);

       /* System.out.println("TESTE 5 - UPDATE");
        d = doadorDAO.findById(4);
        cc.setNomeEscritor("Xablaummmm");
        ccDao.update(cc);

        */
    }
}
