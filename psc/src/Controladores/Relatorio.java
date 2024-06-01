package Controladores;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Arquivos.Arquivos;
import Classes.DoacaoDinheiro;

public class Relatorio {
    private String dataRelatorio;
    private String tipoRelatorio;

    public Relatorio(String dataRelatorio, String tipoRelatorio) {
        this.dataRelatorio = dataRelatorio;
        this.tipoRelatorio = tipoRelatorio;
    }

    public void gerarRelatorio(){
        System.out.println("Relatorio Gerado no Dia: " + dataRelatorio);
        System.out.println("Contagem de Doações: " + quantidadeDoacoes());
        System.out.println("Contagem de Doadores: " + quantidadeDoadores());
        System.out.println("Dinheiro Arrecadado: R$ " + DoacaoDinheiro.getResultado());
    }

    public int quantidadeDoacoes() {
        int contador = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(Arquivos.ARQUIVO_DOACOES))) {
            while (reader.readLine() != null) {
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Error 104");
        }
        return contador;
    }

    public int quantidadeDoadores(){
        int contador = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(Arquivos.ARQUIVO_DOADORES))) {
            while (reader.readLine() != null) {
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Error 105");
        }
        return contador;
    }

    public String getDataRelatorio() {
        return dataRelatorio;
    }

    public void setDataRelatorio(String dataRelatorio) {
        this.dataRelatorio = dataRelatorio;
    }

    public String getTipoRelatorio() {
        return tipoRelatorio;
    }

    public void setTipoRelatorio(String tipoRelatorio) {
        this.tipoRelatorio = tipoRelatorio;
    }
}
