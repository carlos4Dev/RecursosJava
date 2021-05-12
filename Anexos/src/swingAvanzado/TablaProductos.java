package swingAvanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class TablaProductos {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        JFrame miMarco = new MarcoProductos();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
        
        
    }

}

class MarcoProductos extends JFrame {
    
    private JComboBox nombresDeTablas;
    private DatabaseMetaData datosBBDD;
    private ResultSet rs;
    private Connection miConexion;
    
    private Statement sentencia;
    
    private ResultSetModeloTabla modelo;
    
    
    public MarcoProductos() {
        
        setTitle("Productos");
        setBounds(500,300,600,400);
        JPanel superior = new JPanel();
        nombresDeTablas = new JComboBox();
        
        try {
            
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas_jdbc","root","");
            
            datosBBDD = miConexion.getMetaData();
            
            rs = datosBBDD.getTables(null, null, null, null);
            
            while (rs.next()) {
                
                nombresDeTablas.addItem(rs.getString("TABLE_NAME"));
                
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        nombresDeTablas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
                String tablaSeleccionada = (String) nombresDeTablas.getSelectedItem();
                
                String consulta = "SELECT * FROM " + tablaSeleccionada;
                
                try {
                    sentencia = miConexion.createStatement();
                               
                    rs = sentencia.executeQuery(consulta);
                    
                    /* while(rs.next()) {
                        
                        System.out.println(rs.getString("NOMBREARTÍCULO") + " "+ rs.getString("CÓDIGOARTÍCULO"));
                        
                    } */
                    
                    modelo = new ResultSetModeloTabla(rs);
                    
                    JTable tabla = new JTable(modelo);
                    
                    add(new JScrollPane(tabla), BorderLayout.CENTER);
                    
                    validate();
                
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
            }
            
            
            
        });
        
        superior.add(nombresDeTablas);
        add(superior, BorderLayout.NORTH);
        
    }
    
}

class ResultSetModeloTabla extends AbstractTableModel {

    private ResultSet rsRegistros;
    private ResultSetMetaData resMetaData;
    
    public ResultSetModeloTabla(ResultSet unResultSet) {
        
        rsRegistros = unResultSet;
        
        try {
            resMetaData = rsRegistros.getMetaData();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    public String getColumnName(int c) {
        
        try {
            
            return resMetaData.getColumnName(c + 1);
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return null;
        }
        
    }
    
    
    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        
        try {
        
            rsRegistros.last();
              
            return rsRegistros.getRow();
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        
        try {
            return resMetaData.getColumnCount();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
            return 0;
        }
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        
        try {
            
            
            // java.sql.SQLException: Operation not allowed for a result set of type ResultSet.TYPE_FORWARD_ONLY.
            // No he podido solucionarlo, también me dió error en los ejercicios de ResultSet, pero allí si lo solucioné
            rsRegistros.absolute(rowIndex + 1);
                
            return rsRegistros.getObject(columnIndex + 1);
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
            return null;
        }
        
    }
    
    
    
    
}