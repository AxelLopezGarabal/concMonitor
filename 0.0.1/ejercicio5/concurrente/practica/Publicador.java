package concurrente.practica;

public class Publicador extends Thread{

	private MonitorEvent event;

	public Publicador(MonitorEvent event) {
		this.event = event;
	}

	public void run() {
		this.event.publish();
	}
}
