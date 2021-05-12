package swingAvanzado;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class UsoJTable2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        JFrame miMarco = new MarcoTablaPersonalizado();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
        
    }

}

class MarcoTablaPersonalizado extends JFrame {
    
    public MarcoTablaPersonalizado() {
        
        setTitle("Tabla Personalizada");
        setBounds(300,300,400,200);
        TableModel miModelo = new ModeloTablaPersonalizada();
        JTable miTabla = new JTable(miModelo);
        add(new JScrollPane(miTabla));
    }
    
}

class ModeloTablaPersonalizada extends AbstractTableModel {

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return 5;
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        
        
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        
        int z = rowIndex+1;
        int y = columnIndex+2;
        return " " + z +" " + y;
    }
    
    public String getColumnName(int c) {
        
        return "Columna " + c;
        
    }
    
    
    
}
