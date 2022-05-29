package concurrente.practica;

public class UserDeBarrera extends Thread{

	private MonitorBarrera barrera;
	private String letter;
	private Integer nro;

	public UserDeBarrera(MonitorBarrera barrera, String s, Integer i) {
		this.barrera = barrera;
		this.letter = s;
		this.nro = i;
	}

	public void run() {
		try {
			System.out.println(this.letter);
			this.barrera.esperar();
			System.out.println(this.nro);
		} 
		catch (InterruptedException e) {}
	}
}
