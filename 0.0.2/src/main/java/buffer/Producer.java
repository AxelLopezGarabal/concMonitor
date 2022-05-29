package buffer;

public class Producer extends Thread{

	private Buffer buffer;

	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		for(int i=0; i<5; i++) {
			try {
				this.buffer.push(i);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}
