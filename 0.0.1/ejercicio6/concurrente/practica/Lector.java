package concurrente.practica;

public class Lector extends Thread {

	private MonitorRW monitor;
	private String nro;

	public Lector(MonitorRW monitor, String s) {
		this.monitor = monitor;
		this.nro = s;
	}

	public void run() {
		try {
			this.monitor.beginR(this.nro);
			this.sleep(1000);
			this.monitor.endR(this.nro);
		} catch (InterruptedException e) {}
	}
}
