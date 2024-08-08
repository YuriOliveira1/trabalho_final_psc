package com.yurioliveira.doacoes.model.entities;

public class Doador {
    private Integer id;
    private String apelido;
    private String contato;

    public Doador(Integer id, String apelido, String contato) {
        this.id = id;
        this.apelido = apelido;
        this.contato = contato;
    }

    public Doador() {
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
        result = prime * result + ((contato == null) ? 0 : contato.hashCode());
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
        Doador other = (Doador) obj;
        if (apelido == null) {
            if (other.apelido != null)
                return false;
        } else if (!apelido.equals(other.apelido))
            return false;
        if (contato == null) {
            if (other.contato != null)
                return false;
        } else if (!contato.equals(other.contato))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Doador{" +
                "id=" + id +
                ", apelido='" + apelido + '\'' +
                ", contato='" + contato + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
