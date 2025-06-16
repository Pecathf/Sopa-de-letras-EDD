/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * Implementación propia de un Mapa (Diccionario) usando Hash Table.No usa ninguna librería de Java Collections.
 * 
 * @author Equipo de Desarrollo
 * @version 1.0
 * @param <K>
 * @param <V>
 */
public class Mapa<K, V> {
    private static final int CAPACIDAD_INICIAL = 16;
    private static final double FACTOR_CARGA = 0.75;
    
    private Entrada<K, V>[] tabla;
    private int size;
    private int capacidad;
    
    /**
     * Clase interna para representar una entrada del mapa.
     */
    private static class Entrada<K, V> {
    /**
     * K viene siendo clave por su significado en ingles de key que es llave
     * asi que es la llave de acceso
     */
        K clave;
        V valor;
        Entrada<K, V> Pnext;
        
        Entrada(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
            this.Pnext = null;
        }
    }
    
    /**
     * Constructor del mapa.
     */
    @SuppressWarnings("unchecked")
    public Mapa() {
        this.capacidad = CAPACIDAD_INICIAL;
        this.tabla = new Entrada[capacidad];
        this.size = 0;
    }
    
    /**
     * Función hash para obtener el índice de una clave.
     * 
     * @param clave Clave a hashear
     * @return Índice en la tabla hash
     */
    private int hash(K clave) {
        if (clave == null) {
            return 0;
        }
        return Math.abs(clave.hashCode()) % capacidad;
    }
    
    /**
     * Inserta o actualiza un par clave-valor en el mapa.
     * 
     * @param clave Clave del elemento
     * @param valor Valor del elemento
     * @return Valor anterior si existía, null en caso contrario
     */
    public V poner(K clave, V valor) {
        if (size >= capacidad * FACTOR_CARGA) {
            redimensionar();
        }
        
        int indice = hash(clave);
        Entrada<K, V> entrada = tabla[indice];
        
        // Si no hay entrada en este índice
        if (entrada == null) {
            tabla[indice] = new Entrada<>(clave, valor);
            size++;
            return null;
        }
        
        // Buscar si la clave ya existe
        while (entrada != null) {
            if (entrada.clave != null && entrada.clave.equals(clave)) {
                V valorAnterior = entrada.valor;
                entrada.valor = valor;
                return valorAnterior;
            }
            if (entrada.Pnext == null) {
                break;
            }
            entrada = entrada.Pnext;
        }
        
        // Agregar nueva entrada al final de la cadena
        entrada.Pnext = new Entrada<>(clave, valor);
        size++;
        return null;
    }
    
    /**
     * Obtiene el valor asociado a una clave.
     * 
     * @param clave Clave a buscar
     * @return Valor asociado a la clave, null si no existe
     */
    public V obtener(K clave) {
        int indice = hash(clave);
        Entrada<K, V> entrada = tabla[indice];
        
        while (entrada != null) {
            if (entrada.clave != null && entrada.clave.equals(clave)) {
                return entrada.valor;
            }
            entrada = entrada.Pnext;
        }
        return null;
    }
    
    /**
     * Obtiene el valor asociado a una clave, o un valor por defecto si no existe.
     * 
     * @param clave Clave a buscar
     * @param valorPorDefecto Valor a retornar si la clave no existe
     * @return Valor asociado a la clave o valor por defecto
     */
    public V obtenerODefecto(K clave, V valorPorDefecto) {
        V valor = obtener(clave);
        return valor != null ? valor : valorPorDefecto;
    }
    
    /**
     * Verifica si el mapa contiene una clave específica.
     * 
     * @param clave Clave a buscar
     * @return true si la clave existe, false en caso contrario
     */
    public boolean contieneClave(K clave) {
        return obtener(clave) != null;
    }
    
    /**
     * Elimina una entrada del mapa.
     * 
     * @param clave Clave de la entrada a eliminar
     * @return Valor de la entrada eliminada, null si no existía
     */
    public V eliminar(K clave) {
        int indice = hash(clave);
        Entrada<K, V> entrada = tabla[indice];
        Entrada<K, V> anterior = null;
        
        while (entrada != null) {
            if (entrada.clave != null && entrada.clave.equals(clave)) {
                V valor = entrada.valor;
                
                if (anterior == null) {
                    tabla[indice] = entrada.Pnext;
                } else {
                    anterior.Pnext = entrada.Pnext;
                }
                
                size--;
                return valor;
            }
            anterior = entrada;
            entrada = entrada.Pnext;
        }
        return null;
    }
    
    /**
     * Obtiene todas las claves del mapa.
     * 
     * @return Lista con todas las claves
     */
    public Lista<K> claves() {
        Lista<K> claves = new Lista<>();
        for (int i = 0; i < capacidad; i++) {
            Entrada<K, V> entrada = tabla[i];
            while (entrada != null) {
                claves.agregar(entrada.clave);
                entrada = entrada.Pnext;
            }
        }
        return claves;
    }
    
    /**
     * Obtiene todos los valores del mapa.
     * 
     * @return Lista con todos los valores
     */
    public Lista<V> valores() {
        Lista<V> valores = new Lista<>();
        for (int i = 0; i < capacidad; i++) {
            Entrada<K, V> entrada = tabla[i];
            while (entrada != null) {
                valores.agregar(entrada.valor);
                entrada = entrada.Pnext;
            }
        }
        return valores;
    }
    
    /**
     * Redimensiona la tabla hash cuando se alcanza el factor de carga.
     */
    @SuppressWarnings("unchecked")
    private void redimensionar() {
        Entrada<K, V>[] tablaAnterior = tabla;
        int capacidadAnterior = capacidad;
        
        capacidad *= 2;
        tabla = new Entrada[capacidad];
        size = 0;
        
        // Reinsertar todas las entradas
        for (int i = 0; i < capacidadAnterior; i++) {
            Entrada<K, V> entrada = tablaAnterior[i];
            while (entrada != null) {
                poner(entrada.clave, entrada.valor);
                entrada = entrada.Pnext;
            }
        }
    }
    
    /**
     * Obtiene el size del mapa.
     * 
     * @return Número de entradas en el mapa
     */
    public int size() {
        return size;
    }
    
    /**
     * Verifica si el mapa está vacío.
     * 
     * @return true si el mapa está vacío, false en caso contrario
     */
    public boolean estaVacio() {
        return size == 0;
    }
    
    /**
     * Limpia todas las entradas del mapa.
     */
    @SuppressWarnings("unchecked")
    public void limpiar() {
        tabla = new Entrada[CAPACIDAD_INICIAL];
        capacidad = CAPACIDAD_INICIAL;
        size = 0;
    }
}

