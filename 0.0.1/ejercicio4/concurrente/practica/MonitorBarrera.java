package concurrente.practica;

public class MonitorBarrera {

	private Integer threadsCoordinar;

	public MonitorBarrera(Integer i) {
		this.threadsCoordinar = i;
	}

	public synchronized void esperar() throws InterruptedException {
		this.threadsCoordinar--;
		while(this.threadsCoordinar > 0) {
			System.out.println("tengo que esperar a "+ this.threadsCoordinar);
			this.wait();
		}
		this.notifyAll();
	}
}
