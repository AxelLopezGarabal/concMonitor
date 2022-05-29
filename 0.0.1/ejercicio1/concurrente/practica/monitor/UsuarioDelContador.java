package concurrente.practica.monitor;

public class UsuarioDelContador extends Thread{
	private MonitorContador contador;

	public UsuarioDelContador(MonitorContador contador) {
		this.contador = contador;
	}
	
	public void run() {
		try {
			int i = 0;
			while ( i <  100) {
				this.contador.incrementar();
				i ++;
			}
		} 
		catch ( InterruptedException e){}

	}
}
