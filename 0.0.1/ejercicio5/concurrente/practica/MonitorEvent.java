package concurrente.practica;

public class MonitorEvent {
	
	  private int cantidadSuscriptores = 0;

	    public MonitorEvent() {
	    }

	    public synchronized void publish() {
	        cantidadSuscriptores++;
	        notifyAll();
	    }

	    public synchronized void suscribe() throws InterruptedException {
	        int suscriptoresOriginales = this.cantidadSuscriptores;
	        while(suscriptoresOriginales == this.cantidadSuscriptores) {
	            wait();
	        }
	    }
}
