/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Imovel.Imovel;
import ListaImoveis.ListaDeImoveis;
import Chacara.Chacara;
import static Imovel.EntradasTeclado.inDouble;
import static Imovel.EntradasTeclado.inInt;
import static Imovel.EntradasTeclado.inString;
import Imovel.TipoDeImovel;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 **
 * @author Wilson
 */
public class MenuChacara {

    ListaDeImoveis lista;
    Scanner entrada = new Scanner(System.in);
    private String caminhocod = System.getProperty("user.dir") + System.getProperty("file.separator") +"CodigoImovel.bin";

    public MenuChacara() {
        TipoDeImovel tipo;
        tipo = TipoDeImovel.CHACARA;
        String caminho = System.getProperty("user.dir") + System.getProperty("file.separator") + tipo + ".bin";
        lista = new ListaDeImoveis(caminho, tipo);
        
        
        try {
            ListaDeImoveis.lerArquivoBinarioCod(caminhocod);
        } catch (IOException ex) {
            Logger.getLogger(MenuApartamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuApartamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (lista.lerArquivo() == true) {
            System.out.println("Arquivos carregados");
        } else {
            System.out.println("Arquivo não iniciados");
        }

    }

    /**
     * Este método faz as interações com o usuário, de modo que quando este
     * escolhe a opção é chamado outro método para realizar a ação
     */
    public static void menu() {
        System.out.println(" \n");
        System.out.println("***** MENU *****\n");
        System.out.println("1) NOVO IMÓVEL CHACARA ");
        System.out.println("2) CONSULTAR");
        System.out.println("3) EDITAR ");
        //System.out.println("4) Excluir");
        System.out.println("0) VOLTAR ");
        System.out.println(" ");

    }

    public static void menu2() {
        System.out.println(" \n");
        System.out.println("*************** MENU DE CONSULTA *****************");
        System.out.println(" \n");
        System.out.println("1) CÓDIGO  ");
        System.out.println("0) VOLTAR ");
        System.out.println("\n ");
        System.out.print("OPÇÃO:     ");

    }

    /**
     * Esse método recebe informações do usuário e passa para o construtor
     * (parâmetros)
     */
    public void IncluirImovel() {

        String logradouro;
        int numero;
        String bairro;
        String cidade;
        String descricao;
        double areaTotal;
        double valor;
        double areaConstruida;
        int numeroQuartos;
        int anoConstrucao;
        double distCidade;

        logradouro = inString("Digite o Logradouro:  ");

        numero = inInt("Digite o numero: ");

        bairro = inString("Digite o Bairro:  ");

        cidade = inString("Digite a Cidade:  ");

        descricao = inString("Digite Uma Descrição:  ");

        areaTotal = inDouble("Digite a Área Total:  ");

        valor = inDouble("Digite o Valor do Imóvel:  ");

        areaConstruida = inDouble("Digite a Área Construída:");

        numeroQuartos = inInt("Digite o Número de Quartos:  ");

        anoConstrucao = inInt("Digite o Ano da Construção: ");

        distCidade = inDouble("Digite a Distância da Cidade:  ");

        Imovel chacara = new Chacara(distCidade, logradouro, numero, bairro, cidade,
                descricao, areaTotal, valor, areaConstruida, numeroQuartos, anoConstrucao);

        boolean objeto = lista.incluir(chacara);

        System.out.println("\n");

        if (objeto == true) {
            System.out.println("Imóvel incluido com sucesso!");
        } else {
            System.out.println("Imóvel não foi incluido!");
        }
        try {
            ListaDeImoveis.escreveBinarioCod(caminhocod, Imovel.getCodigoStat());
            lista.escreverArquivo();
        } catch (Exception ex) {
            Logger.getLogger(MenuChacara.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Consulta pela entrada do usuário (inteiro - código)
     */
    public void Consultar() {
        
        lista.mostrarLista();
        System.out.println("\n");
        System.out.println("Digite o Código Que Deseja Consultar: ");
        Imovel Imo = lista.consultar(entrada.nextInt());
        entrada.nextLine();

        if ((Imo != null) && (Imo instanceof Chacara)) {
            System.out.println("=======================================");
            System.out.println("*******INFORMAÇÕES DO IMÓVEL *****\n");
            System.out.println(Imo.toString());
            System.out.println("=======================================");

        } else if (Imo == null) {
            System.out.println("Imóvel Não Cadastrado;");
        }

    }

    public void menuInicial() {
        int i;

        do {
            MenuChacara.menu();
            i = inInt("Opção: ");

            switch (i) {
                case 1:
                    System.out.println("\n");
                    System.out.println("*********** Incluir Imóvel ************");
                    System.out.println("\n");
                    IncluirImovel();
                    break;

                case 2:
                    MenuChacara.menu2();
                    int opcao = entrada.nextInt();
                    entrada.nextLine();

                    switch (opcao) {
                        case 1:
                            System.out.println("\n");
                            System.out.println("******** Consultar Imóvel Por Codigo ********");
                            System.out.println("\n\n");
                            Consultar();
                            break;

                        default:
                            break;

                    }
                    break;

                case 3:
                    System.out.println("\n");
                    editarControle();
                    break;

                case 4:

                    break;

                case 5:

                default:
                    break;

            }

        } while (i != 0);

    }

    public void editarControle() {

        System.out.println("\n");
        System.out.println("***********  MENU EDITAR ************ ");
        System.out.println("\n ");
        System.out.println("DIGITE O CODIGO DO IMOVÉL QUE DESEJA EDITAR:");
        int codigoConsulta = entrada.nextInt();

        entrada.nextLine();

        Imovel editarLista = lista.consultar(codigoConsulta);
        entrada.nextLine();

        int k = 1;

        if (editarLista != null) {

            while (k != 0) {
                System.out.println(" \n");
                System.out.println("QUAL INFORMAÇÂO DESEJA EDITAR: ");
                System.out.println(" \n");
                System.out.println("0)  VOLTAR AO MENU ANTERIOR ");
                System.out.println("1)  LOGRADOURO ");
                System.out.println("2)  NÚMERO ");
                System.out.println("3)  BAIRRO ");
                System.out.println("4)  CIDADE ");
                System.out.println("5)  DESCRIÇÃO ");
                System.out.println("6)  ARÉA TOTAL ");
                System.out.println("7)  VALOR ");
                System.out.println("8)  ÁREA CONSTRUÍDA ");
                System.out.println("9)  NÚMERO DE QUARTOS ");
                System.out.println("10) ANO DE CONSTRUÇÃO ");
                System.out.println("11) DISTÂNCIA DA CIDADE ");
                System.out.println(" \n");
                System.out.print("OPÇÃO:    ");
                k = entrada.nextInt();
                entrada.nextLine();

                switch (k) {
                    case 1:
                        System.out.print("\n ");
                        System.out.print("DIGITE O NOVO LOGRADOURO: ");
                        editarLista.setLogradouro(entrada.nextLine());
                        break;
                    case 2:

                        System.out.print("\n\n");
                        System.out.print("DIGITE O NÚMERO:");
                        editarLista.setNumero(entrada.nextInt());
                        entrada.nextLine();

                        break;

                    case 3:

                        System.out.print("\n");
                        System.out.print("DIGITE O BAIRRO:");
                        editarLista.setBairro(entrada.nextLine());

                        break;

                    case 4:

                        System.out.print("\n");
                        System.out.print("DIGITE A CIDADE:");
                        editarLista.setCidade(entrada.nextLine());

                        break;

                    case 5:

                        System.out.print("\n");
                        System.out.print("DIGITE A DESCRIÇÂO:");
                        editarLista.setCidade(entrada.nextLine());

                        break;

                    case 6:

                        System.out.print("\n");
                        System.out.print("DIGITE A ARÉA TOTAL:");
                        editarLista.setAreaTotal(entrada.nextDouble());

                        break;

                    case 7:
                        System.out.print("\n");
                        System.out.print("DIGITE O VALOR:");
                        editarLista.setValor(entrada.nextDouble());

                        break;

                    case 8:
                        System.out.print("\n");
                        System.out.print("DIGITE A ÁREA CONSTRUÍDA:");
                        editarLista.setAreaConstruida(entrada.nextDouble());
                        entrada.nextLine();

                        break;

                    case 9:

                        System.out.print("\n");
                        System.out.print("DIGITE O NÚMERO DE QUARTOS:");
                        editarLista.setNumeroQuartos(entrada.nextInt());

                        break;

                    case 10:

                        System.out.print("\n");
                        System.out.print("DIGITE O ANO DA CONSTRUÇÃO:");
                        editarLista.setAnoConstrucao(entrada.nextInt());
                        entrada.nextLine();
                        break;

                    case 11:

                        System.out.print("\n");
                        System.out.print("DIGITE A DISTÂNCIA DA CIDADE:");
                        editarLista.setDistCidade(entrada.nextDouble());
                        entrada.nextLine();

                        break;

                }

            }

            lista.editar(codigoConsulta, editarLista);
            System.out.println(" --- ");
            try {
                lista.escreverArquivo();
            } catch (Exception ex) {
                Logger.getLogger(Chacara.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println(" \nImóvel Não Encotrado!");
        }

    }

}
