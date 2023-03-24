/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package examen2p1_byronlemuz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author lesly
 */
public class Menu extends JFrame implements ActionListener {

    private JButton ejercicio1;
    private JButton ejercicio2;
    
    public Menu() {
        // Configurar la ventana
        setTitle("Menú de Ejercicios");
        setSize(300, 150);
        setLocationRelativpeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear los componentes
        ejercicio1 = new JButton("Ejercicio 1");
        ejercicio2 = new JButton("Ejercicio 2");
        
        // Agregar los componentes al panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(ejercicio1);
        panel.add(ejercicio2);
        
        // Agregar el panel a la ventana
        add(panel);
        
        // Agregar los listeners a los botones
        ejercicio1.addActionListener(this);
        ejercicio2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        // Determinar qué botón se presionó
        if (e.getSource() == ejercicio1) {
            JOptionPane.showMessageDialog(this, "Bienvenido al Ejercicio 1");
            Libreria libreria = new Libreria();
            libreria.mostrarMenu();
        } else if (e.getSource() == ejercicio2) {
            JOptionPane.showMessageDialog(this, "Bienvenido al Ejercicio 2");
            // Aquí va el código para el Ejercicio 2
            Gusanito gusanito = new Gusanito();
            gusanito.ejecutarinstruccion();
        }
    }
    
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setVisible(true);
    }

    private void setLocationRelativpeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}







