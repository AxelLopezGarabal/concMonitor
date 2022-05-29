package semaforo;

public class APP2 {
	public static void main( String[] args ) throws InterruptedException
    {
		Semaphore mutex = new Semaphore(1);
		MutexUser t = new MutexUser(1, mutex);
		MutexUser t2 = new MutexUser(2, mutex);
		
		t.start();
		t2.start();
    }
}
