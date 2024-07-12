package model.entities;

public class CartaDeApoio {
    private String nomeEscritor;
    private String textoDaCarta;

    public CartaDeApoio(String nomeEscritor, String textoDaCarta) {
        this.nomeEscritor = nomeEscritor;
        this.textoDaCarta = textoDaCarta;
    }

    public CartaDeApoio() {
    }

    public String getNomeEscritor() {
        return nomeEscritor;
    }

    public void setNomeEscritor(String nomeEscritor) {
        this.nomeEscritor = nomeEscritor;
    }

    public String getTextoDaCarta() {
        return textoDaCarta;
    }

    public void setTextoDaCarta(String textoDaCarta) {
        this.textoDaCarta = textoDaCarta;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nomeEscritor == null) ? 0 : nomeEscritor.hashCode());
        result = prime * result + ((textoDaCarta == null) ? 0 : textoDaCarta.hashCode());
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
        CartaDeApoio other = (CartaDeApoio) obj;
        if (nomeEscritor == null) {
            if (other.nomeEscritor != null)
                return false;
        } else if (!nomeEscritor.equals(other.nomeEscritor))
            return false;
        if (textoDaCarta == null) {
            if (other.textoDaCarta != null)
                return false;
        } else if (!textoDaCarta.equals(other.textoDaCarta))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CartaDeApoio [nomeEscritor=" + nomeEscritor + ", textoDaCarta=" + textoDaCarta + "]";
    }
}
