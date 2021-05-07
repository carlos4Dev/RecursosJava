package modelo;

import java.sql.*;

public class CargaMenus {

    public Conexion miConexion;
    
    public ResultSet rs; // Lo cambiamos a public para poder acceder desde otro paquete
    
    public ResultSet rs2;
    
    public Productos miProducto;
    
    
    public CargaMenus() {
        
        miConexion = new Conexion();
        
    }
    
    /* Esta es la solución propuesta en el video 212
     
    public String ejecutaConsulta() {
        
        Productos miProducto = null;
        
        Connection accesoBBDD = miConexion.dameConexion();
        
        try {
            
            Statement secciones = accesoBBDD.createStatement();
            
            rs = secciones.executeQuery("SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS");
            
            // Se instancia la clase Productos como ejemplo de Modelo Vista Controlador 
            // donde se recomienda la encapsulación (no era necesario para este ejemplo)
            miProducto = new Productos();
            
            miProducto.setSeccion(rs.getString(1));
            
            rs.close();
            
        } catch (Exception e) {
            
        }
        
        return miProducto.getSeccion();
        
    }

*/
    
    // Solución propuesta en el video 213 (parace que mejor)
    
    public ResultSet ejecutaConsultas() {
        
        Connection accesoBBDD = miConexion.dameConexion();
        
        try {
            
            Statement secciones = accesoBBDD.createStatement();
            Statement paises = accesoBBDD.createStatement();
            
            rs = secciones.executeQuery("SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS");
            
            rs2 = paises.executeQuery("SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS");
            
            miProducto = new Productos(); // No es necesario, pero se sigue el principio de encapsulación
            
            miProducto.setSeccion(rs.getString(1));
            
            miProducto.setpOrigen(rs2.getString(1));
            
            rs.close();
            
            rs2.close();
            
            accesoBBDD.close();
            
        } catch (Exception e) {
            
        }
        
        return null;
    }
    
}

    
    
