package cursojava.com.productos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import jakarta.annotation.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * No me funcionan los ejerecicios de Servlet
 */

/**
 * Servlet implementation class ServletPruebas
 */
@WebServlet("/ServletPruebas")
public class ServletPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Definir o establecer el DataSource
	
	@Resource(name="jdbc/Productos")
	private DataSource miPool;
	
	

    /**
     * Default constructor. 
     */
    public ServletPruebas() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	    
	    // Crear el objeto printWritter
	    
	    PrintWriter salida = response.getWriter();
	    response.setContentType("text/plain");
	    
	    // Crear conexión con BBDD
	    
	    Connection miConexion = null;
	    
	    Statement miStatement = null;
	    
	    ResultSet miResultSet = null;
	    
	    try {
	        
	        miConexion = miPool.getConnection();
	        
	        String miSql = "SELECT * FROM PRODUCTOS";
	        
	        miStatement = miConexion.createStatement();
	        
	        miResultSet = miStatement.executeQuery(miSql);
	        
	        while(miResultSet.next()) {
	            
	            String nombreArticulo = miResultSet.getString(3);
	            salida.println(nombreArticulo);
	        }
	        
	    } catch (Exception e) {
	        
	        e.printStackTrace();
	        
	    }
	    
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
