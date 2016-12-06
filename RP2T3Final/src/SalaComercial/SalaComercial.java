/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalaComercial;

import Imovel.Predio;
import java.io.Serializable;

/**
 * Cosntrutor da Classe extende a classe predio.
 * @author Arcano
 */
public class SalaComercial extends Predio implements Serializable {

    protected int numeroDeBanheiros;
    protected int numeroDaSala;

    /**
     * 
     * @param codigo
     * @param logradouro
     * @param numero
     * @param bairro
     * @param cidade
     * @param descricao
     * @param areaTotal
     * @param valor
     * @param nomeEdificio
     * @param andar
     * @param valorCondominio
     * @param numeroDeBanheiros
     * @param numeroDaSala 
     */
    public SalaComercial(int codigo, String logradouro, int numero, String bairro,
            String cidade, String descricao, double areaTotal, double valor,
            String nomeEdificio, int andar, double valorCondominio, int numeroDeBanheiros, int numeroDaSala) {

        super(codigo, logradouro, numero, bairro, cidade, descricao,
                areaTotal, valor, nomeEdificio, andar, valorCondominio);

        this.numeroDeBanheiros = numeroDeBanheiros;
        this.numeroDaSala = numeroDaSala;

    }

    /**
     * Metodo construtor da class SalaComercial
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
     * @param numeroDeBanheiros int
     * @param numeroDaSala int
     */
    public SalaComercial(String logradouro, int numero, String bairro,
            String cidade, String descricao, double areaTotal, double valor,
            String nomeEdificio, int andar, double valorCondominio, int numeroDeBanheiros, int numeroDaSala) {

        super(logradouro, numero, bairro, cidade, descricao,
                areaTotal, valor, nomeEdificio, andar, valorCondominio);

        this.numeroDeBanheiros = numeroDeBanheiros;
        this.numeroDaSala = numeroDaSala;

    }

    /**
     * @return the numeroDeBanheiros
     */
    @Override
    public int getNumeroDeBanheiros() {
        return numeroDeBanheiros;
    }

    /**
     * @param numeroDeBanheiros the numeroDeBanheiros to set
     */
    @Override
    public void setNumeroDeBanheiros(int numeroDeBanheiros) {
        this.numeroDeBanheiros = numeroDeBanheiros;
    }

    /**
     * @return the numeroDaSala
     */
    @Override
    public int getNumeroDaSala() {
        return numeroDaSala;
    }

    /**
     * @param numeroDaSala the numeroDaSala to set
     */
    @Override
    public void setNumeroDaSala(int numeroDaSala) {
        this.numeroDaSala = numeroDaSala;
    }

    /**
     * ToString de Sala Comercial, diz ao objeto como se escrever como uma
     * string
     *
     * @return String, dados
     */
    @Override
    public String toString() {
        String dados = super.toString();
        dados += "Número Da Sala: " + numeroDaSala + "\n";
        dados += "Número De Banheiros: " + numeroDeBanheiros + "\n";

        return dados;
    }

    /**
     * Metodo que como o cabeçalho deve se formatar para ser escrito 
     * no arquivo CSV
     * @return Dados, String 
     */
    @Override
    public String toFileTitulo() {
        String dados = super.toFileTitulo();
        dados += "NÚMERO DA SALA, NÚMERO DE BNAHEIRO";

        return dados;
    }
    
    /**
     * Metodo que como o Objeto deve se formatar para ser escrito 
     * no arquivo CSV
     * @return Dados, String 
     */
    @Override
    public String toFile() {
        String dados = super.toFile();
        dados += numeroDaSala + "," + numeroDeBanheiros;
        return dados;
    }

}
