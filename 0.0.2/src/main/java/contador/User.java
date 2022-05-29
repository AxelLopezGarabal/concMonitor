package contador;

public class User extends Thread{

	private Counter contador;

	public User(Counter contador) {
		this.contador = contador;
	}
	
	public void run() {
		for(int i=0; i<10; i++) {
			this.contador.increment();
		}
	}
}
