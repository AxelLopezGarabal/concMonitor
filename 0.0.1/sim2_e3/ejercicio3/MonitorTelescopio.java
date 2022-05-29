package ejercicio3;

public class MonitorTelescopio {
	
	private Integer observando = 0;
	private Integer calibrando =0;
	private Integer posicion = 1;
	private Integer esperando = 0;

	public synchronized void iniciarObservacion(int posicion) throws InterruptedException { 
//C> while(! this.puedeObservar()||(this.observando > 0 && this.posicion != posicion)){el refactor esta en puedeObservar()
		//B> while(! this.puedeObservar() || (this.observando > 0 && this.posicion != posicion)) {
		while(! this.puedeObservar()) {
			this.wait();
		}
		this.posicion = posicion;
		this.observando++;
	}
	
	public synchronized void finalizarObservacion() {
		this.observando--;
		if(this.observando ==0) {
			//B> this.notifyAll() ->como van a haber lectores y escritores esperando hago un notifyAll()
			this.notify();// solo van a haber esperando escritores
		}
	}
	
	public synchronized void iniciarCalibracion() throws InterruptedException {
		//C> this.esperando++;
		while(this.puedeCalibrar()) {
			this.wait();
		}
		this.calibrando++;
		//C> this.esperando--;
	}
	
	public synchronized void finalizarCalibracion() {
		this.calibrando = 0;
		this.notifyAll();
	}
	
	private boolean puedeObservar() {
		//C > return this.calibrando == 0 && this.esperando == 0;
		return this.calibrando == 0;
	}
	
	private boolean puedeCalibrar() {
		return this.calibrando == 0 && this.observando == 0;
	}
}
