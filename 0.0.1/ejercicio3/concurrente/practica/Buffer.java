package concurrente.practica;

public class Buffer {

	private Integer bufferLenght;
	private Integer pointerToProduce = 0;
	private Integer pointerToConsume = 0;
	private Object[] buffer;

	public Buffer(Integer i) {
		this.bufferLenght = i;
		this.buffer = new Integer[i];
	}

	public synchronized void push(Integer element) throws InterruptedException {
		while((this.pointerToProduce +1)% this.bufferLenght == this.pointerToConsume) {
			System.out.println("no tengo espacio para producir");
			this.wait();
		}
		this.buffer[this.pointerToProduce] = element;
		System.out.println("produce pocision "+ this.pointerToProduce+ ": dato = "+ element);
		this.pointerToProduce = (this.pointerToProduce +1)% this.bufferLenght ;
		this.notifyAll();
	}
	
	public synchronized Object pop(int id) throws InterruptedException {
		while(this.pointerToConsume == this.pointerToProduce) {
			System.out.println(id + ": no tiene producto para consumir");
			this.wait();
		}
		Object result = this.buffer[this.pointerToConsume];
		System.out.println(id +": consume pocision "+ this.pointerToConsume + ": dato = "+ result);
		this.pointerToConsume = (this.pointerToConsume +1)%this.bufferLenght;
		this.notifyAll();
		return result;
	}
		
	public Object[] getBuffer(){
		return this.buffer;
	}
}
