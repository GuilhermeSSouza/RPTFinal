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
public abstract class Imovel implements Serializable{

    protected static int codigoGeral = 1;
    protected int codigo;
    protected String logradouro;
    protected int numero;
    protected String bairro;
    protected String cidade;
    protected String descricao;
    protected double areaTotal;
    protected double valor;

    public Imovel(int codigo, String logradouro, int numero, String bairro,
            String cidade, String descricao, double areaTotal, double valor) {
        this.codigo = codigo;
        this.codigoGeral = 1 + codigo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.descricao = descricao;
        this.areaTotal = areaTotal;
        this.valor = valor;

    }

    /**
     * Construtor da Super Classe Imovéis
     *
     * @param codigo
     * @param logradouro
     * @param numero
     * @param bairro
     * @param cidade
     * @param descricao
     * @param areaTotal
     * @param valor
     */
    public Imovel(String logradouro, int numero, String bairro, String cidade, String descricao, double areaTotal, double valor) {
        this.codigo = codigoGeral;
        codigoGeral++;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.descricao = descricao;
        this.areaTotal = areaTotal;
        this.valor = valor;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the areaTotal
     */
    public double getAreaTotal() {
        return areaTotal;
    }

    /**
     * @param areaTotal the areaTotal to set
     */
    public void setAreaTotal(double areaTotal) {
        this.areaTotal = areaTotal;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    //Bloco com os metodos abstratos, USAR em Editar, e para escrver Arquivos.
    double i;
    int k;
    String st;

    public int getNumeroDeBanheiros() {
        return k;
    }

    public int getNumeroDaSala() {
        return k;
    }

    public String getNomeEdificio() {
        return st;
    }

    public int getAndar() {
        return k;
    }

    public double getValorCondominio() {
        return i;
    }

    public void setNumeroDeBanheiros(int k) {

    }

    public void setNumeroDaSala(int k) {

    }

    public void setNomeEdificio(String st) {

    }

    public void setAndar(int k) {

    }

    public void setValorCondominio(double i) {
    }

    public double getAreaConstruida() {
        return i;
    }

    public void setAreaConstruida(double i) {
    }

    public int getNumeroQuartos() {
        return k;
    }

    public void setNumeroQuartos(int k) {
    }

    public int getAnoConstrucao() {
        return k;
    }

    public void setAnoConstrucao(int k) {
    }

    public double getDistCidade() {
        return i;
    }

    public void setDistCidade(double i) {
    }
    
     public double getDimensaoFrente(double d) {
        return i;
    }

    public void setDimensaoFrente(double d) {
    }

    public double getDimensaoLado(double d) {
        return i;
    }

    public void setDimensaoLado(double d) {
    }



    /**
     * Diz como o Objeto imoveis deve se escrever como uma String.
     *
     * @return dados, String.
     */
    @Override
    public String toString() {

        String dados = " ";
        dados += "\n";
        dados += "Codigo: " + codigo + "\n";
        dados += "Logradouro: " + logradouro + "\n";
        dados += "Número: " + numero + "\n";
        dados += "Bairro: " + bairro + "\n";
        dados += "Cidade: " + cidade + "\n";
        dados += "Descrição: " + descricao + "\n";
        dados += "Area Total: " + areaTotal + "\n";
        dados += "Valor: " + valor + "\n";

        return dados;
    }

    /**
     * Metodo que como o cabeçalho deve se formatar para ser escrito 
     * no arquivo CSV
     * @return Dados, String 
     */
    public String toFileTitulo() {
        String dados = "";
        dados += "CODIGO,LOGRADOURO,NÚMERO,BAIRRO,CIDADE,DESCRIÇÂO,AREA TOTAL,VALOR,";

        return dados;

    }

    /**
     * Metodo que como o Objeto deve se formatar para ser escrito 
     * no arquivo CSV
     * @return Dados, String 
     */ 
    public String toFile() {
        String dados = "";
        dados += codigo + "," + logradouro + "," + numero + "," + bairro + "," + cidade + "," + descricao + "," + areaTotal + "," + valor + ",";
        return dados;
    }
    
    public static void setCodigoStat(int i){
        codigoGeral = i;
    }
    
    public static int getCodigoStat(){
        return codigoGeral;
    }
    

    
    
    
}
   
