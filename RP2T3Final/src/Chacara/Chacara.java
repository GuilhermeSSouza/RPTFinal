/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chacara;

import Imovel.Residencia;

/**
 *
 * @author Wilson
 */
public class Chacara extends Residencia {

    protected double distCidade;

    public Chacara(double distCidade, String logradouro, int numero, String bairro, String cidade, 
            String descricao, double areaTotal, double valor, double areaConstruida, int numeroQuartos, int anoConstrucao) {
        
        super(logradouro, numero, bairro, cidade, descricao, areaTotal, valor, areaConstruida, numeroQuartos, anoConstrucao);
        this.distCidade = distCidade;
    }
  
    @Override
    public double getDistCidade() {
        return distCidade;
    }

    @Override
    public void setDistCidade(double distCidade) {
        this.distCidade = distCidade;
    }

    @Override
    public String toString() {
        String dados = super.toString();
        dados += "Distância da cidade: " + distCidade + "\n";

        return dados;
    }
    
    @Override
    public String toFile() {
        String dados = super.toFile();
        dados += distCidade;
        return dados;
    }
}
