package cursojava.com.productos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

public class ModeloProductos {

    private DataSource origenDatos;
    
    public ModeloProductos(DataSource origenDatos) {
        
        this.origenDatos = origenDatos;
        
    }
    
    public List<Productos> getProductos () throws Exception {
        
        List<Productos> productos = new ArrayList<>();
        
        Connection miConexion = null;
        Statement miStatement = null;
        ResultSet miResultSet = null;
        
        // -------------- Establecer la conexion------------------------------
        
        miConexion= origenDatos.getConnection();
        
        // -------------- Crear sentencia sql y el statement---------------------------------
        
        String instruccionSql = "SELECT * FROM PRODUCTOS";
        
        miStatement = miConexion.createStatement();
        
        // -------------- Ejecutar sql ------------------------------------------
        
        miResultSet = miStatement.executeQuery(instruccionSql);
        
        // -------------- Recorrer el resultset obtenido --------------------------------
        
        while (miResultSet.next()) {
            
            String cArt = miResultSet.getString("C�DIGOART�CULO");
            String seccion = miResultSet.getString("SECCI�N");
            String nArt = miResultSet.getString("NOMBREART�CULO");
            double precio = miResultSet.getDouble("PRECIO");
            Date fecha = miResultSet.getDate("FECHA");
            String importado = miResultSet.getString("IMPORTADO");
            String pOrig = miResultSet.getString("PA�SDEoRIGEN");
            
            Productos tempProd = new Productos(cArt, seccion, nArt, precio, fecha, importado, pOrig);
            
            productos.add(tempProd);
            
        }
        
        return productos;
        
    }

    public void agregarElNuevoProducto(Productos nuevoProducto) {
        // TODO Auto-generated method stub
        
        Connection miConexion = null;
        
        PreparedStatement miStatement = null;
        
        // Obtener la conexi�n con la BBDD
        
        try {
            
            miConexion = origenDatos.getConnection();
            
        
        // Crear instrucci�n SQL que inserte el producto
        
        String sql = "INSERT INTO PRODUCTOS (C�DIGOART�CULO, SECCI�N, NOMBREART�CULO, PRECIO, FECHA, IMPORTADO, PA�SDEORIGEN)" +
                "VALUES(?,?,?,?,?,?,?)";
        
        miStatement = miConexion.prepareStatement(sql);
        
        // Establecer los par�metros para el producto
        
        miStatement.setString(1, nuevoProducto.getcArt());
        miStatement.setString(2, nuevoProducto.getSeccion());
        miStatement.setString(3, nuevoProducto.getnArt());
        // Establecemos el precio con setDouble
        miStatement.setDouble(4, nuevoProducto.getPrecio());
        // Establecer la fecha desde el miStatement.setDate recibe un objeto que tiene que ser importado java.sql
        // Nosotros tenemos el campo fecha importado con java.util por lo que nos da error
        // Hay que convertir de un date de java.sql a un date de java.util
        // La principal diferencia es que el date de java.sql no trabaja con las horas
        java.util.Date utilDate = nuevoProducto.getFecha();
        java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
        miStatement.setDate(5, fechaConvertida);
        
        miStatement.setString(6, nuevoProducto.getImportado());
        miStatement.setString(7, nuevoProducto.getpOrig());
        
        // Ejecutar la instrucci�n SQL
      
        miStatement.execute();
        
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        
        
    }

    public Productos getProducto(String codigoArticulo) {
        // TODO Auto-generated method stub
        
        Productos elProducto = null;
        Connection miConexion = null;
        PreparedStatement miStatement = null;
        ResultSet miResultSet = null;
        String cArticulo = codigoArticulo;
        
       try {
           
        // Establecer la conexi�n con la BBDD
        
         miConexion = origenDatos.getConnection();
        
        // Crear sentencia SQL que busque el producto
        
         String sql = "SELECT * FROM PRODUCTOS WHERE C�DIGOART�CULO = ?";
         
        // Crear la consulta preparada
        
         miStatement = miConexion.prepareStatement(sql);
         
        // Establecer los par�metros
        
         miStatement.setString(1, cArticulo);
         
        // Ejectutar la consulta
         
         miResultSet = miStatement.executeQuery();
         
         // Obtener los datos de la respuesta
         
         if (miResultSet.next()) {
             
             String seccion = miResultSet.getString("SECCI�N");
             String nArt = miResultSet.getString("NOMBREART�CULO");
             double precio = miResultSet.getDouble("PRECIO");
             Date fecha = miResultSet.getDate("FECHA");
             String importado = miResultSet.getString("IMPORTADO");
             String pOrig = miResultSet.getString("PA�SDEoRIGEN");
             
             elProducto = new Productos(seccion, nArt, precio, fecha, importado, pOrig);
             
         } else {
             
             throw new Exception ("No hemos encontrado el producto con c�digo " + cArticulo);
         }
        
       } catch(Exception e) {
           
           e.printStackTrace();
           
       }
        return elProducto;
    }
    
    
    
}