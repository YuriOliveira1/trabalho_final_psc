package model.entities;

import java.util.Date;

public class Doacao {
    private String tipo;
    private int quantidade;
    private Doador doador;
    private Date data;
    
    public Doacao(int quantidade, Doador doador, Date data) {
        this.quantidade = quantidade;
        this.doador = doador;
        this.data = data;
        this.tipo = ""; 
    }

    public Doacao() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        result = prime * result + quantidade;
        result = prime * result + ((doador == null) ? 0 : doador.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
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
        Doacao other = (Doacao) obj;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        if (quantidade != other.quantidade)
            return false;
        if (doador == null) {
            if (other.doador != null)
                return false;
        } else if (!doador.equals(other.doador))
            return false;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Doacao [tipo=" + tipo + ", quantidade=" + quantidade + ", doador=" + doador + ", data=" + data + "]";
    }
}
