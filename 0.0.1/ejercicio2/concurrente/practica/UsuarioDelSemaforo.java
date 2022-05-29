package concurrente.practica;

import monitor.Semaforo;

public class UsuarioDelSemaforo extends Thread{

	private Semaforo semaforo;
	private Integer id;

	public UsuarioDelSemaforo(Semaforo semaforo, Integer id) {
		this.semaforo = semaforo;
		this.id = id;
	}

	public void run() {
		try {
			this.semaforo.acquire(this.id);
			this.sleep(100);
			System.out.println("en la seccion critica");
			this.sleep(100);
			this.semaforo.release(this.id);
		} catch (InterruptedException e) {

		}
	}
}
