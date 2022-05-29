package concurrente.practica.monitor;

public class MonitorContador {
	private Integer nro;
	
	public MonitorContador() {
		this.nro = 0;
	}
	
	public synchronized void incrementar() throws InterruptedException {
		this.nro ++;
		System.out.println("se sumo");
		this.notify();
	}
	
	public synchronized void decrementar() throws InterruptedException {
		while(this.nro == 0) {
			this.wait();
		}
		this.nro --;
		System.out.println("se resto");
	}
	
	public Integer getNro() {
		return this.nro;
	}
}
