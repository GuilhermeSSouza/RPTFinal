/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaImoveis;
import java.io.Serializable;
/**
 *
 * @author Amanda Gobus
 */
public class No<T> implements Serializable{
    private No proximo;
    private No anterior;
    private T info;
    //private Imovel imovel;
    private int indice;

    /**
     * Construtor do No
     * @param indice
     * @param im
     * @param inicio
     * @param ultimo 
     */
   public No(int indice, T im, No inicio, No ultimo) {
       this.indice=indice;
       this.info=im;
       this.anterior=anterior;
       this.proximo=proximo;
    }

   public No(T info) {
        this.proximo = null;
        this.anterior = null;
        this.info = info;
    }

    

/**
 * Método set do Imóvel
 * @param imovel 
 */
    public void setInfo(T imovel) {
        this.info = imovel;
    }
/**
 * Método get do Imóvel
 * @return 
 */
    public T getInfo() {
        return info;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    
    
    
/**
 * 
 * @return 
 */
    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
    public void decrementarIndice(){
        this.indice--;
    }
    public void IncrementarIndice(){
        this.indice++;
    }

    
}
