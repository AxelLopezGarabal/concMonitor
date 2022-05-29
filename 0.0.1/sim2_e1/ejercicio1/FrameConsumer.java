package ejercicio1;

public class FrameConsumer extends Thread{

	private MonitorEncoder monitor;

	public FrameConsumer(MonitorEncoder monitor) {
		this.monitor = monitor;
	}

	public void run() {
		try {
			for(int i=0; i< 2; i++) {
				Object[] pack= this.monitor.getPack(3);
				System.out.println("result_len: " + pack.length);
			}
		} catch (InterruptedException e) {}
	}
}
