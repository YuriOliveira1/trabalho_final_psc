package com.yurioliveira.doacoes.model.entities;

import java.util.Date;

public class DoacaoDinheiro {

    private Integer id;
    private float valor;
    private Date data;
    private String nomeConta;
    private Doador doador;

    public DoacaoDinheiro(Integer id, float valor, Date data, String nomeConta, Doador doador) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.nomeConta = nomeConta;
        this.doador = doador;
    }

    public DoacaoDinheiro() {
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public Integer getDoadorId(){
        return (doador != null) ? doador.getId() : null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((nomeConta == null) ? 0 : nomeConta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DoacaoDinheiro other = (DoacaoDinheiro) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (nomeConta == null) {
            if (other.nomeConta != null)
                return false;
        } else if (!nomeConta.equals(other.nomeConta))
            return false;
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "DoacaoDinheiro [id=" + id + ", valor=" + valor + ", data=" + data + ", nomeConta=" + nomeConta + "]";
    }
}
