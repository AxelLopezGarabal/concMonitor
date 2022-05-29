package concurrente.practica;

public class MonitorRWP {

	private String elemento;
	private Integer w = 0;
	private Integer ww = 0;
	private Integer r = 0;

	public MonitorRWP(String elementoSerializable) {
		this.elemento = elementoSerializable;
	}
	
	public synchronized void beginR(String nro) throws InterruptedException {
		while(! this.canR()) {
			this.wait();
		}
		System.out.println("+ lectores: "+ nro);
		this.r++;
	}
	
	public synchronized void beginW(String nro) throws InterruptedException {
		this.ww++;
		while(! this.canW()) {
			this.wait();
		}
		this.ww--;
		System.out.println("+ escritores: "+ nro);
		this.w = 1;
	}
	
	public synchronized void endR(String nro)   {
		this.r--;
		System.out.println("- lectores: "+ nro);
		if(this.r == 0) {
			this.notify();
		}
	}
	
	public synchronized void endW(String nro)   {
		this.w = 0;
		System.out.println("- escritores: "+ nro);
		this.notifyAll();
	}
	
	public boolean canR() {
		return this.w == 0 && this.ww == 0;
	}
	public boolean canW() {
		return this.r == 0 && this.w == 0;
	}
}
