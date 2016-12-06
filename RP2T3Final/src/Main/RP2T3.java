
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import static Imovel.EntradasTeclado.div;
import static Imovel.EntradasTeclado.inInt;
import Menu.MenuApartamento;
import Menu.MenuCasa;
import Menu.MenuChacara;
import Menu.MenuSalaComercial;
import Menu.MenuTerreno;
import java.util.Scanner;

/**
 *
 * @author Arcano
 */
public class RP2T3 {
    
       public static void main(String[] args) {

        MenuSalaComercial salaC = new MenuSalaComercial();
        MenuApartamento Ap = new MenuApartamento();
        MenuCasa casa = new MenuCasa();
        MenuTerreno terreno = new MenuTerreno();
        MenuChacara chacara = new MenuChacara();
        int op = 1;
        Scanner entrada = new Scanner(System.in);
        //Ap.carregarArquivos();
       // casa.carregarArquivos();
        //chacara.carregarArquivos();
        //salaC.carregarArquivos();
        //terreno.carregarArquivos();
        while (op != 0) {
            System.out.println(" ");
            System.out.println("******** BEM VINDO AO MENU ********");
            System.out.println("1) APARTAMENTO \n2) CASA \n3) CHACARA\n"
                    + "4) SALA COMERCIAL \n5) TERRENO \n0) SAIR");
            System.out.println(" ");
            div();
            op =inInt("Opção: ");
          

            switch (op) {
                case (1):
                    System.out.println(" ");
                    Ap.menuInicial();

                    break;

                case (2):
                    System.out.println(" ");
                    casa.menuInicial();
                    break;
                    
                case (3):
                    System.out.println(" ");
                    chacara.menuInicial(); 
                    break;
                    
                case (4):
                    System.out.println(" ");
                    salaC.menuInicial();
                    break;
                    
                case (5):
                    System.out.println(" ");
                    terreno.menuInicial();
                    break;
                    
            }
        }
    }
}
