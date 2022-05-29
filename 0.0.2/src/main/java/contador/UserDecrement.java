package contador;

public class UserDecrement extends Thread {

	private Counter couter;

	public UserDecrement(Counter contador) {
		this.couter = contador;
	}

	public void start() {
		for(int i=0; i<10; i++) {
			try {
				this.couter.decrement();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
