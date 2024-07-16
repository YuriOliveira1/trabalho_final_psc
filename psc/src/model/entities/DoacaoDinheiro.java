package model.entities;
import java.util.Date;


public class DoacaoDinheiro {
    private Integer id;
    private static float valor;
    private Date data;
    private String nomeConta;

    public DoacaoDinheiro(Integer id, Date data, String nomeConta) {
        this.id = id;
        this.data = data;
        this.nomeConta = nomeConta;
    }

    public DoacaoDinheiro() {
    }

    public static float getValor() {
        return valor;
    }

    public static void setValor(float valor) {
        DoacaoDinheiro.valor = valor;
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

    @Override
    public String toString() {
        return "DoacaoDinheiro [data=" + data + ", nomeConta=" + nomeConta + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
