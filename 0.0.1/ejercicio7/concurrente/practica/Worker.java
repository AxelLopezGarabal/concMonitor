package concurrente.practica;

public class Worker extends Thread{

	private BufferPool buffer;

	public Worker(BufferPool buffer) {
		this.buffer = buffer;
	}

	public void run() {
		while(true) {
			try {
				Task t = this.buffer.pop();
				t.exec();
			} catch (InterruptedException e) {}
		}
	}
}
