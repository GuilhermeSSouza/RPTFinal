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
import Terreno.Terreno;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que reune os principais metodos de funcionabilidade dos objetos salvos
 * no sistema.
 *
 * @author Julielen
 */
public class MenuTerreno {

    Terreno terreno;
    ListaDeImoveis lista;
    private List<Imovel> ListaOrdenada;
    private int codigoImovel;
    Scanner entrada = new Scanner(System.in);
    private String caminhocod = System.getProperty("user.dir") + System.getProperty("file.separator") +"CodigoImovel.bin";

    public MenuTerreno() {
        TipoDeImovel tipo;
        tipo = TipoDeImovel.TERRENO;
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
            System.out.println("Arquivos Carregados ");
        } else {
            System.out.println("Arquivo não Iniciados ");
        }

    }

    /**
     * Metodo chamado menu, que exibe as opçoes novo imovel, consultar, editar,
     * excluir, pesquisar, ordenar um imovel e voltar ao menu anterior.
     */
    public static void menu() {
        System.out.println(" \n");
        System.out.println("***** Menu *****\n");
        System.out.println("1) Novo Imóvel Terreno ");
        System.out.println("2) Consultar ");
        System.out.println("3) Editar ");
        System.out.println("4) Excluir ");
        System.out.println("5) Pesquisar ");
        System.out.println("6) Ordenar ");
        System.out.println("7) Voltar ");
        System.out.println(" ");
        System.out.print("Opção: ");
    }

    public static void menu2() {
        System.out.println(" \n");
        System.out.println("*************** MENU DE CONSULTA *****************");
        System.out.println(" \n");
        System.out.println("1) Código ");
        System.out.println("2) Voltar ");
        System.out.println("\n ");
        System.out.print("Opção: ");

    }

    public static void menu3() {
        System.out.println("=================================================");
        System.out.println("===============SELECIONE UMA OPÇÃO===============");
        System.out.println("1) Bairro ");
        System.out.println("2) Valor ");
        System.out.println("0) Voltar ");
        System.out.println("\n ");
        System.out.print("Opção: ");
    }

    public static void menu4() {
        System.out.println("*************** MENU DE ORDENAÇÃO ****************");
        System.out.println(" \n");
        System.out.println("1) Área ");
        System.out.println("2) Código ");
        System.out.println("3) Valor ");
        System.out.println("4) Voltar ");
        System.out.println("\n ");
        System.out.print("Opção: ");
    }

    /**
     * Metodo que faz a interação com o usuário, incluindo um novo imovel.
     */
    public void IncluirImovel() {

        String logradouro;
        int numero;
        String bairro;
        String cidade;
        String descricao;
        double areaTotal;
        double valor;
        double dimensaoFrente;
        double dimensaoLado;

        logradouro = inString("Digite o Logradouro:  ");

        numero = inInt("Digite o numero: ");

        bairro = inString("Digite o Bairro:  ");

        cidade = inString("Digite a Cidade:  ");

        descricao = inString("Digite Uma Descriçãoo:  ");

        areaTotal = inDouble("Digite a Área Total:  ");

        valor = inDouble("Digite o Valor do Imóvel:  ");

        dimensaoFrente = inDouble("Digite a Dimensão Frente: ");

        dimensaoLado = inDouble("Digite a Dimensão Lado: ");

        Imovel t = new Terreno(logradouro, numero, bairro, cidade,
                descricao, areaTotal, valor, dimensaoFrente, dimensaoLado);

        boolean objeto = lista.incluir(t);

        System.out.println("\n\n");
        if (objeto == true) {
            System.out.println("Imóvel incluído com sucesso.");
        } else {
            System.out.println("Imóvel não foi incluído.");
        }
        try {
            ListaDeImoveis.escreveBinarioCod(caminhocod, Imovel.getCodigoStat());
            lista.escreverArquivo();
        } catch (Exception ex) {
            Logger.getLogger(MenuTerreno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * MÃ©todo que recebe uma informação do usuario, e consulta por código se o
     * objeto esta na listaImoveis.
     */
    public void Consultar() {

        lista.mostrarLista();
        System.out.println("Digite o Código Que Deseja Consultar: ");
        Imovel Imo = lista.consultar(entrada.nextInt());
        entrada.nextLine();

        if ((Imo != null) && (Imo instanceof Terreno)) {
            System.out.println("=======================================");
            System.out.println("*******INFORMAÇÕES DO IMÓVEL *****\n");
            System.out.println(Imo.toString());
            System.out.println("=======================================");

        } else if (Imo == null) {
            System.out.println("Imóvel Não Cadastrado;");

        }
    }

    /**
     * Método que recebe uma informação do usuario e consulta por código se o
     * objeto esta na listaImoveis para poder executar a exclusao do mesmo.
     */
    public void excluirControle() {
        System.out.println(" Digite o Código do Imóvel: ");
        boolean objeto = lista.excluir(entrada.nextInt());
        if (objeto == true) {

            System.out.println("Imóvel Excluído! ");
            lista.escreverArquivo();
            try {
           ListaDeImoveis.escreveBinarioCod(caminhocod, Imovel.getCodigoStat());
            lista.escreverArquivo();
        } catch (Exception ex) {
            Logger.getLogger(MenuSalaComercial.class.getName()).log(Level.SEVERE, null, ex);
        }
        } else {

            System.out.println("Imóvel Não Encontrado! ");
        }
    }

    /**
     * Metodo que edita uma informacao por codigo
     */
    public void editarControle() {

        System.out.println("\n");
        System.out.println("***********  MENU EDITAR ************ ");
        System.out.println("\n ");
        System.out.println("Digite o Código do Imóvel que Deseja Editar: ");
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
                System.out.println("O que deseja Editar: ");
                System.out.println(" \n");
                System.out.println("1) Logradouro ");
                System.out.println("2) Número ");
                System.out.println("3) Bairro ");
                System.out.println("4) Cidade ");
                System.out.println("5) Descrição ");
                System.out.println("6) Área Total ");
                System.out.println("7) Valor ");
                System.out.println("8)Dimensão Frente ");
                System.out.println("9) Dimensão Lado ");
                System.out.println("0) Voltar ao Menu Anterior ");
                System.out.println(" \n");
                System.out.print("Opção:    ");
                k = entrada.nextInt();
                entrada.nextLine();

                switch (k) {
                    case 1:
                        System.out.print("\n ");
                        st = inString("Digite o Novo Logradouro: ");
                        editarLista.setLogradouro(st);
                        break;
                    case 2:
                        System.out.print("\n\n");
                        i = inInt("Digite o Número:  ");
                        editarLista.setNumero(i);
                        break;

                    case 3:
                        System.out.print("\n");
                        st = inString("Digite o Bairro:  ");
                        editarLista.setBairro(st);
                        break;

                    case 4:
                        System.out.print("\n");
                        st = inString("Digite a Cidade:  ");
                        editarLista.setCidade(st);
                        break;

                    case 5:
                        System.out.print("\n");
                        st = inString("Digite a Descrição: ");
                        editarLista.setCidade(st);
                        break;

                    case 6:
                        System.out.print("\n");
                        d = inDouble("Digite a Área Total:  ");
                        editarLista.setAreaTotal(d);
                        entrada.nextLine();
                        break;

                    case 7:
                        System.out.print("\n");
                        d = inDouble("Digite o Valor:  ");
                        editarLista.setValor(d);
                        break;

                    case 8:
                        System.out.print("\n");
                        d = inDouble("Digite a Dimensão Frente:  ");
                        editarLista.setDimensaoFrente(d);
                        break;

                    case 9:
                        System.out.print("\n");
                        d = inDouble("Digite a Dimensão Lado:  ");
                        editarLista.setDimensaoLado(d);
                        break;
                }
            }

            lista.editar(codigoConsulta, editarLista);
            try {
                lista.escreverArquivo();
            } catch (Exception ex) {
                Logger.getLogger(MenuTerreno.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("\n Imóvel Não Encontrado! ");
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
            MenuTerreno.menu();
            i = entrada.nextInt();
            entrada.nextLine();

            switch (i) {
                case 1:
                    System.out.println("\n");
                    System.out.println("*********** Incluir Imóvel ************");
                    System.out.println("\n");
                    IncluirImovel();
                    break;

                case 2:
                    MenuTerreno.menu2();
                    int opcao = entrada.nextInt();
                    entrada.nextLine();

                    switch (opcao) {
                        case 1:
                            System.out.println("\n");
                            System.out.println("******** Consultar Imóvel Por Código ********");
                            System.out.println("\n\n");
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
                    System.out.println("******** Excluir Imóvel ********");
                    System.out.println("\n");
                    excluirControle();

                    break;

                case 5:
                    MenuTerreno.menu3();
                    opcao = entrada.nextInt();
                    entrada.nextLine();

                    switch (opcao) {
                        case 1:
                            String s = inString(" Informe o Bairro:  ");
                            List l = lista.pesquisaBairro(s);
                            Imovel imovel = lista.consultar(mostrarLista(l));
                            System.out.println(imovel.toString());
                            break;

                        case 2:
                            double d = inDouble(" Informe o Valor:  ");
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
                    MenuTerreno.menu4();
                    opcao = entrada.nextInt();
                    entrada.nextLine();

                    switch (opcao) {
                        case 1:
                            aux = lista.ordenarArea();
                            System.out.println(aux.toString());

                            break;

                        case 2:
                            aux = lista.ordenarCodigo();
                            System.out.println(aux.toString());
                            break;

                        case 3:
                            aux = lista.ordenarValor();
                            System.out.println(aux.toString());

                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    System.out.println("Opção Inválida! ");

            }

        } while (i != 0);

    }

}
