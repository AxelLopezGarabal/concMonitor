package concurrente.practica;

import java.util.List;

public class BufferPool {

	private int lenght;
	private Task[] buffer;
	private int pointerToAssing = 0;
	private int pointerToProduce = 0;
	

	public BufferPool(Task[] tareas, int size) {
		this.lenght = size;
		this.buffer = tareas;
	}
	
	public synchronized void push(Task t) throws InterruptedException {
		while((this.pointerToProduce  +1)% this.lenght == this.pointerToAssing) {
			this.wait();
		}
		this.buffer[this.pointerToProduce] = t;
		this.pointerToProduce = (this.pointerToProduce +1)% this.lenght ;
		this.notifyAll();
	}
	
	public synchronized Task pop() throws InterruptedException {
		while(this.pointerToAssing == this.pointerToProduce) {
			this.wait();
		}
		Task result = this.buffer[this.pointerToAssing];
		this.pointerToAssing = (this.pointerToAssing +1)%this.lenght;
		this.notifyAll();
		return result;
	}

}
