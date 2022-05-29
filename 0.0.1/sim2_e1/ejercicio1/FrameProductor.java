package ejercicio1;

public class FrameProductor extends Thread{

	private MonitorEncoder monitor;

	public FrameProductor(MonitorEncoder monitor) {
		this.monitor = monitor;
	}

	public void run() {
		for(int i =0; i < 6; i++) {
			try {
				this.monitor.putRawFrame("product_id: " + i);
			} catch (InterruptedException e) {}
		}
	}
}
