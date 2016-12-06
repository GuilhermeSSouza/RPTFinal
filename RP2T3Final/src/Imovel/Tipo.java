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
public enum Tipo implements Serializable {

    RESIDENCIAL(1), COMERCIAL(2);

    int valor;

    private Tipo(int valor) {
        this.valor = valor;
    }
    
    
   public int getValor(){
   return valor;
   } 

   public static Tipo CasaTipo(int valor){
         for (Tipo tipo : Tipo.values()) {
            if (tipo.getValor() == valor) {
                return tipo;
            }

        }
        return null;
   
   
   }
   
   
}
