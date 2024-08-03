package com.yurioliveira.doacoes.model.services;

import com.yurioliveira.doacoes.model.entities.Doacao;
import com.yurioliveira.doacoes.model.entities.Doador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DoacaoNormalService {

    private Doador doador = new Doador(17, "Lonf", "6666-6666");

    public List<Doacao> findAll(){
        List<Doacao> list = new ArrayList<>();
        list.add(new Doacao(7, "Cabelo", 1, doador, new Date()));
        list.add(new Doacao(26, "Lenço", 1, doador, new Date()));
        list.add(new Doacao(72, "BomBom", 1, doador, new Date()));
        return list;
    }
}
