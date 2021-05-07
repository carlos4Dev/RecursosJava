package metadatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoMetadatos {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // mostrarInfoBBDD();  
        
        mostrarInfoTablas();
        
    }
    
    static void mostrarInfoBBDD() {
        
        Connection miConexion = null;
        
        try {
            
            miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas_jdbc", "root", "");
            
            // Obtención de metadatos
            
            DatabaseMetaData datosBBDD = miConexion.getMetaData();
            
            // Mostrar información de la BBDD
            
            System.out.println("Gestor de BBDD " + datosBBDD.getDatabaseProductName());
            System.out.println("Versión del Gestor " + datosBBDD.getDatabaseProductVersion());
            System.out.println("Nombre del driver " + datosBBDD.getDriverName());
            System.out.println("Versión del driver " + datosBBDD.getDriverVersion());
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        } finally {
            
            try {
                miConexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
    static void mostrarInfoTablas() {
        
        Connection miConexion = null;
        
        ResultSet miResultSet = null;
        
        try {
            
            miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas_jdbc", "root", "");
            
            // Obtención de metadatos
            
            DatabaseMetaData datosBBDD = miConexion.getMetaData();
            
            // Lista de tablas
            
            System.out.println("Lista de tablas");
            
            miResultSet = datosBBDD.getTables(null, null, null, null);
            
            while (miResultSet.next()) {
                
                System.out.println(miResultSet.getString("TABLE_NAME"));
                
            }
            
            // Lista de columnas de Productos
            
            System.out.println("");
            System.out.println("Campos de Productos");
            
            miResultSet = datosBBDD.getColumns(null, null, "productos", null);
            
            while (miResultSet.next()) {
                
                System.out.println(miResultSet.getString("COLUMN_NAME"));
                
            }
            
            
        
        } catch (Exception e) {
            
            e.printStackTrace();
            
        } finally {
            
            try {
                
                miConexion.close();
            
            } catch (SQLException e1) {
                
                e1.printStackTrace();
            }
            
        }
        
    }
    
}
