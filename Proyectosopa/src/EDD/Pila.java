/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * Implementación propia de una Pila (Stack) usando lista enlazada.No usa ninguna librería de Java Collections.
 * 
 * @author Luis
 * @param <T>
 */
public class Pila<T> {
    private Nodo<T> cima;
    private int size;
    
    /**
     * Clase interna para representar un nodo de la pila.
     */
    private static class Nodo<T> {
        T dato;
        Nodo<T> Pnext;
        
        Nodo(T dato) {
            this.dato = dato;
            this.Pnext = null;
        }
    }
    
    /**
     * Constructor de la pila.
     */
    public Pila() {
        this.cima = null;
        this.size = 0;
    }
    
    /**
     * Agrega un elemento al cima de la pila.
     * 
     * @param elemento Elemento a agregar
     */
    public void apilar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        nuevoNodo.Pnext = cima;
        cima = nuevoNodo;
        size++;
    }
    
    /**
     * Remueve y retorna el elemento del cima de la pila.
     * 
     * @return Elemento del cima de la pila
     * @throws RuntimeException si la pila está vacía
     */
    public T desapilar() {
        if (cima == null) {
            throw new RuntimeException("La pila está vacía");
        }
        
        T dato = cima.dato;
        cima = cima.Pnext;
        size--;
        return dato;
    }
    
    /**
     * Retorna el elemento del cima sin removerlo.
     * 
     * @return Elemento del cima de la pila
     * @throws RuntimeException si la pila está vacía
     */
    public T tope() {
        if (cima == null) {
            throw new RuntimeException("La pila está vacía");
        }
        return cima.dato;
    }
    
    /**
     * Verifica si la pila está vacía.
     * 
     * @return true si la pila está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return cima == null;
    }
    
    /**
     * Obtiene el size de la pila.
     * 
     * @return Número de elementos en la pila
     */
    public int tamaño() {
        return size;
    }
    
    /**
     * Limpia todos los elementos de la pila.
     */
    public void limpiar() {
        cima = null;
        size = 0;
    }
    
    @Override
    public String toString() {
        if (cima == null) {
            return "Pila[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Pila[");
        Nodo<T> actual = cima;
        while (actual != null) {
            sb.append(actual.dato);
            if (actual.Pnext != null) {
                sb.append(", ");
            }
            actual = actual.Pnext;
        }
        sb.append("]");
        return sb.toString();
    }
}


