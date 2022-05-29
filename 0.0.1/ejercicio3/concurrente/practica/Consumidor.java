package concurrente.practica;

public class Consumidor extends Thread{

	private Buffer buffer;
	private int id;

	public Consumidor(int i, Buffer buffer) {
		this.id = i;
		this.buffer = buffer;
	}
	
	public void run() {
		int i = 0;
		while(i < 15) {
			try {
				this.buffer.pop(this.id);
				sleep(1000);
				i ++;
			} catch (InterruptedException e) {}
		}
	}
}
