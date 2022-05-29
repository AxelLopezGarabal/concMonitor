package concurrente.practica;

public class Escritor extends Thread{

	private MonitorRW monitor;
	private String nro;

	public Escritor(MonitorRW monitor, String s) {
		this.monitor = monitor;
		this.nro = s;
	}

	public void run() {
		try {
			this.monitor.beginW(this.nro);
			this.sleep(10000);
			this.monitor.endW(this.nro);
		} catch (InterruptedException e) {}
	}
}
