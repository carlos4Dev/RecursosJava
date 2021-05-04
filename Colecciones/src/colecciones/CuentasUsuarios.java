package colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CuentasUsuarios {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Cliente cli1 = new Cliente("Pepito Grillo", "00001", 200000);
        Cliente cli2 = new Cliente("Luis Listillo", "00002", 250000);
        Cliente cli3 = new Cliente("Anita Lavati", "00003", 300000);
        Cliente cli4 = new Cliente("Simon Sin", "00004", 500000);
        Cliente cli5 = new Cliente("Pepito Grillo", "00001", 200000);
        Cliente cli6 = new Cliente("Pepito Grillo", "00006", 200000);
        
        Set <Cliente> clientesBanco = new HashSet<Cliente>();
        
        clientesBanco.add(cli1);
        clientesBanco.add(cli2);
        clientesBanco.add(cli3);
        clientesBanco.add(cli4);
        clientesBanco.add(cli5);
        clientesBanco.add(cli6);
        
        // Recorrer el hashSet con un bucle foreach
         
        /* for (Cliente cliente : clientesBanco) {
            
            System.out.println(cliente.getNombre() + " Cuenta: " + cliente.getNumCuenta() 
                + " Saldo: " + cliente.getSaldo() );
            
            if (cliente.getNumCuenta().equals("Luis Listillo")) {
                
                clientesBanco.remove(cliente);
                
            }
            
        }
        */
        // Para eliminar un registro es muy útil el iterator
        
        Iterator <Cliente> it = clientesBanco.iterator();
        
        while (it.hasNext()) {
            
            String nombreCliente = it.next().getNombre();
            
            if (nombreCliente.equals("Luis Listillo")) {
                
                it.remove();
                
            }
            
        }
        
        for (Cliente cliente: clientesBanco) {
            
            System.out.println(cliente.getNombre() + " Cuenta: " + cliente.getNumCuenta()
                + " Saldo: " + cliente.getSaldo());
            
        }
        /* Para recorrer un hashSet e imprimir un solo campo puede estar bien
         * o para eliminar un registro, pero para mostrar todos los campos es más complicado
         
        Iterator <Cliente> it = clientesBanco.iterator();
        
        while (it.hasNext()) {
            
            String nombreCliente = it.next().getNombre();
            
            System.out.println(nombreCliente);
            
        }
        */
        
    }

}
