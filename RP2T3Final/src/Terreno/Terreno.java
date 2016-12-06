/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Terreno;

import Imovel.Imovel;
import Imovel.TipoDeImovel;

/**
 * Classe para objetos do tipo Terreno, onde serÃ£o contidos valores e mÃ©todos para o mesmo.
 * @author Julielen
 */
public class Terreno extends Imovel {

    private double dimensaoFrente;
    private double dimensaoLado;
    
    /**
     * Construtor Classe Terreno que estende atributos da classe Imovel
     * @param logradouro
     * @param numero
     * @param bairro
     * @param cidade
     * @param descricao
     * @param areaTotal
     * @param valor
     * @param dimensaoFrente
     * @param dimensaoLado 
     */

    public Terreno(String logradouro, int numero, String bairro, String cidade, String descricao, 
            double areaTotal, double valor, double dimensaoFrente, double dimensaoLado) {
        super(logradouro, numero, bairro, cidade, descricao, areaTotal, valor);
        this.dimensaoFrente = dimensaoFrente;
        this.dimensaoLado = dimensaoLado;
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
     * @param dimensaoFrente
     * @param dimensaoLado 
     */
    public Terreno(int codigo,String logradouro, int numero, String bairro, String cidade, String descricao, 
            double areaTotal, double valor, double dimensaoFrente, double dimensaoLado) {
        super(codigo, logradouro, numero, bairro, cidade, descricao, areaTotal, valor);
        this.dimensaoFrente = dimensaoFrente;
        this.dimensaoLado = dimensaoLado;
    }

    /**
     * @return the dimensaoFrente
     */
    public double getDimensaoFrente() {
        return dimensaoFrente;
    }

    /**
     * @param dimensaoFrente the dimensaoFrente to set
     */
    @Override
    public void setDimensaoFrente(double dimensaoFrente) {
        this.dimensaoFrente = dimensaoFrente;
    }

    /**
     * @return the dimensaoLado
     */
    public double getDimensaoLado() {
        return dimensaoLado;
    }

    /**
     * @param dimensaoLado the dimensaoLado to set
     */
    @Override
    public void setDimensaoLado(double dimensaoLado) {
        this.dimensaoLado = dimensaoLado;
    }
     /**
     * ToString de Terreno, diz ao objeto como se escrever como uma string
     * @return Strings, dados
     */
    @Override
    public String toString() {
        String dados = super.toString();
        dados += "Dimensão Frente: " + dimensaoFrente + "\n";
        dados += "Dimensão Lado: " + dimensaoLado + "\n";

        return dados;
    }
    
    /**
     * Metodo que como o cabeçalho deve se formatar para ser escrito 
     * no arquivo CSV
     * @return Dados, String 
     */
    @Override
    public String toFileTitulo(){
    String dados = super.toFileTitulo();
    dados += "Dimensão Frente, Dimensão Lado"; 
    return dados;
    }
    
    /**
     * Metodo que como o Objeto deve se formatar para ser escrito 
     * no arquivo CSV
     * @return Dados, String 
     */
    @Override
    public String toFile(){
        String dados = super.toFile();
        dados +=dimensaoFrente+","+dimensaoLado;
        return dados;
    }

}
