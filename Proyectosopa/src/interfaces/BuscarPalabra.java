/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;
import javax.swing.JOptionPane;
import EDD.Arbol;
/**
 ** La clase {@code BuscarPalabra} representa la ventana de búsqueda de palabras
 * en la sopa de letras utilizando el algoritmo de profundidad o amplitud.
 * @author Jabrieliz
 */
public class BuscarPalabra extends javax.swing.JFrame {
    /**
     * La instancia de la ventana de carga de archivos.
     */
    public static Cargar v1;


   /**
     * Crea una nueva instancia de la clase {@code BuscarPalabra}. Inicializa
     * los componentes y configura la ventana.
     *
     * @param v1 la instancia de la ventana de carga
     */
    public BuscarPalabra(Cargar v1) {
        initComponents();
        this.v1 = v1;
        v1.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        mostrarDiccionario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        palabras = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        palabras.setBackground(new java.awt.Color(51, 51, 51));
        palabras.setColumns(20);
        palabras.setForeground(new java.awt.Color(255, 255, 255));
        palabras.setRows(5);
        jScrollPane1.setViewportView(palabras);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 240, 100));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("DFS");
        jButton1.setActionCommand("Buscar1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("BFS");
        jButton2.setActionCommand("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, 30));

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("ATRAS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar Palabras por DFS y BFS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Palabras encontradas");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Gri.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     /**
     * Acción realizada al presionar el botón "Atras". Oculta la ventana actual
     * y muestra la ventana principal del menú.
     *
     * @param evt el evento de acción
     */
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);

        Menu menu = new Menu(v1);

        menu.setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Acción realizada al presionar el botón "Buscar utilizando el algoritmo de
     * profundidad". Realiza la búsqueda de palabras en la sopa de letras
     * utilizando el algoritmo de profundidad y muestra los resultados en el
     * área de texto.
     *
     * @param evt el evento de acción
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         long startTime = System.currentTimeMillis();

// Código a medir
        this.palabras.setText("");
        for (String word : v1.diccionario) {
            System.out.println(word);
            if (v1.arbol.profundo(word)) {
                System.out.println("igual");
                this.palabras.setText(palabras.getText() + "," + word);
            }
        }

        long endTime = System.currentTimeMillis();
        long tiempoDeEjecucion = endTime - startTime;

        JOptionPane.showMessageDialog(null, "Tiempo de ejecución: " + tiempoDeEjecucion + " milisegundos");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Acción realizada al presionar el botón "Buscar utilizando el algoritmo de
     * amplitud". Realiza la búsqueda de palabras en la sopa de letras
     * utilizando el algoritmo de amplitud y muestra los resultados en el área
     * de texto.
     *
     * @param evt el evento de acción
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        long startTime = System.currentTimeMillis();

        this.palabras.setText("");

        for (String word : v1.diccionario) {
            if (v1.arbol.ancho(word)) {
                this.palabras.setText(palabras.getText() + "," + word);
            }
        }
        long endTime = System.currentTimeMillis();
        long tiempoDeEjecucion = endTime - startTime;

        JOptionPane.showMessageDialog(null, "Tiempo de ejecución: " + tiempoDeEjecucion + " milisegundos");

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
 * Método para mostrar todas las palabras del diccionario
 */
private void mostrarDiccionario() {
    if (v1.diccionario != null ) {
        StringBuilder sb = new StringBuilder();
        sb.append("DICCIONARIO CARGADO:\n");
        sb.append("Total de palabras: ").append("\n\n");
        
        for (String palabra : v1.diccionario) {
            sb.append(palabra).append("\n");
        }
        
        this.palabras.setText(sb.toString());
    } else {
        this.palabras.setText("No hay diccionario cargado");
    }
}
    
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscarPalabra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarPalabra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarPalabra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarPalabra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarPalabra(v1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea palabras;
    // End of variables declaration//GEN-END:variables
}
