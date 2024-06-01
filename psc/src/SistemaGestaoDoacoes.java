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

    public void adicionarDoacao(Doacao doacao) {
        listaDoacoes.add(doacao);
    }

    public void adicionarDoacaoDinheiro(DoacaoDinheiro doacao) {
        listaDoacaoDinheiro.add(doacao);
    }

    public void adicionarDoadores(Doador doador) {
        listaDoadores.add(doador);
    }

    /*
    Função desabilitada, posso utiliza-la depois
         public ArrayList<Doacao> buscarDoacoesPorTipo(String tipo) {
        ArrayList<Doacao> listaTipoEncontrado = new ArrayList<>();
        for (Doacao doacoes : listaDoacoes) {
            if (doacoes.getTipo().equals(tipo)) {
                listaTipoEncontrado.add(doacoes);
            }
        }
        return listaTipoEncontrado;
    }
     */

    public void contador() {
        int doacoesDeDinheiro = getListaDoacaoDinheiro().size();
        int doacoesDeDoacoes = getListaDoacoes().size();
        int doacoesGerais = getListaDoacoes().size() + getListaDoacaoDinheiro().size();
        int doacoesDeDoadores = getListaDoadores().size();

        System.out.println("Doação Dinheiro: " + doacoesDeDinheiro
                + "\n"
                + "Doações:" + doacoesDeDoacoes
                + "\n"
                + "Doação Gerais: " + doacoesGerais
                + "\n"
                + "Doadores: " + doacoesDeDoadores);
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
