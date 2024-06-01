import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class Maquiagem extends Doacao {
    private String descricaoMaquiagem; // Delineador, Blush, etc...
    
    public Maquiagem(int quantidade, Doador doador, Date data, String descricaoMaquiagem) {
        super(quantidade, doador, data);
        this.descricaoMaquiagem = descricaoMaquiagem;
    }

    public void registraDoacao(Doacao doacao) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(Arquivos.ARQUIVO_DOACOES, true))) {
            String dataFormatada = sdf.format(getData());
            String apelidoDoador = doacao.getDoador().toString();
            pw.println("Maquiagem" + ", " + getQuantidade() + ", " + apelidoDoador + ", " + dataFormatada + ", " + getDescricaoMaquiagem());
        } catch (Exception e) {
            System.out.println("Error 404");
        }
    }

    public String getDescricaoMaquiagem() {
        return descricaoMaquiagem;
    }

    public void setDescricaoMaquiagem(String descricaoMaquiagem) {
        this.descricaoMaquiagem = descricaoMaquiagem;
    }

}
