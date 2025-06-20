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
 * @author Luis
 */
public class FC {
    public String abrirArchivo() {
  String aux="";   
  String texto="";
  try
  {
   /**llamamos el metodo que permite cargar la ventana*/
   JFileChooser file=new JFileChooser();
   file.showOpenDialog(null);
   /**abrimos el archivo seleccionado*/
   File abre=file.getSelectedFile();

   /**recorremos el archivo, lo leemos para plasmarlo
   *en el area de texto*/
   if(abre!=null)
   {     
      FileReader archivos=new FileReader(abre);
      BufferedReader lee=new BufferedReader(archivos);
      while((aux=lee.readLine())!=null)
      {
         texto+= aux+ "\n";
      }
         lee.close();
    }    
   }
   catch(IOException ex)
   {
     JOptionPane.showMessageDialog(null,ex+"" +
           "\nNo se ha encontrado el archivo",
                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
    }
  return texto;//El texto se almacena en el JTextArea
}
    
}
