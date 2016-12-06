/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imovel;

import java.util.List;

/**
 * Interace que especifica a assinatura dos mÃ©todos que devem ser implementados
 * pela lista de imÃ³veis.
 */
public abstract interface ListaImoveis {

    /**
     * Inclui um imÃ³vel na lista de imÃ³veis.
     *
     * @param im ImÃ³vel a ser incluÃ­do.
     * @return True se a inclusÃ£o foi bem sucedida ou False em caso contrÃ¡rio.
     */
    public boolean incluir(Imovel im);

    /**
     * Consulta o imÃ³vel com o cÃ³digo informado.
     *
     * @param codigo CÃ³digo a ser consultado.
     * @return Imovel com o cÃ³digo informado ou null em caso de nÃ£o existir
     * imÃ³vel com o cÃ³digo informado.
     */
    public Imovel consultar(int codigo);

    /**
     * Edita o imÃ³vel com o cÃ³digo informado.
     *
     * @param cÃ³digo CÃ³digo do imÃ³vel a ser editado.
     * @param im ImÃ³vel com as novas informaÃ§Ãµes.
     * @return True se o imÃ³vel com o cÃ³digo informado for editado e False
     * caso nenhum imÃ³vel com o cÃ³digo infornado for encontrado.
     */
    public boolean editar(int codigo, Imovel im);

    /**
     * Exclui o imÃ³vel com o cÃ³digo informado.
     *
     * @param codigo CÃ³digo do imÃ³vel a ser excluÃ­do.
     * @return True se o imÃ³vel com o cÃ³digo informado for excluÃ­do e False
     * caso nenhum imÃ³vel com o cÃ³digo infornado for encontrado.
     */
    public boolean excluir(int codigo);

    /**
     * Ordena os imÃ³veis em ordem crescente de cÃ³digo.
     *
     * @return Uma lista com os imÃ³veis ordenados em ordem crescente de
     * cÃ³digo.
     */
    public List<Imovel> ordenarCodigo();

    /**
     * Ordena os imÃ³veis em ordem crescente de valor.
     *
     * @return Uma lista com os imÃ³veis ordenados em ordem crescente de valor.
     */
    public List<Imovel> ordenarValor();

    /**
     * Ordena os imÃ³veis em ordem decrescente de Ã¡rea total.
     *
     * @return Uma lista com os imÃ³veis ordenados em ordem decrescente de Ã¡rea
     * total.
     */
    public List<Imovel> ordenarArea();

    /**
     * Pesquisa os imÃ³veis que possuem valor menor ou igual ao informado.
     *
     * @param valor Valor mÃ¡ximo do imÃ³vel a ser pesquisado.
     * @return Uma lista contendo os imÃ³veis com valor menor ou igual ao
     * informado.
     */
    public List<Imovel> pesquisaValor(double valor);

    /**
     * Pesquisa os imÃ³veis que estÃ£o localizados no bairro informado.
     *
     * @param bairro Bairro a ser pesquisado.
     * @return Uma lista contendo os imÃ³veis localizados no bairro informado.
     */
    public List<Imovel> pesquisaBairro(String bairro);

    /**
     * Escreve a lista de imÃ³veis em um arquivo CSV.
     *
     * @return True se a lista for escrita corretamente no arquivo e False em
     * caso contrÃ¡rio.
     */
    public boolean escreverArquivo();

    /**
     * Le a lista de imÃ³veis de um arquivo CSV.
     *
     * @return True se a lista for lida corretamente do arquivo e False em caso
     * contrÃ¡rio.
     */
    public boolean lerArquivo();

}

