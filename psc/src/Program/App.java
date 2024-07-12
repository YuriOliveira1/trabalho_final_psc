package Program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


import model.entities.Cabelo;
import model.entities.CartaDeApoio;
import model.entities.Doacao;
import model.entities.DoacaoDinheiro;
import model.entities.Doador;
import model.entities.Lenco;
import model.entities.Maquiagem;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int opcao = 1;
        int opcaoTipo = 1;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while (opcao != 5) {
            opcao = menu(scan);

            if (opcao == 1) {
                int quantidade = lerInt(scan, "Quantidade do Item a ser Doado: ");

                Date dataFormatada = lerData(scan, sdf, "Data da Doação: ");

                if (verificadorDatas(dataFormatada)) {
                    dataFormatada = lerData(scan, sdf, "Coloque uma data Valída: ");
                }

                System.out.print("Apelido/Nome: ");
                String apelido = scan.nextLine();

                System.out.print("Contato: ");
                String contato = scan.nextLine();

                Doador doador = new Doador(apelido, contato);
                doador.cadastrarDoador(doador);
                

                Doacao doacao = new Doacao(quantidade, doador, dataFormatada);

                opcaoTipo = menuTiposDoacoes(scan);
                scan.nextLine();
                if (opcaoTipo == 1) {

                    System.out.print("Descrição Maquiagem: ");
                    String descricaoMaquiagem = scan.nextLine();

                    Maquiagem maquiagem = new Maquiagem(quantidade, doador, dataFormatada, descricaoMaquiagem);
                    maquiagem.registraDoacao(doacao);
                    
                } else if (opcaoTipo == 2) {

                    System.out.print("Cor do Lenço: ");
                    String corLenco = scan.nextLine();
                    System.out.print("Estilo do Lenço: ");
                    String estiloLenco = scan.nextLine();

                    Lenco lenco = new Lenco(quantidade, doador, dataFormatada, corLenco, estiloLenco);
                    lenco.registraDoacao(lenco);
                    
                } else if (opcaoTipo == 3) {

                    System.out.print("Cor do Cabelo: ");
                    String corCabelo = scan.nextLine();
                    System.out.print("Tamanho do Cabelo: ");
                    String tamanhoCabelo = scan.nextLine();

                    Cabelo cabelo = new Cabelo(quantidade, doador, dataFormatada, corCabelo, tamanhoCabelo);
                    cabelo.registraDoacao(cabelo);
                    
                }
            } else if (opcao == 2) {
                scan.nextLine();
                System.out.print("Nome da Conta: ");
                String nomeConta = scan.nextLine();

                float valor = lerFloat(scan, "Valor a ser doado: R$ ");

                Date dataFormatada = lerData(scan, sdf, "Data da Doação: ");

                if (verificadorDatas(dataFormatada)) {
                    dataFormatada = lerData(scan, sdf, "Coloque uma data Valída: ");
                }

                DoacaoDinheiro dinheiro = new DoacaoDinheiro(valor, dataFormatada, nomeConta);
                dinheiro.registraDoacaoDinheiro(dinheiro);
                
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

               
            } else if (opcao == 5) {
                System.out.println("Saindo...");
            }
        }
        scan.close();
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
                    System.out.print("Coloque uma Opção Valida: ");
                    scan.nextInt();
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Por favor, insira apenas números.");
                scan.next();
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

            try {
                opcao = scan.nextInt();

                if (opcao >= 1 && opcao <= 3) {
                    loop = true;
                } else {
                    System.out.print("Escolha uma opção Valida: ");
                    scan.nextInt();
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Por favor, insira apenas números.");
                scan.next();
            }
        }
        return opcao;
    }

    public static boolean verificadorDatas(Date data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataAtual = sdf.parse(sdf.format(new Date()));
            if (data.before(dataAtual)) {
                return true;
            }
        } catch (ParseException e) {
            System.out.println("Erro ao Analisar a Data");
        }
        return false;
    }

    public static int lerInt(Scanner scan, String texto) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(texto);
                valor = scan.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Insirá um número inteiro");
                scan.next();
            }
        }
        scan.nextLine(); // buffer
        return valor;
    }

    public static float lerFloat(Scanner scan, String texto) {
        float valor = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(texto);
                valor = scan.nextFloat();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Insirá um número real");
                scan.next();
            }
        }
        scan.nextLine(); // buffer
        return valor;
    }

    public static Date lerData(Scanner scan, SimpleDateFormat sdf, String texto) {
        Date data = null;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(texto);
                String dataString = scan.nextLine();
                data = sdf.parse(dataString);
                valido = true;
            } catch (ParseException e) {
                System.out.println("Insirá um número data no formato Correto");
            }
        }
        return data;
    }
}
