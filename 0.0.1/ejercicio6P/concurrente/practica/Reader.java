package concurrente.practica;

public class Reader extends Thread{

	private MonitorRWP monitor;
	private String s;

	public Reader(MonitorRWP monitor, String string) {
		this.s = string;
		this.monitor = monitor;
	}
	
	public void run() {
		try {
			this.monitor.beginR(s);
			sleep(100);
			this.monitor.endR(s);
		} catch (InterruptedException e) {}
	}

}
