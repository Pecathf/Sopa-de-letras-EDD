/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Angel
 */
public class listaenlazada {
    private Nodo pFirst;
    private Nodo pLast;
    private int size;

    public listaenlazada() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    } 
  
    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public Nodo getpLast() {
        return pLast;
    }

    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpyt(){
        return pFirst == null;
    }
    
    public void AgregarNodo(String valor){
        Nodo NuevoNodo = new Nodo(valor);
        if (pFirst != null){
            pLast.setpNext(NuevoNodo);
            pLast = pLast.getpNext();
        } else {
            pFirst = NuevoNodo;
            pLast = NuevoNodo;
        }
        size += 1;
    }
    //Metodo mostrar valores bases de la lista
    public void Mostrar(){
        System.out.println("pFirst: " + pFirst);
        System.out.println("pLast: " + pLast);
        System.out.println("size: " + size);
    }
    
}
    



