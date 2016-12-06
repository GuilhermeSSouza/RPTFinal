
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaImoveis;

import Apartamento.Apartamento;
import Casa.Casa;
import Chacara.Chacara;
import static Imovel.EntradasTeclado.div;
import Imovel.Imovel;
import SalaComercial.SalaComercial;
import java.util.ArrayList;
import java.util.List;
import Imovel.ListaImoveis;
import Imovel.Tipo;
import Imovel.TipoDeImovel;
import Terreno.Terreno;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arcano
 */
public class ListaDeImoveis implements ListaImoveis {

    List<Imovel> lista;
    private TipoDeImovel tipo;
    private String caminho;

    public ListaDeImoveis(String caminho, TipoDeImovel tipo) {
        lista = new  ListaLigadaDuplamente<>();
        this.caminho = caminho;
        this.tipo = tipo;
    }

    /**
     * @return the caminho
     */
    public String getCaminho() {
        return caminho;
    }

    /**
     * @param caminho the caminho to set
     */
    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public TipoDeImovel getTipo() {
        return tipo;

    }

    @Override
    public boolean incluir(Imovel im) {
        lista.add(im);
        return true;
    }

    @Override
    public Imovel consultar(int codigo) {

        for (Imovel imovel : lista) {
            if (codigo == imovel.getCodigo()) {
                return imovel;
            }
        }
        return null;

    }

