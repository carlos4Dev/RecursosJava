package modelo;

import java.sql.*;

public class EjecutaConsultas {
    
   // private String pruebas;
    private Conexion miConexion;
    
    private ResultSet rs;
    
    private PreparedStatement enviaConsultaSeccion;
    
    private final String consultaSeccion = "SELECT NOMBREART�CULO, SECCI�N, PRECIO, PA�SDEORIGEN" 
            +" FROM PRODUCTOS WHERE SECCI�N = ?";
    
    // No es necesario crear 3 PreparedStatement
    private PreparedStatement enviaConsultaPais;
    
    private final String consultaPais = "SELECT NOBREART�CULO, SECCI�N, PRECIO, PA�SDEORIGEN" 
            +" FROM PRODUCTOS WHERE PA�SDEORIGEN = ?";
    
    private PreparedStatement enviaConsultaTodos;
    
    private final String consultaTodos = "SELECT NOBREART�CULO, SECCI�N, PRECIO, PA�SDEORIGEN" 
            +" FROM PRODUCTOS WHERE SECCI�N = ? AND PA�SDEORIGEN = ?";
    
    public EjecutaConsultas() {
        
        miConexion = new Conexion();
        
    }
  
    public ResultSet filtraBBDD(String seccion, String pais) {
        
        Connection conecta = miConexion.dameConexion();
        
        rs = null;
        
        try {
            
            if (!seccion.equals("Todos") && pais.equals("Todos")) {
                
                enviaConsultaSeccion = conecta.prepareStatement(consultaSeccion);
                
                enviaConsultaSeccion.setString(1, seccion);
                
                rs = enviaConsultaSeccion.executeQuery();
                
                // Me da error NullPointerException no me filta por pais
                
                } else if (seccion.equals("Todos") && !pais.equals("Todos")) {
                    
                    enviaConsultaPais = conecta.prepareStatement(consultaPais);
                    enviaConsultaPais.setString(1, pais);
                    rs = enviaConsultaPais.executeQuery();
                
                } else  {
                    
                    enviaConsultaTodos = conecta.prepareStatement(consultaTodos);
                    enviaConsultaTodos.setString(1, seccion);
                    enviaConsultaTodos.setString(2, pais);
                    rs = enviaConsultaTodos.executeQuery();
                    
                } 
            
        } catch(Exception e) {
                
        }
        
        return rs;

        }
}
