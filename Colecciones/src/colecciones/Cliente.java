package colecciones;

public class Cliente {

    private String nombre;
    private String numCuenta; // No se va a operar matemáticamente con esta variable, por eso String
    private double saldo;
    
    public Cliente(String nombre, String numCuenta, double saldo) {
        
        this.nombre = nombre;
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numCuenta == null) ? 0 : numCuenta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (numCuenta == null) {
            if (other.numCuenta != null)
                return false;
        } else if (!numCuenta.equals(other.numCuenta))
            return false;
        return true;
    }
    
    
    
}
