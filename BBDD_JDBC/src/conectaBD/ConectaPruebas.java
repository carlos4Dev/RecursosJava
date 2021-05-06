package conectaBD;

import java.sql.*;

public class ConectaPruebas {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        try {
            // 1. Crear conexion
            // getConnection recibe tres par�metros: nombre del driver://direcci�n (mysql usa por defecto el puerto 3306)
            // usuario (por defecto es root, si no se ha cambiado) y contrase�a ( por defecto " ")
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas_jdbc", "root","");
            
            // 2. Crear objeto statement
            Statement miStatement = miConexion.createStatement();
             
            // 3. Ejecutar SQL
            // ResultSet es c�mo una tabla virtual en memoria de la cual podemos obtener datos
            ResultSet miResultSet = miStatement.executeQuery("SELECT  * FROM PRODUCTOS");
            
            // 4. Recorrer el ResultSet
            while(miResultSet.next()) {
                // Se puede poner el �ndice, pero es m�s significativo poner el nombre (C�DIGOART�CULO)
                System.out.println(miResultSet.getString("C�DIGOART�CULO") + " " 
                        + miResultSet.getString("NOMBREART�CULO") + " " 
                        + miResultSet.getString("PRECIO") );
                
            }
            
        } catch (Exception e) {
            
            System.out.println("No se puede conectar");
            e.printStackTrace();
            
        }

    }

}
