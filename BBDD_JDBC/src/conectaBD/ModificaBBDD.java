package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModificaBBDD {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            // 1. Crear conexion
            // getConnection recibe tres parámetros: nombre del driver://dirección (mysql usa por defecto el puerto 3306)
            // usuario (por defecto es root, si no se ha cambiado) y contraseña ( por defecto " ")
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas_jdbc", "root","");
            
            // 2. Crear objeto statement
            Statement miStatement = miConexion.createStatement();
             
            /* Insertar registros
            String insertarSQL = "INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, NOMBREARTÍCULO, PRECIO)  VALUES ('AR77', 'PANTALÓN', 25.35)";
            
            miStatement.execute(insertarSQL);
            
            System.out.println("Datos insertados correctamente");
            */
            
             /* Modificar registro
            
            String instruccionSQL = "UPDATE  PRODUCTOS SET PRECIO = PRECIO * 2  WHERE CÓDIGOARTÍCULO = 'AR77' ";
            
            miStatement.execute(instruccionSQL);
            
            System.out.println("Datos modificados correctamente");
            */
            // Eliminar registro
            String instruccionSQL = "DELETE FROM PRODUCTOS  WHERE CÓDIGOARTÍCULO = 'AR77' ";
            
            miStatement.execute(instruccionSQL);
            
            System.out.println("Datos eliminados correctamente");
            
        } catch (Exception e) {
            
            System.out.println("No se puede conectar");
            e.printStackTrace();
            
        }

    }

}
