package concurrente.practica;

public class Suscriptor extends Thread{

	private MonitorEvent event;

	public Suscriptor(MonitorEvent event) {
		this.event = event;
	}

	public void run() {
		try {
			this.event.suscribe();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
