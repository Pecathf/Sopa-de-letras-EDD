/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;
//import interfaces.principal;
import Selectorarchivo.FC;
/**
 *
 * @author Luis
 */
public class Proyectosopa {

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //principal interfaz= new principal();
       //interfaz.setVisible (true);
       FC lector = new FC();
       String texto= lector.abrirArchivo();
        System.out.println(texto);
    }
    
}
