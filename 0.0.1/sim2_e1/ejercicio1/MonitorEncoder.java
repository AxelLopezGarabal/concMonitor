package ejercicio1;

public class MonitorEncoder {

	private int limit;
	private Object[] frames;
	private int producerPointer;
	private int consumerPointer;
	private int p;
	private int k;
	private int calls;
	private Object encodedPack;
	
	public MonitorEncoder(int m) {
		this.limit = m;
		this.p = 0; //cuenta cuantos elementos hay
		this.k = 0; // limite de getPack
		this.calls = 0; // veces que se llamo a getPack
		this.frames = new Object[m];
	}

	public synchronized void putRawFrame(Object o) throws InterruptedException {
		while(((this.producerPointer + 1) % this.limit) == this.consumerPointer ) {
			System.out.println("no tengo espacio para producir");
			this.wait();
		}
		this.frames[this.producerPointer] = o;
		System.out.println("produce pocision "+ this.producerPointer);
		this.p++;
		this.producerPointer = (this.producerPointer +1) % this.limit;
		this.notifyAll();
	}
	
	public synchronized Object[] getPack(int p) throws InterruptedException {
		this.calls++;
//si ambos punteros apuntan al mismo lugar || si no hay suficientes frames que consumir || se alcanzo el limite de llamados 
		while(this.consumerPointer == this.producerPointer || this.p < p || this.k <= this.calls) {
			System.out.println("espero para consumir");
			this.wait();
		}
		Object[] res = new Object[p];
		for(int i = 0; i < p; i++) {
			System.out.println(i +" >> consume pocision "+ this.consumerPointer);
			res[i] = this.frames[this.consumerPointer];
			this.consumerPointer = (this.consumerPointer +1) % this.limit;
			this.p--;
		}
		this.notifyAll();
		return res;
	}
	
	//este es el que esta feo
	public synchronized void putEncodedPack(Object o) throws InterruptedException {
		while(this.calls == 0) {
			this.wait();
		}
		this.calls--;
		this.notifyAll();
	}  
}
