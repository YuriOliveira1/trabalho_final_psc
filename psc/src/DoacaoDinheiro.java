import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DoacaoDinheiro {
    private static float valor;
    private Date data;
    private Doador doador;
 
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String apelidoDoador = doador.getApelido().toString();

    public DoacaoDinheiro(float valor, Date data, Doador doador) {
        DoacaoDinheiro.valor = valor;
        this.data = data;
        this.doador = doador;
    }
    
    public void registraDoacaoDinheiro(DoacaoDinheiro dinheiro) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(Arquivos.ARQUIVO_DOACOES, true))) {
            String dataFormatada = sdf.format(getData());
            pw.println(valor + ", " + apelidoDoador + ", " + dataFormatada);
        } catch (Exception e) {
            System.out.println("Error 404");
        }
    }

    public static float somaTotalValores(){
        float resultado =+ valor;
        return resultado;
    }
    // Adicionar método que soma todos os valores contados
    public void converterParaItem() {

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

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }
}
