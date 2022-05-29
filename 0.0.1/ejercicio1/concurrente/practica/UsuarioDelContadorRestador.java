package concurrente.practica;

import concurrente.practica.monitor.MonitorContador;

public class UsuarioDelContadorRestador extends Thread{

	private MonitorContador contador;

	public UsuarioDelContadorRestador(MonitorContador contador) {
		this.contador = contador;
	}

	public void run() {
		try {
			int i = 0;
			while ( i <  100) {
				this.contador.decrementar();
				i ++;
			}
		} 
		catch ( InterruptedException e){}

	}
}
