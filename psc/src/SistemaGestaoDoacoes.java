import java.util.ArrayList;

public class SistemaGestaoDoacoes {
    private ArrayList<Doacao> listaDoacoes;
    private ArrayList<DoacaoDinheiro> listaDoacaoDinheiro;
    private ArrayList<Doador> listaDoadores;

    public SistemaGestaoDoacoes() {
        this.listaDoacoes = new ArrayList<>();
        this.listaDoacaoDinheiro = new ArrayList<>();
        this.listaDoadores = new ArrayList<>();
    }

    public void adicionarDoacao(Doacao doacao){
        listaDoacoes.add(doacao);
    }

    public void adicionarDoacaoDinheiro(DoacaoDinheiro doacao){
        listaDoacaoDinheiro.add(doacao);
    }

    public void adicionarDoadores(Doador doador){
        listaDoadores.add(doador);
    }

    public void buscarDoacoesPorTipo(String tipo){

    }

    public ArrayList<Doacao> getListaDoacoes() {
        return listaDoacoes;
    }

    public void setListaDoacoes(ArrayList<Doacao> listaDoacoes) {
        this.listaDoacoes = listaDoacoes;
    }

    public ArrayList<DoacaoDinheiro> getListaDoacaoDinheiro() {
        return listaDoacaoDinheiro;
    }

    public void setListaDoacaoDinheiro(ArrayList<DoacaoDinheiro> listaDoacaoDinheiro) {
        this.listaDoacaoDinheiro = listaDoacaoDinheiro;
    }

    public ArrayList<Doador> getListaDoadores() {
        return listaDoadores;
    }

    public void setListaDoadores(ArrayList<Doador> listaDoadores) {
        this.listaDoadores = listaDoadores;
    }
}
