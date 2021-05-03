package usoThreads;

public class SincronizandoHilos {
	
	// Se puede sincronizar de forma autómatica
	// Siguiente video 172

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HilosVarios hilo1 = new HilosVarios();
		HilosVarios hilo2 = new HilosVarios();
		
		hilo1.start();
		
		try {
			hilo1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hilo2.start();
		
		try {
			hilo2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Terminadas las tareas");
	}

}

class HilosVarios extends Thread {
	
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
