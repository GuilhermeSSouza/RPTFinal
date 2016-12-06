/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Imovel.Imovel;
import ListaImoveis.ListaDeImoveis;
import java.util.Scanner;
import Casa.Casa;
import static Imovel.EntradasTeclado.div;
import static Imovel.EntradasTeclado.inDouble;
import static Imovel.EntradasTeclado.inInt;
import static Imovel.EntradasTeclado.inString;
import Imovel.Tipo;
import Imovel.TipoDeImovel;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amanda Gobus
 */
public class MenuCasa {

    Casa casa;
    ListaDeImoveis lista;
    private List<Imovel> ListaOrdenada;
    private int codigoImovel;
    Scanner entrada = new Scanner(System.in);
    private String caminhocod = System.getProperty("user.dir") + System.getProperty("file.separator") +"CodigoImovel.bin";
    
    public MenuCasa() {
        TipoDeImovel tipo;
        tipo = TipoDeImovel.CASA;
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
     * Método chamado menu, que exibe as opções Novo Imóvel e Consultar
     */
    public void menuInicial() {
        int opcao = -1;
        do {
            System.out.println(" \n");
            System.out.println("***** CASA *****\n");
            System.out.println("1) Novo Imóvel CASA ");
            System.out.println("2) Consultar");
            System.out.println("3) Editar ");
            System.out.println("4) Excluir");
            System.out.println("5) Ordenar");
            System.out.println("6) Pesquisar");
            System.out.println("0) Sair ");
            System.out.println(" ");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    IncluirImovel();
                    break;
                case 2:
                    Consultar();
                    break;
                case 3:
                    Editar();
                    break;
                case 4:
                    Excluir();
                    break;
                case 5:
                    ordenar();
                    break;
                case 6:
                    MenuApartamento.menu2();
                    opcao = inInt("Opção: ");
                    switch (opcao) {
                        case 1:
                            String s = inString("Informe o Bairro: ");
                            List l = lista.pesquisaBairro(s);
                            Imovel imovel = lista.consultar(mostrarLista(l));
                            System.out.println(imovel.toString());
                            break;
                        case 2:
                            double d = inDouble("Informe o Valor: ");
                            List k = lista.pesquisaValor(d);
                            Imovel imo = lista.consultar(mostrarLista(k));
                            System.out.println(imo.toString());
                            break;

                    }
                    break;
            }
        } while (opcao != 0);

    }

