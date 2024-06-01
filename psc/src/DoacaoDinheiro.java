import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DoacaoDinheiro {
    private static float valor;
    private Date data;
    private String nomeConta;
    private static float resultado = 0;
 
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public DoacaoDinheiro(float valor, Date data, String nomeConta) {
        DoacaoDinheiro.valor = valor;
        this.data = data;
        this.nomeConta = nomeConta;
        resultado += valor;
    }
    
    public void registraDoacaoDinheiro(DoacaoDinheiro dinheiro) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(Arquivos.ARQUIVO_DOACOES, true))) {
            String dataFormatada = sdf.format(getData());
            pw.println("Dinheiro" + ", "+ valor + ", " + nomeConta + ", " + dataFormatada);
        } catch (Exception e) {
            System.out.println("Error 404");
        }
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

    public static float getValor() {
        return valor;
    }

    public static void setValor(float valor) {
        DoacaoDinheiro.valor = valor;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public static float getResultado() {
        return resultado;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }
}
