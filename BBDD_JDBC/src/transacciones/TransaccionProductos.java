package transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class TransaccionProductos {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Connection miConexion = null;
        
        try{                    
                
            miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas_jdbc", "root", "");               
            
            miConexion.setAutoCommit(false);
            
            Statement miStatement =miConexion.createStatement();
            
            String instruccionSql_1="DELETE FROM PRODUCTOS WHERE PAÍSDEORIGEN = 'ITALIA'";
                
            String instruccionSql_2="DELETE FROM PRODUCTOS WHERE PRECIO > 300";
            
            String instruccionSql_3="UPDATE PRODUCTOS SET PRECIO = PRECIO * 1.15";
            
            boolean ejecutar = ejecutarTransaccion();
            
            if (ejecutar) {
            
                miStatement.executeUpdate(instruccionSql_1);
                miStatement.executeUpdate(instruccionSql_2);
                miStatement.executeUpdate(instruccionSql_3);
                
                miConexion.commit();
                System.out.println("Se ejecutó la transacción correctamente");
                
            } else {
                
                System.out.println("No se realizó ningún cambio en BBDD");
                
            }
            
        } catch (Exception e) {
            
            try {
            
                miConexion.rollback();
                
            } catch (SQLException e1) {
                
                e1.printStackTrace();
                
            }
            
            
            System.out.println("Error. No se realizó ningún cambio en BBDD");
            
        }

    }
    
    static boolean ejecutarTransaccion() { // Tiene que ser static porque esta dentro del main que es static
        
        String ejecucion = JOptionPane.showInputDialog("¿Desea ejecutar la transacción?");
        
        if (ejecucion.equals("Si")) return true;
        
        else return false;
        
    }
    
}
