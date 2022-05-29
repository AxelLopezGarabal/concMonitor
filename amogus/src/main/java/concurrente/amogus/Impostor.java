package concurrente.amogus;

import java.util.Random;

public class Impostor extends Thread{

	private Monitor monitor;

	public Impostor(Monitor monitor) {
		this.monitor = monitor;
	}

	public void run() {
		Random ran = new Random();
		while(true){
			int i = ran.nextInt(10)%4;
			this.monitor.block(i);
			try {sleep(6500);} catch (InterruptedException e) {}
			System.out.println("tareas finalizadas: " + this.monitor.getFinished());
		}
	}
}
