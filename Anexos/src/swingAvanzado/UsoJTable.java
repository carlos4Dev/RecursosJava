package swingAvanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UsoJTable {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        JFrame miMarco = new MarcoTabla();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
        
    }

}

class MarcoTabla extends JFrame {
    
    private String [] nombresColumnas = {"Nombre", "Radio", "Lunas", "Gaseoso"};
    
    private Object [] [] datosFila = {
            {"Mercurio", 2440.0, 0, false},
            {"Venus", 6052.0, 0, false},
            {"Tierra", 6378.0, 1, false},
            {"Marte", 3397.0, 2, false},
            {"Jupiter", 71492.0, 16, true},
            {"Saturno", 60268.0, 18, true},
            {"Urano", 25559.0, 17, true},
            {"Neptuno", 34766.0, 8, true},
            {"Plutón", 1137.0, 1, false},
            
    };
    
    public MarcoTabla () {
        
        setTitle("Los planetas");
        setBounds(300,300,400,200);
        
        JTable tablaPlanetas = new JTable(datosFila, nombresColumnas);
        add(new JScrollPane(tablaPlanetas), BorderLayout.CENTER);
        
        JButton botonImprimir = new JButton("Imprimir tabla");
        botonImprimir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    
                    tablaPlanetas.print();
                     
                } catch(Exception e2) {
                    
                    e2.printStackTrace();
                    
                }
                
            }
            
        });
        
        JPanel laminaBoton = new JPanel();
        laminaBoton.add(botonImprimir);
        add(laminaBoton, BorderLayout.SOUTH);
        
    }
    
}
