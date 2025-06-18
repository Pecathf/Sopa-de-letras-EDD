/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * Implementación propia de una Lista Enlazada Simple.No usa ninguna librería de Java Collections.
 * 
 * @author Luis
 * @param <T>
 */
public class Lista<T> {
    private Nodo<T> Pfirst;
    private int size;
    
    /**
     * Clase interna para representar un nodo de la lista.
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
     * Constructor de la lista.
     */
    public Lista() {
        this.Pfirst = null;
        this.size = 0;
    }
    
    /**
     * Agrega un elemento al final de la lista.
     * 
     * @param elemento Elemento a agregar
     */
    public void agregar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        
        if (Pfirst == null) {
            Pfirst = nuevoNodo;
        } else {
            Nodo<T> actual = Pfirst;
            while (actual.Pnext != null) {
                actual = actual.Pnext;
            }
            actual.Pnext = nuevoNodo;
        }
        size++;
    }
    
    /**
     * Obtiene un elemento en la posición especificada.
     * 
     * @param indice Índice del elemento
     * @return Elemento en la posición especificada
     */
    public T obtener(int indice) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        
        Nodo<T> actual = Pfirst;
        for (int i = 0; i < indice; i++) {
            actual = actual.Pnext;
        }
        return actual.dato;
    }
    
    /**
     * Verifica si la lista contiene un elemento específico.
     * 
     * @param elemento Elemento a buscar
     * @return true si el elemento está en la lista, false en caso contrario
     */
    public boolean contiene(T elemento) {
        Nodo<T> actual = Pfirst;
        while (actual != null) {
            if (actual.dato != null && actual.dato.equals(elemento)) {
                return true;
            }
            actual = actual.Pnext;
        }
        return false;
    }
    
    /**
     * Elimina un elemento de la lista.
     * 
     * @param elemento Elemento a eliminar
     * @return true si se eliminó el elemento, false si no se encontró
     */
    public boolean eliminar(T elemento) {
        if (Pfirst == null) {
            return false;
        }
        
        if (Pfirst.dato != null && Pfirst.dato.equals(elemento)) {
            Pfirst = Pfirst.Pnext;
            size--;
            return true;
        }
        
        Nodo<T> actual = Pfirst;
        while (actual.Pnext != null) {
            if (actual.Pnext.dato != null && actual.Pnext.dato.equals(elemento)) {
                actual.Pnext = actual.Pnext.Pnext;
                size--;
                return true;
            }
            actual = actual.Pnext;
        }
        return false;
    }
    
    /**
     * Elimina el elemento en la posición especificada.
     * 
     * @param indice Índice del elemento a eliminar
     * @return Elemento eliminado
     */
    public T eliminarEn(int indice) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        
        if (indice == 0) {
            T dato = Pfirst.dato;
            Pfirst = Pfirst.Pnext;
            size--;
            return dato;
        }
        
        Nodo<T> actual = Pfirst;
        for (int i = 0; i < indice - 1; i++) {
            actual = actual.Pnext;
        }
        
        T dato = actual.Pnext.dato;
        actual.Pnext = actual.Pnext.Pnext;
        size--;
        return dato;
    }
    /**
     * Obtiene el tamaño de la lista.
     * 
     * @return Número de elementos en la lista
     */
    public int size() {
        return size;
    }
    /**
     * Verifica si la lista está vacía.
     * 
     * @return true si la lista está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return size == 0;
    }
    /**
     * Elimina el último elemento de la lista.
     * 
     * @return Elemento eliminado, null si la lista está vacía
     */
    public T eliminarUltimo() {
        if (size == 0) {
            return null;
        }
        return eliminarEn(size - 1);
    }
    
   
}

