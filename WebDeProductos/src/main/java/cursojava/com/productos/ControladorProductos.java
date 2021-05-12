package cursojava.com.productos;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ModeloProductos modeloProductos;
	
	@Resource (name="jdbc/Productos")
	
	private DataSource miPool;
	

    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();
        
        try {
            
            modeloProductos = new ModeloProductos(miPool);
        
        } catch(Exception e) {
            
            throw new ServletException(e);
            
        }
        
    }

    /**
     * Default constructor. 
     */
    public ControladorProductos() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    
	    // Leer el parámetro que le llega desde el formulario
	    
	    String elComando = request.getParameter("instruccion");
	    
	    // Si no se envía el parámetr (si solo queremos ver la lista) listar productos
	    
	    if (elComando == null)  elComando = "listar";
	    
	    // Redirigir el flujo de ejecución al método adecuado
	    
	    switch (elComando) {
	    
	    case "listar":
	        
	        obtenerProductos(request, response);
	        
	        break;
	        
	    case "insertarBBDD":
	        
	        agregarProductos(request, response);
	        
	        break;
	        
	    case "cargar":
	        
	        try {
                cargaProductos(request, response);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
	        
	        break;
	        
	    case "actualizarBBDD":
	        
	        try {
                actualizaProductos(request, response);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
	        
	        break;
	        
	    case "eliminar":
	        
	        try {
	         
	            eliminarProducto(request, response);
	            
	        } catch(Exception e) {
	            
	            e.printStackTrace();
	        }
	        
        default: // En este caso no haría falta el default, porque entraría o en listar o en insertar
            
            obtenerProductos(request, response);  // si no entra en ninguno, listaría los productos
            
	    }
	    
	    
	    
	    
	    	    
	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        
	    // Capturar el campo clave, código articulo
	    
	    String codArticulo = request.getParameter("cArticulo");
	    
	    // Borrar producto de la BBDD
	    
	    modeloProductos.eliminarProducto(codArticulo);
	    
	    // Volver al listado de productos
	    
	    obtenerProductos(request, response);
    }

    private void actualizaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        
	    // Leer los datos que le vienen del formulario actualizar
	    
	    String codArticulo = request.getParameter("cArt");
        String seccion = request.getParameter("seccion");
        String nombreArticulo = request.getParameter("nArt");
        // Convertimos de String a double con parseDouble
        double precio =Double.parseDouble(request.getParameter("precio"));
        // Convertir de formato fecha a String es un poco más complidado
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = formatoFecha.parse(request.getParameter("fecha"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String importado = request.getParameter("importado");
        String paisOrigen = request.getParameter("pOrig");
	    
	    // Crear un objeto de tipo Producto con la info del formulario
	    
        Productos productoActualizado = new Productos(codArticulo, seccion, nombreArticulo, precio, fecha, importado, paisOrigen);
	    
	    // Actualizar la BBDD con la info del obj Producto
	    
        modeloProductos.actualizarProducto(productoActualizado);
	    
	    // Volver al listado con la info actualizada
        
        obtenerProductos(request, response);
	    
    }

    // Por si acaso hay algún problema, utilizamos throws para obligar a capturar la excepcion
    private void cargaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        
        // Leer el cArticulo que viene del listado
        
        String codigoArticulo = request.getParameter("cArticulo");
        
        // Enviar cArticulo al modelo
        
        Productos elProducto = modeloProductos.getProducto(codigoArticulo);
        
        // Colocar atributo correspondiente al cArticulo
        
        request.setAttribute("ProductoActualizar", elProducto);
        
        // Enviar Producto al formulario de actualizar (jsp)
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ActualizarProducto.jsp");
        dispatcher.forward(request, response);
        
    }

    private void agregarProductos(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        
        // Leer la información del producto que viene del formulario
        // request.getParameter devuelve un String, habrá que convertir los campos que no son String
        // En este caso hay que convertir los campos fecha y precio, que son date y double
        
        String codArticulo = request.getParameter("cArt");
        String seccion = request.getParameter("seccion");
        String nombreArticulo = request.getParameter("nArt");
        // Convertimos de String a double con parseDouble
        double precio =Double.parseDouble(request.getParameter("precio"));
        // Convertir de formato fecha a String es un poco más complidado
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = formatoFecha.parse(request.getParameter("fecha"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String importado = request.getParameter("importado");
        String paisOrigen = request.getParameter("pOrig");
        
        // Crear un objeto de tipo producto
        
        Productos nuevoProducto = new Productos(codArticulo, seccion, nombreArticulo, precio, fecha, importado, paisOrigen);
        
        // Enviar el objeto al modelo y después insertar el objeto producto en la base de datos
        
        try {
            modeloProductos.agregarElNuevoProducto(nuevoProducto);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        // Volver al listado de Productos
        
        obtenerProductos(request, response);
        
    }

    private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        
        // Obtener la lista de productos desde el modelo
        
        List<Productos> productos;
        
        try {
            
            productos = modeloProductos.getProductos();
            
        // Agregar lista de productos al request
            
            request.setAttribute("LISTAPRODUCTOS", productos);
            
        // Enviar ese request a la página JSP    
            
            RequestDispatcher miDispatcher = request.getRequestDispatcher("/ListaProductos.jsp");
            
            miDispatcher.forward(request, response);
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }

        
    }

}
