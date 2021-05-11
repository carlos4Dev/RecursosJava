package cursojava.com.productos;

import java.util.Date;

public class Productos {
    
    private String cArt;
    private String seccion;
    private String nArt;
    private Double precio;
    private Date fecha;
    private String importado;
    private String pOrig;
    
    public Productos(String cArt, String seccion, String nArt, Double precio, Date fecha, String importado,
            String pOrig) {
        // super();   No hereda, no es necesario
        this.cArt = cArt;
        this.seccion = seccion;
        this.nArt = nArt;
        this.precio = precio;
        this.fecha = fecha;
        this.importado = importado;
        this.pOrig = pOrig;
        
    }

    public Productos(String seccion, String nArt, Double precio, Date fecha, String importado, String pOrig) {
        // super();    No es necesario
        this.seccion = seccion;
        this.nArt = nArt;
        this.precio = precio;
        this.fecha = fecha;
        this.importado = importado;
        this.pOrig = pOrig;
    }

    public String getcArt() {
        return cArt;
    }

    public void setcArt(String cArt) {
        this.cArt = cArt;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getnArt() {
        return nArt;
    }

    public void setnArt(String nArt) {
        this.nArt = nArt;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getImportado() {
        return importado;
    }

    public void setImportado(String importado) {
        this.importado = importado;
    }

    public String getpOrig() {
        return pOrig;
    }

    public void setpOrig(String pOrig) {
        this.pOrig = pOrig;
    }

    @Override
    public String toString() {
        return "Productos [cArt=" + cArt + ", seccion=" + seccion + ", nArt=" + nArt + ", precio=" + precio + ", fecha="
                + fecha + ", importado=" + importado + ", pOrig=" + pOrig + "]";
    }
    
    
    
    
    
}
