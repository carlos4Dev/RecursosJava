package conectaBD;

import java.sql.*;

public class ConsultaPreparada {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        try {
            
            // 1. CREAR CONEXIÓN
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas_jdbc", "root","");
            
            // 2. PREPARA CONSULTA
            PreparedStatement miSentencia = miConexion.prepareStatement("SELECT NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN FROM PRODUCTOS" 
                    +" WHERE SECCIÓN = ? AND PAÍSDEORIGEN = ? ");
            
            // 3. ESTABLECER PARÁMETROS DE CONSULTA
            miSentencia.setString(1, "deportes");
            miSentencia.setString(2, "USA");
            
            // 4. EJECUTAR Y RECORRER LA CONSULTA
            ResultSet rs = miSentencia.executeQuery();
            
            while (rs.next()) {
                
                System.out.println(rs.getString(1) + " " + rs.getString (2) + " " + rs.getString(3));
                
            }
            
            rs.close();
            
            System.out.println("\nEJECUCIÓN SEGUNDA CONSULTA \n");
            
            // REUTILIZACIÓN DE CONSULTA SQL PREPARADA
            
            // 3. ESTABLECER PARÁMETROS DE CONSULTA
            miSentencia.setString(1, "cerámica");
            miSentencia.setString(2, "China");
            
            // 4. EJECUTAR Y RECORRER LA CONSULTA
            rs = miSentencia.executeQuery();
            
            while (rs.next()) {
                
                System.out.println(rs.getString(1) + " " + rs.getString (2) + " " + rs.getString(3));
                
            }
            
            rs.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("No se puede realizar la conexión");
            e.printStackTrace();
        }

    }

}
