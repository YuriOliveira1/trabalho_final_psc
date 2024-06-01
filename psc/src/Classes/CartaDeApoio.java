package Classes;
import java.io.FileWriter;
import java.io.PrintWriter;

import Arquivos.Arquivos;

public class CartaDeApoio {
    private String nomeEscritor;
    private String textoDaCarta;

    public CartaDeApoio(String nomeEscritor, String textoDaCarta) {
        this.nomeEscritor = nomeEscritor;
        this.textoDaCarta = textoDaCarta;
    }

    public void registarCarta(String nomeEscrito, String textoDaCarta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(Arquivos.ARQUIVO_CARTAS, true))) {
            pw.println("Nome do Escritor: " + nomeEscritor + "\n" + "Texto: " + getTextoDaCarta());
        } catch (Exception e) {
            System.out.println("Error 404");
        }
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
}
