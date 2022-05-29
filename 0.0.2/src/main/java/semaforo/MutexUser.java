package semaforo;

public class MutexUser extends Thread{

	private Semaphore semaphore;
	private int id;

	public MutexUser(int id, Semaphore mutex) {
		this.id = id;
		this.semaphore = mutex;
	}

	public void run() {
		try {
			this.semaphore.acquiere(this.id);
			this.sleep(100);
			this.semaphore.release(this.id);
		} catch (InterruptedException e) {e.printStackTrace();}
	}
}