    public static void menu2() {
        System.out.println("=================================================");
        System.out.println("===============Selecione uma opção===============");
        System.out.println("  1)Bairro  ");
        System.out.println("  2)Valor");
        System.out.println("");

    }

    
    /**
     * Método de Incluir um novo Imóvel
     */
    public void IncluirImovel() {
        String logradouro;
        int numero;
        String bairro;
        String cidade;
        String descricao;
        double areaTotal;
        double valor;

        int tipo;
        double areaConstruida;
        int numeroQuartos;
        int anoConstrucao;

        int numeroDeVagas;

        System.out.println("=======================================");
        logradouro = inString("Digite o Logradouro:  ");
        numero = inInt("Digite o Número:  ");

        bairro = inString("Digite o Bairro:  ");

        cidade = inString("Digite a Cidade:  ");

        descricao = inString("Digite Uma Descrição:  ");

        areaTotal = inDouble("Digite a Área Total:  ");

        valor = inDouble("Digite o Valor do Imóvel:  ");

        areaConstruida = inDouble("Digite a Área Construída:  ");

        numeroQuartos = inInt("Digite o Número de Quartos:  ");

        numeroDeVagas = inInt("Digite o Número de Vagas na garagem:  ");

        anoConstrucao = inInt("Digite o Ano de Construção:  ");

        System.out.println("Digite o Tipo do Imóvel: ");
        System.out.println("  1) RESIDENCIAL       2)COMERCIAL ");
        tipo = entrada.nextInt();
        Tipo t = Tipo.CasaTipo(tipo);
        Imovel casa = new Casa(logradouro, numero, bairro, cidade, descricao,
                numero, valor, areaConstruida, numeroQuartos, anoConstrucao,
                t, numeroDeVagas);
        System.out.println("=======================================");

        boolean objeto = lista.incluir(casa);

        System.out.println("\n\n");
        if (objeto == true) {
            System.out.println("Imóvel incluido com sucesso.");
        } else {
            System.out.println("Imóvel não foi incluido.");
        }
        try {
           ListaDeImoveis.escreveBinarioCod(caminhocod, Imovel.getCodigoStat());
            lista.escreverArquivo();
        } catch (Exception ex) {
            Logger.getLogger(MenuCasa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int mostrarLista(List<Imovel> lista) {
        int imovelCod;
        div();
        for (Imovel imovel : lista) {
            System.out.println(imovel.getCodigo() + " Logradouro: " + imovel.getLogradouro() + " Valor:" + imovel.getValor());
        }
        div();
        return inInt("Digite o código do imóvel: ");
    }

    /**
     * Método de ordenar
     */
    private void ordenar() {
        System.out.println("============================================");
        System.out.println("1)Ordenar por código");
        System.out.println("2)Ordenar por valor");
        System.out.println("3)Ordenar por área ");
        System.out.println("--------------------------------------------");
        int opcao = inInt("Digite a opção: ");
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
                System.out.println("Opção Inválida ");
        }
    }

    /**
     * Método de consultar por código
     */
    public void Consultar() {
        
        lista.mostrarLista();
        System.out.println("Digite o Código Que Deseja Consultar: ");
        Imovel Imo = lista.consultar(entrada.nextInt());
        entrada.nextLine();

        if ((Imo != null) && (Imo instanceof Casa)) {
            System.out.println("=======================================");
            System.out.println("*****INFORMAÇÕES DO IMÓVEL *****\n");
            System.out.println(Imo.toString());
            System.out.println("=======================================");
        } else {
            System.out.println("Imóvel Não Cadastrado.");
        }

    }

    /**
     * Método que exclui um imóvel pelo codigo
     */
    public void Excluir() {
        System.out.println("Digite o código do imóvel que você deseja excluir: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();
        lista.excluir(codigo);

    }

    /**
     * Método que edita atributos de um imóvel
     */
    public void Editar() {
        System.out.println("Qual o código do imóvel você quer editar: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();
        casa = (Casa) lista.consultar(codigo);
        if (casa != null) {
            System.out.println(casa.toString());
            System.out.print("Qual atributo você quer editar: ");
            String atributo = entrada.nextLine();

            switch (atributo) {
                case "logradouro":
                    casa.setLogradouro(inString(" Digite o  logradouro:"));

                    break;
                case "numero":
                    casa.setNumero(inInt("Digite o número: "));

                    break;
                case "bairro":
                    casa.setBairro(inString("Digite o número: "));
                    break;
                case "cidade":
                    casa.setCidade(inString("Digite a Cidade: "));

                    break;
                case "descricao":

                    casa.setDescricao(inString("Digite a Descrição: "));

                    break;
                case "area total":
                    casa.setAreaTotal(inDouble("Digite a Área Total: "));

                    break;
                case "valor do imovel":
                    casa.setValor(inDouble("Digite o valor do Imóvel: "));

                    break;
                case "area Construida":
                    casa.setAreaConstruida(inDouble("Digite a Área Construída: "));

                    break;
                case "numero de quartos":
                    casa.setNumeroQuartos(inInt("Digite o Número de Quartos: "));

                    break;
                case "numero de vagas":
                    casa.setNumeroDeVagas(inInt("Digite o Número de vagas na garagem: "));

                    break;

                case "ano de construcao":
                    casa.setAnoConstrucao(inInt("Digite o ano de Construção: "));

                    break;

                case "tipo":
                    System.out.println("Digite o Tipo do Imóvel: ");
                    System.out.println("  1) RESIDENCIAL       2)COMERCIAL ");
                    int tipo = entrada.nextInt();
                    Tipo novotipo = Tipo.CasaTipo(tipo);
                    casa.setTipo(novotipo);

                    break;

            }

            lista.editar(codigo, casa);
            try {
                lista.escreverArquivo();
            } catch (Exception ex) {
                Logger.getLogger(MenuCasa.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("\n IMÓVEL NÂO ENCONTRADO ");
        }

    }

}
