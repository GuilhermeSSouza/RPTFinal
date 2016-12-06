package Apartamento;

import Imovel.Predio;

/**
 *
 * @author Amanda Gobus
 */
public class Apartamento extends Predio {

    private int numeroQuartos;
    private int numeroVagas;
    private int anoDeConstrucao;
    private int numeroDoApartamento;

    /**
     *
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
     * @param numeroDoApartamento
     * @param anoDeConstrucao
     * @param numeroVagas
     * @param numeroQuartos
     */
    public Apartamento(String logradouro, int numero, String bairro, String cidade, String descricao, double areaTotal, double valor, String nomeEdificio, int andar,
            double valorCondominio, int numeroDoApartamento, int anoDeConstrucao, int numeroVagas, int numeroQuartos) {
        super(logradouro, numero, bairro, cidade, descricao, areaTotal, valor, nomeEdificio, andar, valorCondominio);

        this.numeroDoApartamento = numeroDoApartamento;
        this.anoDeConstrucao = anoDeConstrucao;
        this.numeroQuartos = numeroQuartos;
        this.numeroVagas = numeroVagas;
    }
    
    
    
    public Apartamento(int codigo, String logradouro, int numero, String bairro, String cidade, String descricao, double areaTotal, double valor, String nomeEdificio, int andar,
            double valorCondominio, int numeroDoApartamento, int anoDeConstrucao, int numeroVagas, int numeroQuartos) {
        super(codigo, logradouro, numero, bairro, cidade, descricao, areaTotal, valor, nomeEdificio, andar, valorCondominio);

        this.numeroDoApartamento = numeroDoApartamento;
        this.anoDeConstrucao = anoDeConstrucao;
        this.numeroQuartos = numeroQuartos;
        this.numeroVagas = numeroVagas;
    }
  

    /**
     *
     * @return NumeroQuartos
     */
    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    /**
     *
     * @param numeroQuartos
     */
    public void setNumeroQuartos(int numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    /**
     *
     * @return Numero de Vagas
     */
    public int getNumeroVagas() {
        return numeroVagas;
    }

    /**
     *
     * @param numeroVagas
     */
    public void setNumeroVagas(int numeroVagas) {
        this.numeroVagas = numeroVagas;
    }

    /**
     *
     * @return Ano
     */
    public int getAnoDeConstrucao() {
        return anoDeConstrucao;
    }

    /**
     *
     * @param anoDeConstrucao
     */
    public void setAnoDeConstrucao(int anoDeConstrucao) {
        this.anoDeConstrucao = anoDeConstrucao;
    }

    /**
     *
     * @return Numero do Apartamento
     */
    public int getNumeroDoApartamento() {
        return numeroDoApartamento;
    }

    /**
     *
     * @param numeroDoApartamento
     */
    public void setNumeroDoApartamento(int numeroDoApartamento) {
        this.numeroDoApartamento = numeroDoApartamento;
    }

    /**
     *
     * @return dados
     */
    @Override
    public String toString() {
        String dados = super.toString();
        dados += "Número De Quartos: " + numeroQuartos + "\n";
        dados += "Número Do Apartamento: " + numeroDoApartamento + "\n";
        dados += "Ano Da Construção: " + anoDeConstrucao + "\n";
        dados += "Numero De Vagas: " + numeroVagas + "\n";

        return dados;
    }
    
    @Override
    public String toFile() {
        String dados = super.toFile();
        dados += numeroQuartos+ "," + numeroDoApartamento + "," + anoDeConstrucao + "," + numeroVagas;
        return dados;
    }

}
