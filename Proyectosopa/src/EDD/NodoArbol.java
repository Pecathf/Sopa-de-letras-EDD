/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Angel
 */
public class NodoArbol {
    public NodoArbol hder;
    public NodoArbol hizq;
    public NodoArbol padre;
    public String dato;

    public NodoArbol( String dato) {
        this.hder = null;
        this.hizq= null;
        this.dato = dato;
        this.padre= null;
    }
    
    
}
