/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * Implementación propia de un Conjunto (Set) usando Hash Table.No usa ninguna librería de Java Collections.
 * 
 * @author Luis
 * @param <T>
 */
public class Conjunto<T> {
    private Mapa<T, Boolean> mapa;
    
    /**
     * Constructor del conjunto.
     */
    public Conjunto() {
        this.mapa = new Mapa<>();
    }
    
    /**
     * Agrega un elemento al conjunto.
     * 
     * @param elemento Elemento a agregar
     * @return true si el elemento se agregó (no existía), false si ya existía
     */
    public boolean agregar(T elemento) {
        if (mapa.contieneClave(elemento)) {
            return false;
        }
        mapa.poner(elemento, true);
        return true;
    }
    
    /**
     * Verifica si el conjunto contiene un elemento específico.
     * 
     * @param elemento Elemento a buscar
     * @return true si el elemento está en el conjunto, false en caso contrario
     */
    public boolean contiene(T elemento) {
        return mapa.contieneClave(elemento);
    }
    
    /**
     * Elimina un elemento del conjunto.
     * 
     * @param elemento Elemento a eliminar
     * @return true si el elemento se eliminó, false si no existía
     */
    public boolean eliminar(T elemento) {
        return mapa.eliminar(elemento) != null;
    }
    
    /**
     * Obtiene el size del conjunto.
     * 
     * @return Número de elementos en el conjunto
     */
    public int size() {
        return mapa.size();
    }
    
    /**
     * Verifica si el conjunto está vacío.
     * 
     * @return true si el conjunto está vacío, false en caso contrario
     */
    public boolean estaVacio() {
        return mapa.estaVacio();
    }
    
    /**
     * Limpia todos los elementos del conjunto.
     */
    public void limpiar() {
        mapa.limpiar();
    }
    
    /**
     * Obtiene todos los elementos del conjunto.
     * 
     * @return Lista con todos los elementos
     */
    public Lista<T> elementos() {
        return mapa.claves();
    }
    
    /**
     * Agrega todos los elementos de otro conjunto a este conjunto.
     * 
     * @param otroConjunto Conjunto cuyos elementos se van a agregar
     */
    public void agregarTodos(Conjunto<T> otroConjunto) {
        Lista<T> elementos = otroConjunto.elementos();
        for (int i = 0; i < elementos.size (); i++) {
            agregar(elementos.obtener(i));
        }
    }
    
    /**
     * Crea la unión de este conjunto con otro conjunto.
     * 
     * @param otroConjunto Conjunto para hacer la unión
     * @return Nuevo conjunto con la unión
     */
    public Conjunto<T> union(Conjunto<T> otroConjunto) {
        Conjunto<T> resultado = new Conjunto<>();
        resultado.agregarTodos(this);
        resultado.agregarTodos(otroConjunto);
        return resultado;
    }
    
    /**
     * Crea la intersección de este conjunto con otro conjunto.
     * 
     * @param otroConjunto Conjunto para hacer la intersección
     * @return Nuevo conjunto con la intersección
     */
    public Conjunto<T> interseccion(Conjunto<T> otroConjunto) {
        Conjunto<T> resultado = new Conjunto<>();
        Lista<T> elementos = this.elementos();
        
        for (int i = 0; i < elementos.size(); i++) {
            T elemento = elementos.obtener(i);
            if (otroConjunto.contiene(elemento)) {
                resultado.agregar(elemento);
            }
        }
        return resultado;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Lista<T> elementos = this.elementos();
        for (int i = 0; i < elementos.size(); i++) {
            sb.append(elementos.obtener(i));
            if (i < elementos.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}

