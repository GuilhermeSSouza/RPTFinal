/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import static Imovel.EntradasTeclado.div;
import Imovel.Imovel;
import static Imovel.EntradasTeclado.inInt;
import static Imovel.EntradasTeclado.inDouble;
import static Imovel.EntradasTeclado.inInt;
import static Imovel.EntradasTeclado.inString;
import Imovel.TipoDeImovel;
import ListaImoveis.ListaDeImoveis;
import SalaComercial.SalaComercial;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 **
 * @author Arcano
 */
public class MenuSalaComercial {

    ListaDeImoveis lista;
    private List<Imovel> ListaOrdenada;
    Scanner entrada = new Scanner(System.in);
    private String caminhocod = System.getProperty("user.dir") + System.getProperty("file.separator") + "CodigoImovel.bin";

    /**
     * Metodo que chama o metodo que carrega arquivos dentro da lista de Imoveis
     */
    public MenuSalaComercial() {
        TipoDeImovel tipo;
        tipo = TipoDeImovel.SALACOMERCIAL;
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

    public static void menu() {
        System.out.println(" \n");
        System.out.println("***** MENU *****\n");
        System.out.println("1) NOVO IMÓVEL SALA COMERCIAL");
        System.out.println("2) CONSULTAR");
        System.out.println("3) EDITAR ");
        System.out.println("4) EXCLUIR");
        System.out.println("5) PESQUISAR");
        System.out.println("6) ORDENAR");
        System.out.println("0) VOLTAR ");
        System.out.println(" ");
        System.out.print("OPÇÃO:    ");

    }

    public static void menu2() {
        System.out.println("=================================================");
        System.out.println("===============SELECIONE UMA OPÇÃO===============");
        System.out.println("1) CÓDIGO  ");
        System.out.println("0) VOLTAR ");
        System.out.println("\n ");
        System.out.print("OPÇÃO:     ");

    }

    public static void menu3() {
        System.out.println("*************** MENU DE PESQUISA *****************");
        System.out.println(" \n");
        System.out.println("1) BAIRRO ");
        System.out.println("2) VALOR ");
        System.out.println("0) VOLTAR");
        System.out.println("\n ");
        System.out.print("OPÇÃO:     ");

    }

    public static void menu4() {
        System.out.println("*************** MENU DE ORDENAÇÃO*****************");
        System.out.println(" \n");
        System.out.println("1) CODIGO ");
        System.out.println("2) VALOR ");
        System.out.println("3) AREA ");
        System.out.println("0) VOLTAR");
        System.out.println("\n ");
        System.out.print("OPÇÃO:     ");

    }

    /**
     * Metodo que faz a interação com o usuário, recebendo as informações
     * passando para o construtor.
     */
    public void IncluirImovel() {

        String logradouro;
        int numero;
        String bairro;
        String cidade;
        String descricao;
        double areaTotal;
        double valor;
        String nomeEdifico;
        int andar;
        double valorCondominio;
        int numeroDeBanheiros;
        int numeroDaSala;

        logradouro = inString("DIGITE O LOGRADOURO:  ");
        numero = inInt("DIGITE O NÚMERO:  ");
        bairro = inString("DIGITE O BAIRRO:  ");
        cidade = inString("DIGITE A CIDADE:  ");
        descricao = inString("DIGITE UMA DESCRIÇÃO:  ");
        areaTotal = inDouble("DIGITE A ARÉA TOTAL:  ");
        valor = inDouble("DIGITE O VALOR:  ");
        nomeEdifico = inString("DIGITE O NOME DO EDIFÍCIO:  ");
        andar = inInt("DIGITE O NÚMERO DO ANDAR: ");
        valorCondominio = inDouble("DIGITE O VALOR DO CONDOMINIO:  ");
        numeroDaSala = inInt("DIGITE O NÚMERO DA SALA:  ");
        numeroDeBanheiros = inInt("DIGITE O NÚMERO DE BANHEIROS:  ");

        Imovel salaC = new SalaComercial(logradouro, numero, bairro, cidade,
                descricao, areaTotal, valor, nomeEdifico, andar, valorCondominio,
                numeroDeBanheiros, numeroDaSala);

        boolean objeto = lista.incluir(salaC);

        System.out.println("\n");
        if (objeto == true) {
            System.out.println("IMÓVEL INCLUIDO COM SUCESSO: ");
        } else {
            System.out.println("IMÓVEL NÃO INCLUIDO:");
        }
        try {
            ListaDeImoveis.escreveBinarioCod(caminhocod, Imovel.getCodigoStat());
            lista.escreverArquivo();
        } catch (Exception ex) {
            Logger.getLogger(MenuSalaComercial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo que recebe uma informação do usuario, e consulta se o objeto esta
     * na listaImoveis.
     */
    public void Consultar() {

        System.out.println("===============IMÓVEIS DISPONIVEIS================");
        lista.mostrarLista();
        System.out.println("\n");
        Imovel Imo = lista.consultar(inInt("DIGITE O CODIGO DO IMOVÉL: "));
        entrada.nextLine();

        if ((Imo != null) && (Imo instanceof SalaComercial)) {
            System.out.println("=======================================");
            System.out.println("*******INFORMAÇÕES DO IMÓVEL *******\n");
            System.out.println(Imo.toString());
            System.out.println("=======================================");

        } else if (Imo == null) {
            System.out.println("IMÓVEL NÃO CADASTRADO: ");
        }

    }

    public void excluirControle() {
        boolean objeto = lista.excluir(inInt(" DIGITE O CODIGO DO IMÓVEL: "));
        if (objeto == true) {

            System.out.println("IMÓVEL EXCUIDO");
            lista.escreverArquivo();
            try {
                ListaDeImoveis.escreveBinarioCod(caminhocod, Imovel.getCodigoStat());
                lista.escreverArquivo();
            } catch (Exception ex) {
                Logger.getLogger(MenuSalaComercial.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            System.out.println("IMÓVEL NÂO ENCONTRADO");
        }

    }

    /**
     * metodo que recebe as informações que seram editadas. O usuario pode
     * escolher qual informação será editada. Se o imovél não existe sai do
     * metod editar.
     */

    public void editarControle() {

        System.out.println("\n");
        System.out.println("***********  MENU EDITAR ************ ");
        System.out.println("\n ");
        System.out.println("DIGITE O CODIGO DO IMOVÉL QUE DESEJA EDITAR:");
        int codigoConsulta = entrada.nextInt();
        entrada.nextLine();
        Imovel editarLista = lista.consultar(codigoConsulta);
        entrada.nextLine();

        int i;
        double d;
        String st;

        int k = 1;

        if (editarLista != null) {

            while (k != 0) {
                System.out.println(" \n");
                System.out.println("QUAL INFORMAÇÂO DESEJA EDITAR:");
                System.out.println(" \n");
                System.out.println("0)  VOLTAR AO MENU ANTERIOR");
                System.out.println("1)  LOGRADOURO ");
                System.out.println("2)  NÚMERO");
                System.out.println("3)  BAIRRO ");
                System.out.println("4)  CIDADE ");
                System.out.println("5)  DESCRIÇÃO");
                System.out.println("6)  ARÉA TOTAL ");
                System.out.println("7)  VALOR");
                System.out.println("8)  NOME DO EDÍFIFIO ");
                System.out.println("9)  ANDAR");
                System.out.println("10) VALOR DO CONDOMINIO ");
                System.out.println("11) NÚMERO DE SALAS");
                System.out.println("12) NÚMERO DE BANHEIROS");
                System.out.println(" \n");
                System.out.print("OPÇÃO:    ");
                k = entrada.nextInt();
                entrada.nextLine();

                switch (k) {
                    case 1:
                        System.out.print("\n ");
                        st = inString("DIGITE O NOVO LOGRADOURO: ");
                        editarLista.setLogradouro(st);
                        break;
                    case 2:

                        System.out.print("\n");
                        i = inInt("DIGITE O NÚEMRO:  ");
                        editarLista.setNumero(i);

                        break;

                    case 3:

                        System.out.print("\n");
                        st = inString("DIGITE O BAIRRO:  ");
                        editarLista.setBairro(st);

                        break;

                    case 4:

                        System.out.print("\n");
                        st = inString("DIGITE A CIDADE:  ");
                        editarLista.setCidade(st);

                        break;

                    case 5:

                        System.out.print("\n");
                        st = inString("DIGITE A DESCRIÇÂO: ");
                        editarLista.setCidade(st);

                        break;

                    case 6:

                        System.out.print("\n");
                        d = inDouble("DIGITE A ARÉA TOTAL:  ");
                        editarLista.setAreaTotal(d);
                        entrada.nextLine();

                        break;

                    case 7:
                        System.out.print("\n");
                        d = inDouble("DIGITE O VALOR:  ");
                        editarLista.setValor(d);

                        break;

                    case 8:
                        System.out.print("\n");
                        st = inString("DIGITE O NOME DO EDIFICIO:  ");
                        editarLista.setNomeEdificio(st);

                        break;

                    case 9:

                        System.out.print("\n");
                        i = inInt("DIGITE O ANDAR:  ");
                        editarLista.setAndar(i);

                        break;

                    case 10:

                        System.out.print("\n");
                        d = inDouble("DIGITE O VALOR DO CONDOMINIO:  ");
                        editarLista.setValor(d);

                        break;

                    case 11:

                        System.out.print("\n");
                        i = inInt("DIGITE O NÚMERO DA SALA:  ");
                        editarLista.setNumeroDaSala(i);

                        break;

                    case 12:

                        System.out.print("\n");
                        i = inInt("DIGITE O NÚMERO DE BANHEIRO:  ");
                        editarLista.setNumeroDeBanheiros(i);

                        break;

                }

            }

            lista.editar(codigoConsulta, editarLista);
            try {
                lista.escreverArquivo();
            } catch (Exception ex) {
                Logger.getLogger(MenuSalaComercial.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("\n IMÓVEL NÂO ENCONTRADO ");
        }

    }

    private int mostrarLista(List<Imovel> lista) {
        int imovelCod;
        div();
        for (int x = 0; x < lista.size(); x++) {
            Imovel imovel = lista.get(x);
            System.out.println(imovel.getCodigo() + " Logradouro: " + imovel.getLogradouro() + " Valor:" + imovel.getValor());
        }
        div();
        return inInt("Digite o código do imóvel: ");
    }

    public void menuInicial() {
        int i;

        do {
            MenuSalaComercial.menu();
            i = entrada.nextInt();
            entrada.nextLine();

            switch (i) {
                case 1:
                    System.out.println("\n");
                    System.out.println("*********** INCUIR IMÓVEL ************");
                    System.out.println("\n");
                    IncluirImovel();
                    break;

                case 2:
                    MenuSalaComercial.menu2();
                    int opcao = entrada.nextInt();
                    entrada.nextLine();

                    switch (opcao) {
                        case 1:

                            Consultar();
                            break;

                        default:
                            break;

                    }
                    break;

                case 3:
                    editarControle();
                    break;

                case 4:
                    System.out.println("\n");
                    System.out.println("******** EXCLUIR IMÓVEL ********");
                    System.out.println("\n");
                    excluirControle();
                    break;

                case 5:
                    MenuSalaComercial.menu3();
                    opcao = entrada.nextInt();
                    entrada.nextLine();

                    switch (opcao) {
                        case 1:
                            String s = inString("INFORME O BAIRRO  ");
                            List l = lista.pesquisaBairro(s);
                            Imovel imovel = lista.consultar(mostrarLista(l));
                            System.out.println(imovel.toString());
                            break;

                        case 2:
                            double d = inDouble("INFORME O VALOR  ");
                            List k = lista.pesquisaValor(d);
                            Imovel imo = lista.consultar(mostrarLista(k));
                            System.out.println(imo.toString());

                            break;

                        default:
                            break;

                    }
                    break;

                case 6:
                    List<Imovel> aux;
                    MenuSalaComercial.menu4();
                    opcao = entrada.nextInt();
                    entrada.nextLine();

                    switch (opcao) {
                        case 1:
                            this.ListaOrdenada = this.lista.ordenarCodigo();
                            int imovelCod = this.mostrarLista(ListaOrdenada);
                            System.out.println("==========================================");
                            System.out.println(lista.consultar(imovelCod).toString());
                            System.out.println("==========================================");

                            break;

                        case 2:
                            this.ListaOrdenada = this.lista.ordenarValor();
                            imovelCod = this.mostrarLista(ListaOrdenada);
                            System.out.println("==========================================");
                            System.out.println(lista.consultar(imovelCod).toString());
                            System.out.println("==========================================");
                            break;
                        case 3:
                            this.ListaOrdenada = this.lista.ordenarArea();
                            imovelCod = this.mostrarLista(ListaOrdenada);
                            System.out.println("==========================================");
                            System.out.println(lista.consultar(imovelCod).toString());
                            System.out.println("==========================================");

                            break;
                        default:
                            break;

                    }

                default:
                    break;

            }

        } while (i != 0);

    }

}
