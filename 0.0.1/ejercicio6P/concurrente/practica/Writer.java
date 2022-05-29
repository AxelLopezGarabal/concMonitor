package concurrente.practica;

public class Writer extends Thread{

	private MonitorRWP monitor;
	private String s;

	public Writer(MonitorRWP monitor, String string) {
		this.s = string;
		this.monitor = monitor;
	}

	public void run() {
		try {
			this.monitor.beginW(s);
			sleep(100);
			this.monitor.endW(s);
		} catch (InterruptedException e) {}
	}
}
