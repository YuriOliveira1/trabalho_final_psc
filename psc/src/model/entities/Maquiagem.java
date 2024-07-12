package model.entities;
import java.util.Date;

public class Maquiagem extends Doacao {
    private String descricaoMaquiagem; // Delineador, Blush, etc...
    
    public Maquiagem(int quantidade, Doador doador, Date data, String descricaoMaquiagem) {
        super(quantidade, doador, data);
        this.descricaoMaquiagem = descricaoMaquiagem;
    }

    public Maquiagem(int quantidade, Doador doador, Date data) {
        super(quantidade, doador, data);
    }

    public String getDescricaoMaquiagem() {
        return descricaoMaquiagem;
    }

    public void setDescricaoMaquiagem(String descricaoMaquiagem) {
        this.descricaoMaquiagem = descricaoMaquiagem;
    }

    @Override
    public String toString() {
        return "Maquiagem [descricaoMaquiagem=" + descricaoMaquiagem + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descricaoMaquiagem == null) ? 0 : descricaoMaquiagem.hashCode());
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
        Maquiagem other = (Maquiagem) obj;
        if (descricaoMaquiagem == null) {
            if (other.descricaoMaquiagem != null)
                return false;
        } else if (!descricaoMaquiagem.equals(other.descricaoMaquiagem))
            return false;
        return true;
    }
}
