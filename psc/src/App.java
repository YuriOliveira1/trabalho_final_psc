import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int opcao = 1;
        int opcaoTipo = 1;
        SistemaGestaoDoacoes sgd = new SistemaGestaoDoacoes();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while (opcao != 3) {
            opcao = menu(scan);

            if (opcao == 1) {
                System.out.print("Quantidade do Item a ser Doado: ");
                int quantidade = scan.nextInt();
                scan.nextLine();
                System.out.print("Data da Doação: ");
                String data = scan.nextLine();
                Date dataFormat = sdf.parse(data);
                System.out.print("Apelido/Nome: ");
                String apelido = scan.nextLine();
                System.out.print("Contato: ");
                String contato = scan.nextLine();

                Doador doador = new Doador(apelido, contato);
                doador.cadastrarDoador(doador);
                sgd.adicionarDoadores(doador);

                Doacao doacao = new Doacao(quantidade, doador, dataFormat);

                opcaoTipo = menuTiposDoacoes(scan);
                scan.nextLine();
                if (opcaoTipo == 1) {

                    System.out.print("Descrição Maquiagem: ");
                    String descricaoMaquiagem = scan.nextLine();

                    Maquiagem maquiagem = new Maquiagem(quantidade, doador, dataFormat, descricaoMaquiagem);
                    maquiagem.registraDoacao(doacao);
                    sgd.adicionarDoacao(maquiagem);
                } else if (opcaoTipo == 2) {

                    System.out.print("Cor do Lenço: ");
                    String corLenco = scan.nextLine();
                    System.out.print("Estilo do Lenço: ");
                    String estiloLenco = scan.nextLine();

                    Lenco lenco = new Lenco(quantidade, doador, dataFormat, corLenco, estiloLenco);
                    lenco.registraDoacao(lenco);
                    sgd.adicionarDoacao(lenco);
                } else if (opcaoTipo == 3) {

                    System.out.print("Cor do Cabelo: ");
                    String corCabelo = scan.nextLine();
                    System.out.print("Tamanho do Cabelo: ");
                    String tamanhoCabelo = scan.nextLine();

                    Cabelo cabelo = new Cabelo(quantidade, doador, dataFormat, corCabelo, tamanhoCabelo);
                    cabelo.registraDoacao(cabelo);
                    sgd.adicionarDoacao(cabelo);
                }
            } else if (opcao == 2) {
                scan.nextLine();
                System.out.print("Nome da Conta: ");
                String nomeConta = scan.nextLine();

                System.out.print("Valor a ser doado: R$ ");
                float valor = scan.nextFloat();
                scan.nextLine();

                System.out.print("Data da Doação: ");
                String data = scan.nextLine();
                Date dataFormat = sdf.parse(data);

                DoacaoDinheiro dinheiro = new DoacaoDinheiro(valor, dataFormat, nomeConta);
                dinheiro.registraDoacaoDinheiro(dinheiro);
                sgd.adicionarDoacaoDinheiro(dinheiro);
            } else if (opcao == 3) {
                System.out.print("Nome do Escritor: ");
                scan.nextLine();
                String nomeEscrito = scan.nextLine();
                
                System.out.print("Escreva um breve Texto de Apoio: ");
                String texto = scan.nextLine();

                CartaDeApoio cartaDeApoio = new CartaDeApoio(nomeEscrito, texto);
                cartaDeApoio.registarCarta(nomeEscrito, texto);
            } else if (opcao == 4) {
                LocalDate dataAgora = LocalDate.now();
                DateTimeFormatter Formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String dataAtual = Formatada.format(dataAgora);

                System.out.print("Descrição do relatorio: ");
                String tipoRelatorio = scan.nextLine();
                scan.next();

                Relatorio relatorio = new Relatorio(dataAtual, tipoRelatorio);
                relatorio.gerarRelatorio();
            } else if (opcao == 5) {
                System.out.println("Saindo...");
            }
        }
    }

    public static int menu(Scanner scan) {
        int opcao = 1;
        boolean loop = false;

        while (!loop) {
            System.out.println("1 - Realizar uma Doação de Objetos");
            System.out.println("2 - Realizar uma Doação de Dinheiro");
            System.out.println("3 - Escrever uma Carta de Apoio");
            System.out.println("4 - Gerar Relatorio");
            System.out.println("5 - Sair");

            try {
                opcao = scan.nextInt();

                if (opcao >= 1 && opcao <= 5) {
                    loop = true;
                } else {
                    System.out.println("Coloque uma Opção Valida");
                    scan.nextInt();
                }
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        return opcao;
    }

    public static int menuTiposDoacoes(Scanner scan) {
        int opcao = 1;
        boolean loop = false;

        while (!loop) {
            System.out.println("1 - Maquiagem");
            System.out.println("2 - Lenço");
            System.out.println("3 - Cabelo");
            System.out.println("4 - Dinheiro");

            try {
                opcao = scan.nextInt();

                if (opcao >= 1 && opcao <= 4) {
                    loop = true;
                } else {
                    System.out.println("Escolha uma opção Valida");
                }
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        return opcao;
    }
}
