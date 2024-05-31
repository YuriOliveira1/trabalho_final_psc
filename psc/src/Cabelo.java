import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class Cabelo extends Doacao {

    private String corCabelo;
    private String tamanhoCabelo;

    public Cabelo(int quantidade, Doador doador, Date data, String corCabelo, String tamanhoCabelo) {
        super(quantidade, doador, data);
        this.corCabelo = corCabelo;
        this.tamanhoCabelo = tamanhoCabelo;
    }

    public void registraDoacao(Doacao doacao) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(Arquivos.ARQUIVO_DOACOES, true))) {
            String dataFormatada = sdf.format(getData());
            String apelidoDoador = doacao.getDoador().toString();
            pw.println(getTipo() + ", " + getQuantidade() + ", " + apelidoDoador + ", " + dataFormatada + ", " + getCorCabelo() + ", " + getTamanhoCabelo());
        } catch (Exception e) {
            System.out.println("Error 404");
        }
    }

    public String getCorCabelo() {
        return corCabelo;
    }

    public void setCorCabelo(String corCabelo) {
        this.corCabelo = corCabelo;
    }

    public String getTamanhoCabelo() {
        return tamanhoCabelo;
    }

    public void setTamanhoCabelo(String tamanhoCabelo) {
        this.tamanhoCabelo = tamanhoCabelo;
    }
}
