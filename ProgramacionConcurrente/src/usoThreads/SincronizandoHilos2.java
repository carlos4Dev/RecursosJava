package usoThreads;

public class SincronizandoHilos2 {
	
	// Se puede sincronizar de forma autómatica
	// Siguiente video 172

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HilosVarios2 hilo1 = new HilosVarios2();
		HilosVarios3 hilo2 = new HilosVarios3(hilo1);
		
		hilo2.start();
		hilo1.start();
		
		System.out.println("Terminadas las tareas");
	}

}

class HilosVarios2 extends Thread {
	
	public void run() {
		
		for (int i = 0; i < 15; i++) {
			
			System.out.println("Ejecutando hilo " + getName());
			
			try {
				
				Thread.sleep(300);
				
			} catch(InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
}

class HilosVarios3 extends Thread {
    
    private Thread hilo;
    
    public HilosVarios3(Thread hilo) {
        
        this.hilo = hilo;
        
    }
    
    public void run() {
        
        try {
            hilo.join();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        for (int i = 0; i < 15; i++) {
            
            System.out.println("Ejecutando hilo " + getName());
            
            try {
                
                Thread.sleep(300);
                
            } catch(InterruptedException e) {
                
                e.printStackTrace();
                
            }
            
        }
        
    }
    
}
