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
            
            String cArt = miResultSet.getString("CÓDIGOARTÍCULO");
            String seccion = miResultSet.getString("SECCIÓN");
            String nArt = miResultSet.getString("NOMBREARTÍCULO");
            double precio = miResultSet.getDouble("PRECIO");
            Date fecha = miResultSet.getDate("FECHA");
            String importado = miResultSet.getString("IMPORTADO");
            String pOrig = miResultSet.getString("PAÍSDEoRIGEN");
            
            Productos tempProd = new Productos(cArt, seccion, nArt, precio, fecha, importado, pOrig);
            
            productos.add(tempProd);
            
        }
        
        return productos;
        
    }

    public void agregarElNuevoProducto(Productos nuevoProducto) throws Exception {
        // TODO Auto-generated method stub
        
        Connection miConexion = null;
        
        PreparedStatement miStatement = null;
        
        // Obtener la conexión con la BBDD
        
        try {
            
            miConexion = origenDatos.getConnection();
            
        
        // Crear instrucción SQL que inserte el producto
        
        String sql = "INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, SECCIÓN, NOMBREARTÍCULO, PRECIO, FECHA, IMPORTADO, PAÍSDEORIGEN)" +
                "VALUES(?,?,?,?,?,?,?)";
        
        miStatement = miConexion.prepareStatement(sql);
        
        // Establecer los parámetros para el producto
        
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
        
        // Ejecutar la instrucción SQL
      
        miStatement.execute();
        
        } catch (Exception e) {
            
            e.printStackTrace();
            
        } finally {
            
            miStatement.close();
            miConexion.close();
            
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
           
        // Establecer la conexión con la BBDD
        
         miConexion = origenDatos.getConnection();
        
        // Crear sentencia SQL que busque el producto
        
         String sql = "SELECT * FROM PRODUCTOS WHERE CÓDIGOARTÍCULO = ?";
         
        // Crear la consulta preparada
        
         miStatement = miConexion.prepareStatement(sql);
         
        // Establecer los parámetros
        
         miStatement.setString(1, cArticulo);
         
        // Ejectutar la consulta
         
         miResultSet = miStatement.executeQuery();
         
         // Obtener los datos de la respuesta
         
         if (miResultSet.next()) {
             
             String cArt = miResultSet.getString("CÓDIGOARTÍCULO");
             String seccion = miResultSet.getString("SECCIÓN");
             String nArt = miResultSet.getString("NOMBREARTÍCULO");
             double precio = miResultSet.getDouble("PRECIO");
             Date fecha = miResultSet.getDate("FECHA");
             String importado = miResultSet.getString("IMPORTADO");
             String pOrig = miResultSet.getString("PAÍSDEoRIGEN");
             
             elProducto = new Productos(cArt, seccion, nArt, precio, fecha, importado, pOrig);
             
         } else {
             
             throw new Exception ("No hemos encontrado el producto con código " + cArticulo);
         }
        
       } catch(Exception e) {
           
           e.printStackTrace();
           
       }
       
        return elProducto;
    }

    public void actualizarProducto(Productos productoActualizado) throws Exception {
        // TODO Auto-generated method stub
        
        Connection miConexion = null;
        PreparedStatement miStatement = null;
        
        // Establecer la conexión
        try {
        miConexion = origenDatos.getConnection();
        
        // Crear sentencia  SQL
        
        String sql = "UPDATE PRODUCTOS SECCIÓN = ?, NOMBREARTÍCULO = ?, PRECIO = ?, " + 
                "FECHA = ?, IMPORTADO = ?, PAÍSDEORIGEN = ? WHERE CÓDIGOARTÍCULO = ?";
        
        // Crear la consulta preparada
        
        miStatement = miConexion.prepareStatement(sql);
        
        // Establecer los parámetros
        
        miStatement.setString(1, productoActualizado.getSeccion());
        miStatement.setString(2, productoActualizado.getnArt());
        miStatement.setDouble(3, productoActualizado.getPrecio());
        java.util.Date utilDate = productoActualizado.getFecha();
        java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
        miStatement.setDate(4, fechaConvertida);
        miStatement.setString(5, productoActualizado.getImportado());
        miStatement.setString(6, productoActualizado.getpOrig());
        miStatement.setString(7, productoActualizado.getcArt());
        
        // Ejecutar la instrucción SQL
        
        miStatement.execute();
        } catch (Exception e) {
            
            e.printStackTrace();
            
        } finally {
            
            miStatement.close();
            
            miConexion.close();
            
        }
        
    }

    public void eliminarProducto(String codArticulo) throws Exception {
        // TODO Auto-generated method stub
        
        Connection miConexion = null;
        PreparedStatement miStatement = null;
        
        // Establecer la conexión
        try { 
        miConexion = origenDatos.getConnection();
        
        // Crear la instrucción SQL de eliminación
        
        String sql = "DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO = ? ";
        
        // Preparar la consulta
        
        miStatement = miConexion.prepareStatement(sql);
        
        // Establecer los parámetros de consulta
        
        miStatement.setString(1, codArticulo);
        
        // Ejecutar la sentencia SQL
        
        miStatement.execute();
        } catch (Exception e) {
            
            e.printStackTrace();
            
        } finally {
            
            miStatement.close();
            
            miConexion.close();
            
        }
        
    }
    
    
    
}