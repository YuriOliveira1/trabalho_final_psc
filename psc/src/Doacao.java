import java.text.SimpleDateFormat;
import java.util.Date;

public class Doacao {
    private String tipo;
    private int quantidade;
    private Doador doador;
    private Date data;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Doacao(String tipo, int quantidade, Doador doador, Date data) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.doador = doador;
        this.data = data;
    }

    public void registraDoacao(){

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

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }
}
