package concurrente.amogus;

import java.util.Random;

public class Tripulante extends Thread{

	private Monitor monitor;
	private int id;


	public Tripulante(Monitor monitor, int i) {
		this.monitor = monitor;
		this.id = i;
	}

	public void run() {
		Random ran = new Random();
		while(true){
			int x = ran.nextInt(10)%4;
			this.monitor.beginTask(x, this.id);
			//hago la tarea
			try {sleep(6000);} catch (InterruptedException e) {}
			this.monitor.endTask(x, this.id);
		}
	}
}
