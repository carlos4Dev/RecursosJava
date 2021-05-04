package usoThreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BancoSinSincronizar {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Banco b = new Banco();
        
        for (int i = 0; i < 100; i++) {
            
            EjecucionTransferencias r = new EjecucionTransferencias(b, i, 2000);
            Thread t = new Thread(r);
            t.start();
            
        }

    }

}

class Banco {
    
    private final double[] cuentas;
    
    // private Lock cierreBanco = new ReentrantLock();
    
    // private Condition saldoSuficiente;
    
    public Banco() {
        
        // Iniciamos el array que es constante cuentas, en 100
        cuentas = new double[100];
        
        // A cada elemento del array le asignamos 2000
        for (int i = 0; i < cuentas.length; i++) {
            
            cuentas [i] = 2000;
        }
        
        // Si utilizamos synchronized en la declaración de transferencia ya no es necesario
        // saldoSuficiente = cierreBanco.newCondition();
        
    }
    
    
    /* Al utilizar programación concurrente, se está sacando dinero a la vez de varias cuentas
     y en ocasiones se saca de la misma cuenta antes de que se ingrese en la siguiente
     por lo que el saldo total no coincide, para corregir esto e impedir que un hilo pueda ejecutarse
    antes de que finalize otro se puede utilizar la clase ReentrantLock() 
    */
    
    // Al utilizar synchonized, ya no son necesarios condiciones de cierre y bloqueos del video 177
    public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {
        
        // Bloqueamos el hilo para que realice las instrucciones
        
        // cierreBanco.lock();
        
        // try {
            
            while(cuentas[cuentaOrigen] < cantidad) {
                // Si el saldo es inferior a la cantidad, el hilo queda a la espera y otro hilo puede ejecutarse
               
                // saldoSuficiente.await();
                
                wait();
                
            }
            // Evaluamos si la cantidad no supera al saldo de la cuentaOrigen
            /* if (cuentas[cuentaOrigen] < cantidad) {
                
               System.out.println("-------------- CANTIDAD INSUFICIENTE --->>> " 
                      + cuentaOrigen + " ...... SALDO: " + cuentas[cuentaOrigen] + "....." + cantidad);
                
               return;
                
            }  else {
                
               System.out.println(" ----- CANTIDAD OK --->>>" + cuentaOrigen);
                
            }*/
            
            System.out.println(Thread.currentThread());
            
            cuentas[cuentaOrigen] -= cantidad;  // Dinero que sale de la cuenta origen
            
            System.out.printf("%10.2f de %d para %d ",cantidad, cuentaOrigen, cuentaDestino);
            
            cuentas[cuentaDestino] += cantidad; // Dinero que entra en la cuenta destino
            
            System.out.printf("Saldo total: %10.2f%n", getSaldoTotal());
            
            // Se avisa a todos los hilos de que se ha realizado la operación
            // Los hilos que estan pendientes tienen que evaluar si ahora tienen saldo para realizar operación
            // Si ahora tiene saldo, el hilo se ejecuta, si no, sigue a la espera y otro hilo se ejecutará
            //saldoSuficiente.signalAll();
            
            notifyAll();
        
        } // finally {
            // Desbloqueamos para que otro hilo pueda volver a ejecutar las instrucciones
            // cierreBanco.unlock();
            
        //}
            
   // }
    
    public double getSaldoTotal() {
        
        double sumaCuentas = 0;
        
        for (double a: cuentas) {
            
            sumaCuentas += a;
            
        }
        
        return sumaCuentas;
        
    }
    
}

class EjecucionTransferencias implements Runnable {
    
    private Banco banco;
    private int deLaCuenta;
    private double cantidadMax;
    
    public EjecucionTransferencias(Banco b, int de, double max) {
        
        banco = b;
        deLaCuenta = de;
        cantidadMax = max;
        
    }
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            while(true) {
                
                int paraLaCuenta = (int)(100 * Math.random());
                
                double cantidad = cantidadMax * Math.random();
                
                banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
                
                Thread.sleep((int)(Math.random()*10));
                
            }   
            
        } catch (InterruptedException e) {}
              
    }
    
}