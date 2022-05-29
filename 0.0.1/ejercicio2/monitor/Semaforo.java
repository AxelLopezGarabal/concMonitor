package monitor;

public class Semaforo {

	private Integer nroDePermisos;
	
	public Semaforo(Integer cantidadDePermisos) {
		this.nroDePermisos = cantidadDePermisos;
	}
	
	public synchronized void acquire(Integer id) throws InterruptedException {
		while(this.nroDePermisos == 0) {
			System.out.println(id + "no consumio el permiso");
			this.wait();
		}
		this.nroDePermisos--;
		System.out.println("el thread "+ id +"consumio el permiso");
	}
	
	public synchronized void release(Integer id) throws InterruptedException {
		this.nroDePermisos++;
		System.out.println(id +"libero el permiso");
		this.notify();
	}
}
