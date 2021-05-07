package procedimientoAlmacenado;

import java.sql.*;

import javax.swing.JOptionPane;

public class ActualizaProductos {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int nPrecio = Integer.parseInt(JOptionPane.showInputDialog("Introduce precio"));
        
        String nArticulo = JOptionPane.showInputDialog("Introduce nombre articulo");
        
        try {
            
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas_jdbc", "root","");
            
            CallableStatement miSentencia = miConexion.prepareCall("{call ACTUALIZA_PROD(?, ?)}");  
            
            miSentencia.setInt(1, nPrecio);
            
            miSentencia.setString(2, nArticulo);
            
            miSentencia.execute();
            
            System.out.println("Precio actualizado correctamente");
            
        } catch (Exception e){
            
            System.out.println("Error al actualizar el precio");
            e.printStackTrace();
          
            
        }
        
    }

}
