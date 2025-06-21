/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;


/**Grafo no dirigido implementado mediante una matriz adyacente
 *
 * @author Simon
 */
public class Grafo {
    private boolean matrizAdy[][];
   int maxNodos;
   int numVertices;

   //*Constructor del grafo*/
    public Grafo(int n, boolean[][] matrizAdy) {
        matrizAdy = new boolean[n][n];
        maxNodos = numVertices = 0;
        
    }
    
    //*Funcion para agregar una arista y conectar dos vertices del grafo*/
    public void agregarArista(int i, int j) {
        matrizAdy[i][j] = true;
        matrizAdy[j][i] = matrizAdy[i][j];
    }
    
    //*Funcion para eliminar una arista y desvincular dos vertices del grafo*/
    public void eliminarArista(int i, int j) {
        matrizAdy[i][j] = false;
        matrizAdy[j][i] = false;
    }
    
    //*Funcion para insertar un nuevo vertice y enlasarlo con otro vertice*/
    public void insertarVertice(int n) {
        if ( n > maxNodos - numVertices )
            System.out.println ("Error, se supera el número de nodos máximo");
        else
            for (int i=0; i < numVertices + n; i++)
                for (int j = numVertices; j < numVertices + n; j++)
                    matrizAdy[i][j] = matrizAdy[j][i] = false;
        
        numVertices = numVertices + n;
    }
    
    //Función para determinar el grado de entrada de un vertice
    public int gradoEnt(int j) {
        int gEnt = 0;
        for (int i = 0; i < numVertices; i++)
            if (matrizAdy[i][j])
                gEnt++;
        return gEnt;  
    }
    
    //Función para determinar el grado de salida de un vertice
    public int gradoSal(int i) {
        int gSal = 0;
        for (int j = 0; i < numVertices; j++)
            if (matrizAdy[j][i])
                gSal++;
        return gSal;  
    }
    
    //Función temporal para comprobar como se ve la matriz adyacente del grafo
    public void imprimirMatriz() {
        for (int i=0; i < 5; i++)
            for (int j=0; j < 5; j++)
                System.out.print(matrizAdy[i][j]);
    }
    
    
}
