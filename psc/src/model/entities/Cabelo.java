package model.entities;

import java.util.Date;

public class Cabelo extends Doacao {

    private String corCabelo;
    private String tamanhoCabelo;

    public Cabelo(int quantidade, Doador doador, Date data, String corCabelo, String tamanhoCabelo) {
        super(quantidade, doador, data);
        this.corCabelo = corCabelo;
        this.tamanhoCabelo = tamanhoCabelo;
    }

    public Cabelo(int quantidade, Doador doador, Date data) {
        super(quantidade, doador, data);
    }

    public String getCorCabelo() {
        return corCabelo;
    }

    public void setCorCabelo(String corCabelo) {
        this.corCabelo = corCabelo;
    }

    public String getTamanhoCabelo() {
        return tamanhoCabelo;
    }

    public void setTamanhoCabelo(String tamanhoCabelo) {
        this.tamanhoCabelo = tamanhoCabelo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((corCabelo == null) ? 0 : corCabelo.hashCode());
        result = prime * result + ((tamanhoCabelo == null) ? 0 : tamanhoCabelo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cabelo other = (Cabelo) obj;
        if (corCabelo == null) {
            if (other.corCabelo != null)
                return false;
        } else if (!corCabelo.equals(other.corCabelo))
            return false;
        if (tamanhoCabelo == null) {
            if (other.tamanhoCabelo != null)
                return false;
        } else if (!tamanhoCabelo.equals(other.tamanhoCabelo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cabelo [corCabelo=" + corCabelo + ", tamanhoCabelo=" + tamanhoCabelo + "]";
    }
}
