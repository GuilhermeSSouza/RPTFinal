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
public enum TipoDeImovel implements Serializable {
    

    APARTAMENTO(1), CASA(2), CHACARA(3), SALACOMERCIAL(4),TERRENO(5);

    int valor;

    private TipoDeImovel(int valor) {
        this.valor = valor;
    }
    
    
   public int getValor(){
   return valor;
   } 

   public static Tipo ImovelTipo(int valor){
         for (Tipo tipo : Tipo.values()) {
            if (tipo.getValor() == valor) {
                return tipo;
            }

        }
        return null;
   
   
   }
    
}
