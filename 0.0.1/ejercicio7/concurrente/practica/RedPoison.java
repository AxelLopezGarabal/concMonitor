package concurrente.practica;

public class RedPoison extends Task{
	public RedPoison() {
		super();
	}
	
	public void exec() {
		System.out.println("die");
	}
}
