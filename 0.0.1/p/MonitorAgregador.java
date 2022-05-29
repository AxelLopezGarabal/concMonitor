
public class MonitorAgregador {
	private int nroDelectores = 0;
	private int nroDeEscritores = 0;
	private int nroDeEscritEsp =0;
	
	Object[] fuentes = new Object[5];
	
	public synchronized void iniciarCarga() throws InterruptedException {
		this.nroDeEscritEsp++;
		while(!(this.nroDelectores == 0)) {this.wait();}
		this.nroDeEscritores++;
		this.nroDeEscritEsp--;
	}
	public synchronized void cargarFuente(int i) {
		this.fuentes[i] = Math.random();
	}
	public synchronized void finalizarCarga() {
		this.nroDeEscritores--;
		if(this.nroDeEscritores == 0) {
			this.notify();
		}
	}
	public synchronized void iniciarDescarga() throws InterruptedException {
		this.nroDelectores++;
	}
	public synchronized void descargarFuente(int i) throws InterruptedException {
		while((! (this.nroDelectores == 1 && this.nroDeEscritores == 0 && this.nroDeEscritEsp == 0))|| this.fuentes[i] == null) {
			this.wait();
		}
		//lee el data
	}
	public synchronized void finalizarDescarga() {
		this.nroDelectores--;
		this.notifyAll();
	}
}
