package conectaBD;

import java.sql.*;

public class ConsultaPreparada {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        try {
            
            // 1. CREAR CONEXI�N
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas_jdbc", "root","");
            
            // 2. PREPARA CONSULTA
            PreparedStatement miSentencia = miConexion.prepareStatement("SELECT NOMBREART�CULO, SECCI�N, PA�SDEORIGEN FROM PRODUCTOS" 
                    +" WHERE SECCI�N = ? AND PA�SDEORIGEN = ? ");
            
            // 3. ESTABLECER PAR�METROS DE CONSULTA
            miSentencia.setString(1, "deportes");
            miSentencia.setString(2, "USA");
            
            // 4. EJECUTAR Y RECORRER LA CONSULTA
            ResultSet rs = miSentencia.executeQuery();
            
            while (rs.next()) {
                
                System.out.println(rs.getString(1) + " " + rs.getString (2) + " " + rs.getString(3));
                
            }
            
            rs.close();
            
            System.out.println("\nEJECUCI�N SEGUNDA CONSULTA \n");
            
            // REUTILIZACI�N DE CONSULTA SQL PREPARADA
            
            // 3. ESTABLECER PAR�METROS DE CONSULTA
            miSentencia.setString(1, "cer�mica");
            miSentencia.setString(2, "China");
            
            // 4. EJECUTAR Y RECORRER LA CONSULTA
            rs = miSentencia.executeQuery();
            
            while (rs.next()) {
                
                System.out.println(rs.getString(1) + " " + rs.getString (2) + " " + rs.getString(3));
                
            }
            
            rs.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("No se puede realizar la conexi�n");
            e.printStackTrace();
        }

    }

}
