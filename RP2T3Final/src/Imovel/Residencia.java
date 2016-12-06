/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imovel;

import java.io.Serializable;

/**
 *
 * @author Arcano
 */
public abstract class Residencia extends Imovel implements Serializable {

    protected double areaConstruida;
    protected int numeroQuartos;
    protected int anoConstrucao;

    /**
     *Metodo Construtor da class Residência
     * @param logradouro
     * @param numero
     * @param bairro
     * @param cidade
     * @param descricao
     * @param areaTotal
     * @param valor
     * @param areaConstruida
     * @param numeroQuartos
     * @param anoConstrucao
     */
    public Residencia(String logradouro, int numero, String bairro,
            String cidade, String descricao, double areaTotal, double valor,
            double areaConstruida, int numeroQuartos, int anoConstrucao) {

        super(logradouro, numero, bairro, cidade, descricao, areaTotal, valor);
        this.areaConstruida = areaConstruida;
        this.numeroQuartos = numeroQuartos;
        this.anoConstrucao = anoConstrucao;
    }
    
    public Residencia(int codigo, String logradouro, int numero, String bairro,
            String cidade, String descricao, double areaTotal, double valor,
            double areaConstruida, int numeroQuartos, int anoConstrucao) {

        super(codigo, logradouro, numero, bairro, cidade, descricao, areaTotal, valor);
        this.areaConstruida = areaConstruida;
        this.numeroQuartos = numeroQuartos;
        this.anoConstrucao = anoConstrucao;
    }
    /**
     * get AreaConstruida
     *
     * @return areaCosntruida, int.
     */
    @Override
    public double getAreaConstruida() {
        return areaConstruida;
    }

    /**
     * @param areaConstruida the areaConstruida to set
     */
    @Override
    public void setAreaConstruida(double areaConstruida) {
        this.areaConstruida = areaConstruida;
    }

    /**
     * @return the numeroQuartos
     */
    @Override
    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    /**
     * @param numeroQuartos the numeroQuartos to set
     */
    @Override
    public void setNumeroQuartos(int numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    /**
     * @return the anoConstrucao
     */
    @Override
    public int getAnoConstrucao() {
        return anoConstrucao;
    }

    /**
     * @param anoConstrucao the anoConstrucao to set
     */
    @Override
    public void setAnoConstrucao(int anoConstrucao) {
        this.anoConstrucao = anoConstrucao;
    }

    @Override
    public String toString() {
        String dados = super.toString();
        dados += "Area Construida: " + areaConstruida + "\n";
        dados += "Número De Quartos: " + numeroQuartos + "\n";
        dados += "Ano Da Costrução: " + anoConstrucao + "\n";

        return dados;
    }
    
    @Override
    public String toFile() {
        String dados = super.toFile();
        dados += areaConstruida + "," + numeroQuartos + "," + anoConstrucao + ",";
        return dados;
    }

}
