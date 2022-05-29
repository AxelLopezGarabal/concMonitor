package buffer;

public class Comsumer extends Thread {

	private Buffer buffer;

	public Comsumer(Buffer buffer) {
		this. buffer = buffer;
	}

	public void run() {
		for(int i=0; i<5; i++) {
			try {
				this.buffer.pop(i);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}
