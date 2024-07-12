package model.entities;
import java.util.Date;


public class Lenco extends Doacao {
    private String corLenco;
    private String estiloLenco;

    public Lenco(int quantidade, Doador doador, Date data, String corLenco, String estiloLenco) {
        super(quantidade, doador, data);
        this.corLenco = corLenco;
        this.estiloLenco = estiloLenco;
    }

    public Lenco(int quantidade, Doador doador, Date data) {
        super(quantidade, doador, data);
    }

    public String getCorLenco() {
        return corLenco;
    }

    public void setCorLenco(String corLenco) {
        this.corLenco = corLenco;
    }

    public String getEstiloLenco() {
        return estiloLenco;
    }

    public void setEstiloLenco(String estiloLenco) {
        this.estiloLenco = estiloLenco;
    }

    @Override
    public String toString() {
        return "Lenco [corLenco=" + corLenco + ", estiloLenco=" + estiloLenco + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((corLenco == null) ? 0 : corLenco.hashCode());
        result = prime * result + ((estiloLenco == null) ? 0 : estiloLenco.hashCode());
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
        Lenco other = (Lenco) obj;
        if (corLenco == null) {
            if (other.corLenco != null)
                return false;
        } else if (!corLenco.equals(other.corLenco))
            return false;
        if (estiloLenco == null) {
            if (other.estiloLenco != null)
                return false;
        } else if (!estiloLenco.equals(other.estiloLenco))
            return false;
        return true;
    }
}
