package concurrente.practica;

public class Productor extends Thread{

	private Buffer buffer;

	public Productor(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		int i = 0;
		while(i < 15) {
			try {
				this.buffer.push(i);
				i ++;
			} catch (InterruptedException e) {}
		}
	}
}
