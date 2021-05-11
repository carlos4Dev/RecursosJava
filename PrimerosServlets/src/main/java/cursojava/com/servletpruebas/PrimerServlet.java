package cursojava.com.servletpruebas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * No se me ejecuta, en la explicación video 246 se importan paquetes javax.servlet 
 * pero a mi me dan errores que desaparecen al importar jakarta.servlet
 * Debe ser error de configuración por diferentes versiones
 */

/**
 * Servlet implementation class PrimerServlet
 */
@WebServlet("/PrimerServlet")
public class PrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PrimerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    // Escificamos formato de respuesta
	   
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		
	     PrintWriter salida = response.getWriter();
        
        // Genera respuesta de la petición
        
        salida.println("<html><body>");
        
        salida.println("<h1 sytle='text-align:center'>Prueba Servlet</h1>");
        salida.println("");
        salida.println("");
        salida.println("");
        salida.println("Fecha y hora actual: " + new Date());
        
        salida.println("</body></html>");
		
	}

}
