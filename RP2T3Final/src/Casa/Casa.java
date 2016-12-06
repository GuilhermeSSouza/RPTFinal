/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casa;

import Imovel.Residencia;
import Imovel.Tipo;

/**
 *
 * @author Amanda Gobus
 */
public class Casa extends Residencia {

    private Tipo tipo;
    private int numeroDeVagas;

    /**
     * @param tipo
     * @param logradouro
     * @param numero
     * @param bairro
     * @param cidade
     * @param descricao
     * @param areaTotal
     * @param valor
     * @param areaConstruida
     * @param numeroQuartos
     * @param anoConstucao
     * @param numeroDeVagas
     */
    public Casa(String logradouro, int numero, String bairro, String cidade, 
            String descricao, int areaTotal, double valor, double areaConstruida,
            int numeroQuartos, int anoConstucao, Tipo tipo, int numeroDeVagas) {
        super(logradouro, numero, bairro, cidade, descricao, areaTotal, valor,
                areaConstruida, numeroQuartos, anoConstucao);
        this.tipo = tipo;
        this.numeroDeVagas = numeroDeVagas;
    }
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
     * @param areaConstruida
     * @param numeroQuartos
     * @param anoConstucao
     * @param tipo
     * @param numeroDeVagas 
     */
     public Casa(int codigo, String logradouro, int numero, String bairro,
             String cidade, String descricao, int areaTotal, double valor, 
             double areaConstruida, int numeroQuartos, int anoConstrucao,
             Tipo tipo, int numeroDeVagas) {
        super(codigo, logradouro, numero, bairro, cidade, descricao, areaTotal, 
                valor, areaConstruida, numeroQuartos, anoConstrucao);
        this.tipo = tipo;
        this.numeroDeVagas = numeroDeVagas;
    }

    /**
     * 
     * @return Tipo
     */
    public Tipo getTipo() {
        return tipo;
    }
/**
 * 
 * @param tipo 
 */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
/**
 * 
 * @return NumeroDeVagas
 */
    public int getNumeroDeVagas() {
        return numeroDeVagas;
    }
    /**
     * 
     * @param numeroDeVagas 
     */
    public void setNumeroDeVagas(int numeroDeVagas) {
        this.numeroDeVagas = numeroDeVagas;
    }

    /**
     *
     * @return dados
     */
    @Override
    public String toString() {
        String dados = super.toString();
        dados += "Número De Vagas: " + numeroDeVagas + "\n";
        dados += "Tipo: " + tipo + "\n";

        return dados;
    }
    
    @Override
    public String toFile() {
        String dados = super.toFile();
        dados += numeroQuartos+ "," + tipo;
        return dados;
    }
    
}
