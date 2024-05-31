import java.text.SimpleDateFormat;
import java.util.Date;

public class DoacaoDinheiro {
    private float valor;
    private Date data;
    private Doador doador;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public DoacaoDinheiro(float valor, Date data, Doador doador) {
        this.valor = valor;
        this.data = data;
        this.doador = doador;
    }

    public void registraDoacaoDinheiro(){

    }

    public void converterParaItem(){

    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }
}