    @Override
    public boolean editar(int codigo, Imovel imo) {

        for (Imovel imovel : lista) {
            if (imovel.getCodigo() == codigo) {
                int indice = this.lista.indexOf(imovel);
                this.lista.set(indice, imo);
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean excluir(int codigo) {
        Imovel imo = this.consultar(codigo);
        if (imo != null) {
            lista.remove(imo);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que Ordena por código, o método cria uma nova lista aux e a deixa
     * ordenada
     *
     * @return
     */
    @Override
    public List<Imovel> ordenarCodigo() {
        List<Imovel> aux = new ListaLigadaDuplamente<>();
        aux.addAll(this.lista);
        for (int i = 0; i < aux.size(); i++) {
            for (int j = 1; j < aux.size() - 1; j++) {
                if (aux.get(j).getCodigo() > aux.get(j + 1).getCodigo()) {
                    Imovel a = aux.get(j);
                    aux.set(j, aux.get(j + 1));
                    aux.set(j + 1, a);

                }
            }

        }
        return aux;
    }

    /**
     * Metodo que ordena a lista por valor.
     *
     * @return lista, lista ordenada por valor
     */
    @Override
    public List<Imovel> ordenarValor() {
        List<Imovel> aux = new ListaLigadaDuplamente<>();
        aux.addAll(this.lista);
        for (int i = 1; i < aux.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (lista.get(j).getValor() < lista.get(j - 1).getValor()) {
                    Imovel Imo = aux.get(j);
                    aux.add(j, aux.get(j - 1));
                    aux.add(j - 1, Imo);
                } else {
                    break;
                }
            }
        }
        return aux;
    }

    public void mostrarLista() {

        div();
        for (Imovel imovel : lista) {
            System.out.println("CODIGO:   " + imovel.getCodigo() + "    "
                    + " LOGRADOURO:   " + imovel.getLogradouro() + "    "
                    + " VALOR:   " + imovel.getValor());
        }
        div();

    }

    @Override
    public List<Imovel> ordenarArea() {

        List<Imovel> aux = new ListaLigadaDuplamente<>();
        aux.addAll(lista);
        for (int i = 0; i < aux.size(); i++) {
            int menor = i;
            for (int j = i + 1; j < aux.size(); j++) {
                if (aux.get(j).getAreaTotal() < aux.get(menor).getAreaTotal()) {
                    menor = j;
                }
            }

            Imovel imo = aux.get(i);
            aux.set(i, aux.get(menor));
            aux.set(menor, imo);
        }
        return aux;
    }

    /**
     * Metodo que pesquisa um Imovel pelo valor
     *
     * @param bairro, informado pelo usuario
     * @return uma lista de Imóvel, cujo valor seja menor ou igual ao valor
     * informado
     */
    @Override
    public List<Imovel> pesquisaValor(double valor) {
        List<Imovel> l = new ListaLigadaDuplamente<>();
        for (Imovel imovel : lista) {
            if (imovel.getValor() <= valor) {
                l.add(imovel);
            }
        }
        return l;
    }

    /**
     * Metodo que pesquisa um Imovel pelo bairro
     *
     * @param bairro, inoformado pelo usuario
     * @return uma lista de Imóvel
     */
    @Override
    public List<Imovel> pesquisaBairro(String bairro) {
        List<Imovel> l = new ListaLigadaDuplamente<>();
        for (Imovel imovel : lista) {
            if (imovel.getBairro().equalsIgnoreCase(bairro)) {
                l.add(imovel);
            }
        }
        return l;

    }

    /*    @Override
    public boolean escreverArquivo() {

        try {
            FileWriter outFile = new FileWriter(new File(caminho));
            BufferedWriter escrever = new BufferedWriter(outFile);

            for (Imovel imovel : lista) {
                escrever.write(imovel.toFile());
                escrever.write("\r\n");
            }
            escrever.close();
            outFile.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ListaDeImoveis.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }
     */
    /**
     * Metodo que escreve arquivos das lista, em formato binario e gurada
     * na pasta do programa
     * @return 
     */
    
    @Override
    public boolean escreverArquivo() {

        try {
            ObjectOutput output = new ObjectOutputStream(new FileOutputStream(caminho));
            output.writeObject(lista);
            output.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ListaDeImoveis.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean lerArquivo() {
        if (tipo.getValor() == 1) {
            try {
                lerApartamento();
            }  catch (IOException ex) {
                Logger.getLogger(ListaDeImoveis.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
            return true;
        }
        if (tipo.getValor() == 2) {
            try {
                lerCasa();
            }catch (IOException ex) {
                Logger.getLogger(ListaDeImoveis.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
            return true;
        }
        if (tipo.getValor() == 3) {
            try {
                lerChacara();
            }  catch (IOException ex) {
                Logger.getLogger(ListaDeImoveis.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
            return true;
        }
        if (tipo.getValor() == 4) {

            try {
                lerSalaComercial();
            } catch (IOException ex) {
                Logger.getLogger(ListaDeImoveis.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException | NullPointerException e) {
                System.out.println(e.getMessage());
            }

            return true;
        }
        if (tipo.getValor() == 5) {
            try {
                lerTerreno();
            } catch (IOException ex) {
                Logger.getLogger(ListaDeImoveis.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListaDeImoveis.class.getName()).log(Level.SEVERE, null, ex);
            }

            return true;
        }

        return false;
    }

    public boolean lerSalaComercial() throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream input;

        input = new ObjectInputStream(new FileInputStream(new File(caminho)));
        this.lista = (List<Imovel>) input.readObject();

        input.close();

        return true;
    }

    /*
    public boolean lerSalaComercial() throws FileNotFoundException, IOException {

        File file = new File(caminho);

        if (file.exists()) {
            FileInputStream arquivo;
            BufferedReader ler;
            String linha, logradouro, bairro, cidade, descricao, nomeEdificio;
            int codigo, numero, andar, numeroSala, NumeroBanheiro;
            double areaTotal, valor, valorCondominio;
            Imovel sala;
            arquivo = new FileInputStream(new File(getCaminho()));
            ler = new BufferedReader(new InputStreamReader(arquivo, "UTF-8"));

            while ((linha = ler.readLine()) != null) {
                String parte[] = linha.split(",");
                codigo = Integer.parseInt(parte[0]);
                logradouro = parte[1];
                numero = Integer.parseInt(parte[2]);
                bairro = parte[3];
                cidade = parte[4];
                descricao = parte[5];
                areaTotal = Double.parseDouble(parte[6]);
                valor = Double.parseDouble(parte[7]);
                nomeEdificio = parte[8];
                andar = Integer.parseInt(parte[9]);
                valorCondominio = Double.parseDouble(parte[10]);
                numeroSala = Integer.parseInt(parte[11]);
                NumeroBanheiro = Integer.parseInt(parte[12]);

                sala = new SalaComercial(codigo, logradouro, numero, bairro, cidade,
                        descricao, areaTotal, valor, nomeEdificio, andar,
                        valorCondominio, NumeroBanheiro, numeroSala);
                incluir(sala);

            }
            ler.close();
            arquivo.close();
            return true;

        }
        return false;
    }
     */
 /*public void gravarChacara() throws Exception {

        //verificar se o arquivo existe, se não existeir criar (o ato de recriar o mesmo arquivo ja resolve por se só?)
        FileWriter outFile = new FileWriter(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Chacara.csv"));
        BufferedWriter escrever = new BufferedWriter(outFile);

        escrever.write("CODIGO,LOGRADOURO,NÚMERO,BAIRRO,CIDADE,DESCRIÇÃO,AREA TOTAL,VALOR,ÁREA CONSTRUIDA,NÚMERO DE QUARTOS,ANO DE CONSTRUÇÃO,"
                + "DISTÂNCIA DA CIDADE\r\n");

        // criar um metodo nas class abstratas Filewhite. 
        for (Imovel imovel : lista) {
            escrever.write(imovel.getCodigo() + "," + imovel.getLogradouro() + "," + imovel.getNumero()
                    + "," + imovel.getBairro() + "," + imovel.getCidade() + "," + imovel.getDescricao() + "," + imovel.getAreaTotal() + "," + imovel.getValor()
                    + "," + imovel.getAreaConstruida() + "," + imovel.getNumeroQuartos() + "," + imovel.getAnoConstrucao()
                    + "," + imovel.getDistCidade());
            escrever.write("\r\n");

        }
        escrever.close();
        outFile.close();

    }*/
    public boolean lerChacara() throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream input;

        input = new ObjectInputStream(new FileInputStream(new File(caminho)));
        this.lista = (List<Imovel>) input.readObject();

        input.close();

        return true;
    
    }

    public boolean lerApartamento() throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream input;

        input = new ObjectInputStream(new FileInputStream(new File(caminho)));
        this.lista = (List<Imovel>) input.readObject();

        input.close();

        return true;
    }

    /*
    public boolean gravarApartamento() {

        try {
            FileWriter outFile = new FileWriter(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Apartamento.csv"));
            BufferedWriter escrever = new BufferedWriter(outFile);
            Imovel mo = lista.get(0);
            escrever.write(mo.toFileTitulo());
            escrever.write("\r\n");

            for (Imovel imovel : lista) {
                escrever.write(imovel.toFile());
                escrever.write("\r\n");
            }
            escrever.close();
            outFile.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(MenuApartamento.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    
    public boolean gravarCasa() {

        try {
            FileWriter outFile = new FileWriter(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Casa.csv"));
            BufferedWriter escrever = new BufferedWriter(outFile);
            Imovel mo = lista.get(0);
            escrever.write(mo.toFileTitulo());
            escrever.write("\r\n");

            for (Imovel imovel : lista) {
                escrever.write(imovel.toFile());
                escrever.write("\r\n");
            }
            escrever.close();
            outFile.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(MenuCasa.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }
     */
    public boolean lerCasa() throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream input;

        input = new ObjectInputStream(new FileInputStream(new File(caminho)));
        this.lista = (List<Imovel>) input.readObject();

        input.close();

        return true;
    }

    /*
    *Método que cria um arquivo e grava o imovel terreno
     */
 /*
    public boolean gravarTerreno() {

        try {
            FileWriter outFile = new FileWriter(new File(System.getProperty("user.dir") 
                    + System.getProperty("file.separator") + "Terreno.csv"));
            BufferedWriter escrever = new BufferedWriter(outFile);
            Imovel mo = lista.get(0);
            escrever.write(mo.toFileTitulo());
            escrever.write("\r\n");

            for (Imovel imovel : lista) {
                escrever.write(imovel.toFile());
                escrever.write("\r\n");
            }
            escrever.close();
            outFile.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(MenuTerreno.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }
     */
    public boolean lerTerreno() throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream input;

        input = new ObjectInputStream(new FileInputStream(new File(caminho)));
        this.lista = (List<Imovel>) input.readObject();

        input.close();

        return true;
    }
    
      
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="codigo">
    public static void escreveBinarioCod(String file, int o) throws FileNotFoundException, IOException {
        FileOutputStream outFileSe = new FileOutputStream(file);// Define que o arquivo acima é para escrita em bin
        ObjectOutputStream out = new ObjectOutputStream(outFileSe);// Criar um mecanismo para escrita
        out.writeObject(o);//Grava a lista toda em .bin
        outFileSe.close();// Fecha o arquivo
        out.close();// Fecha o mecanismo
    }

    public static void lerArquivoBinarioCod(String file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(file);//Abrir o arquivo .bin em modo de leitura
        ObjectInputStream in = new ObjectInputStream(fileIn);//Abrindo o mecanismo pra ler o .bin
        int cod = (int) in.readObject();
        in.close(); // fecha o mecanismo
        fileIn.close();// fecha o arquivo
        Imovel.setCodigoStat(++cod);
    }
//</editor-fold>

}
