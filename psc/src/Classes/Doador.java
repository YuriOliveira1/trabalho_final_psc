package Classes;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import Arquivos.Arquivos;

public class Doador {
    private String apelido;
    private String contato;

    public Doador(String apelido, String contato) {
        this.apelido = apelido;
        this.contato = contato;
    }

    public void cadastrarDoador(Doador doador) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(Arquivos.ARQUIVO_DOADORES, true))) {
            if (!verificaDoadorExistente(apelido, contato)) {
                pw.println(getApelido() + ", " + getContato());
            }
        } catch (Exception e) {
            System.out.println("Error 404");
        }
    }

    public boolean verificaDoadorExistente(String apelido, String contato){
        try (BufferedReader reader = new BufferedReader(new FileReader(Arquivos.ARQUIVO_DOADORES))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(apelido + ", " + contato)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error 1405");
        }
        return false;
    }

    

    @Override
    public String toString() {
        return apelido;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
