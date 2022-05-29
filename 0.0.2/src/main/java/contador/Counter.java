package contador;

public class Counter {

	Integer amount;
	
	public Counter() {
		this.amount = 0;
	}
		
	public synchronized void increment() {
		this.amount = this.amount+1;
		System.out.println("incrementa "+this.amount);
		this.notifyAll();
	}
	
	public synchronized void decrement() throws InterruptedException {
		while(this.amount == 0) {
			System.out.println("espera ");
			this.wait();
		}
		this.amount = this.amount -1;
		System.out.println("decremento "+this.amount);
	}

	public Integer getNro() {
		return this.amount;
	}
}
