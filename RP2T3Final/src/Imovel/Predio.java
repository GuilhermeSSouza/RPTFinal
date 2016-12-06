
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imovel;

import java.io.Serializable;

/**
 * Construtor da classe abstrada predio, extende a classe mãe Imovel.
 * @author Arcano
 */
public abstract class Predio extends Imovel implements Serializable {

    protected String nomeEdificio;
    protected int andar;
    protected double valorCondominio;

    public Predio(int codigo, String logradouro, int numero, String bairro,
            String cidade, String descricao, double areaTotal, double valor,
            String nomeEdificio, int andar, double valorCondominio) {
        super(codigo, logradouro, numero, bairro,
                cidade, descricao, areaTotal, valor);

        this.nomeEdificio = nomeEdificio;
        this.andar = andar;
        this.valorCondominio = valorCondominio;

    }

    /**
     * Metodo construtor da class predio.
     *
     * @param logradouro String
     * @param numero int
     * @param bairro String
     * @param cidade String
     * @param descricao String
     * @param areaTotal double
     * @param valor double
     * @param nomeEdificio String
     * @param andar int
     * @param valorCondominio double
     */
    public Predio(String logradouro, int numero, String bairro,
            String cidade, String descricao, double areaTotal, double valor,
            String nomeEdificio, int andar, double valorCondominio) {

        super(logradouro, numero, bairro, cidade, descricao, areaTotal, valor);

        this.nomeEdificio = nomeEdificio;
        this.andar = andar;
        this.valorCondominio = valorCondominio;
    }

    /**
     * @return the NomeEdifico
     */
    @Override
    public String getNomeEdificio() {
        return nomeEdificio;
    }

    /**
     * @param NomeEdificio the NomeEdifico to set
     */
    @Override
    public void setNomeEdificio(String NomeEdificio) {
        this.nomeEdificio = NomeEdificio;
    }

    /**
     * @return the andar
     */
    @Override
    public int getAndar() {
        return andar;
    }

    /**
     * @param andar the andar to set
     */
    @Override
    public void setAndar(int andar) {
        this.andar = andar;
    }

    /**
     * @return the valorCondominio
     */
    @Override
    public double getValorCondominio() {
        return valorCondominio;
    }

    /**
     * @param valorCondominio the valorCondominio to set
     */
    @Override
    public void setValorCondominio(double valorCondominio) {
        this.valorCondominio = valorCondominio;
    }

    /**
     * Metodo toString do objeto, predio.
     *
     * @return
     */
    @Override
    public String toString() {
        String dados = super.toString();
        dados += "Nome Do Edíficio:" + nomeEdificio + "\n";
        dados += "Andar: " + andar + "\n";
        dados += "Valor Do Condominio: " + valorCondominio + "\n";

        return dados;
    }
    
    /**
     * ToString de Sala Comercial, diz ao objeto como se escrever como uma
     * string
     *
     * @return String, dados
     */

    @Override
    public String toFileTitulo() {
        String dados = super.toFileTitulo();
        dados += "NOME DO EDIFICIO, ANDAR, VALOR DO CONDOMINIO,";
        return dados;
    }

    /**
     * Metodo que como o cabeçalho deve se formatar para ser escrito 
     * no arquivo CSV
     * @return Dados, String 
     */
    @Override
    public String toFile() {
        String dados = super.toFile();
        dados += nomeEdificio + "," + andar + "," + valorCondominio + ",";

        return dados;

    }

}
