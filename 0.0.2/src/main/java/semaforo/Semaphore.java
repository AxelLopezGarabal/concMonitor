package semaforo;

public class Semaphore {

	private Integer n;

	public Semaphore(Integer i) {
		this.n = i;
	}

	public synchronized void release(int id) {
		this.n++;
		System.out.println("el id "+ id +" libero un permiso");
		this.notify();
	}
	
	public synchronized void acquiere(int id) throws InterruptedException {
		while(this.n == 0) {
			System.out.println("el id "+ id +" espera por el permiso");
			this.wait();
		}
		this.n--;
		System.out.println("el id "+ id +" se llevo el permiso");
	}
}
