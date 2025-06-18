/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * Implementación propia de una Cola (Queue) usando lista enlazada.
 * 
 * @author luis
 * @param <T>
 */
public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> ultimo;
    private int size;
    
    /**
     * Clase interna para representar un nodo de la cola.
     */
    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;
        
        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    
    /**
     * Constructor de la cola.
     */
    public Cola() {
        this.frente = null;
        this.ultimo = null;
        this.size = 0;
    }
    
    /**
     * Agrega un elemento al final de la cola.
     * 
     * @param elemento Elemento a agregar
     */
    public void encolar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        
        if (ultimo == null) {
            frente = ultimo = nuevoNodo;
        } else {
            ultimo.siguiente = nuevoNodo;
            ultimo = nuevoNodo;
        }
        size++;
    }
    
    /**
     * Remueve y retorna el elemento del frente de la cola.
     * 
     * @return Elemento del frente de la cola
     * @throws RuntimeException si la cola está vacía
     */
    public T desencolar() {
        if (frente == null) {
            throw new RuntimeException("La cola está vacía");
        }
        
        T dato = frente.dato;
        frente = frente.siguiente;
        
        if (frente == null) {
            ultimo = null;
        }
        
        size--;
        return dato;
    }
    
    /**
     * Retorna el elemento del frente sin removerlo.
     * 
     * @return Elemento del frente de la cola
     * @throws RuntimeException si la cola está vacía
     */
    public T frente() {
        if (frente == null) {
            throw new RuntimeException("La cola está vacía");
        }
        return frente.dato;
    }
    
    /**
     * Verifica si la cola está vacía.
     * 
     * @return true si la cola está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return frente == null;
    }
    
    /**
     * Obtiene el size de la cola.
     * 
     * @return Número de elementos en la cola
     */
    public int size() {
        return size;
    }
    
    /**
     * Limpia todos los elementos de la cola.
     */
    public void limpiar() {
        frente = null;
        ultimo = null;
        size = 0;
    }
    
    @Override
    public String toString() {
        if (frente == null) {
            return "Cola[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Cola[");
        Nodo<T> actual = frente;
        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) {
                sb.append(", ");
            }
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}
