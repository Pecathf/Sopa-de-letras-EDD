/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Selectorarchivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel
 */
public class Prueba {
    public String abrirArchivo() {
    StringBuilder texto = new StringBuilder();
    String resultado = "";
    
    try {
        // Llamamos el método que permite cargar la ventana
        JFileChooser file = new JFileChooser();
        int seleccion = file.showOpenDialog(null);
        
        // Verificamos si el usuario seleccionó un archivo
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            // Abrimos el archivo seleccionado
            File abre = file.getSelectedFile();
            
            // Usamos try-with-resources para asegurar que los recursos se cierren correctamente
            try (FileReader archivos = new FileReader(abre);
                 BufferedReader lee = new BufferedReader(archivos)) {
                
                String aux;
                // Recorremos el archivo, lo leemos para plasmarlo en el área de texto
                while ((aux = lee.readLine()) != null) {
                    texto.append(aux).append("\n");
                }
                
                resultado = texto.toString();
            }
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, 
                "Error: " + ex.getMessage() + "\nNo se ha encontrado el archivo",
                "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
    }
    
    return resultado; // El texto se almacena en el JTextArea
}
    
}
