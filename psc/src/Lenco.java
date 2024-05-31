import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class Lenco extends Doacao {
    private String corLenco;
    private String estiloLenco;

    public Lenco(int quantidade, Doador doador, Date data, String corLenco, String estiloLenco) {
        super(quantidade, doador, data);
        this.corLenco = corLenco;
        this.estiloLenco = estiloLenco;
    }

    public void registraDoacao(Doacao doacao) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(Arquivos.ARQUIVO_DOACOES, true))) {
            String dataFormatada = sdf.format(getData());
            String apelidoDoador = doacao.getDoador().toString();
            pw.println(getTipo() + ", " + getQuantidade() + ", " + apelidoDoador + ", " + dataFormatada + ", " + getCorLenco() + ", " + getEstiloLenco());
            
        } catch (Exception e) {
            System.out.println("Error 404");
        }
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
}
