package concurrente.amogus;

public class Monitor {

	private int[] tareasUnicasRealizadas;
	private int[] nroDeTareas;
	private int lastBlock = -1;
	private int[] capPorTarea;

	public Monitor(Integer nroDeTareas) {
		this.nroDeTareas = new int[nroDeTareas];
		for(int i=0; i< nroDeTareas; i++) {this.nroDeTareas[i] = 0;}
		this.tareasUnicasRealizadas = new int[nroDeTareas];
		for(int i=0; i< nroDeTareas; i++) {this.tareasUnicasRealizadas[i] = 0;}
		this.capPorTarea = new int[nroDeTareas];
		for(int i=0; i< nroDeTareas; i++) {this.capPorTarea[i] = 0;}
	}

	public synchronized void beginTask(int task, int id) {
		while(taskIsBlock(task)) {
			System.out.println(id + " crewmate bloqueado por task "+ task);
			try {this.wait();} catch (InterruptedException e) {}
		}
		System.out.println(id+" inicio con la task:" + task);
		this.nroDeTareas[task] += 1; 
	}
	
	public synchronized void endTask (int task, int id) {
		this.capPorTarea[task] +=1;
		//task +1 => es la cantidad de crewmates que necesito para terminar la task
		//this.capPorTarea[task] => es la cantidad que hay que quieren terminar
		while(task+1 > this.capPorTarea[task]) {
			System.out.println(id + " crewmate bloqueado por cap de task "+ task);
			try {this.wait();} catch (InterruptedException e) {}
		}
		this.nroDeTareas[task] -=1;
		if(this.tareasUnicasRealizadas[task] == 0) {
			this.tareasUnicasRealizadas[task] = 1;
		}
		System.out.println(id+ " finalizo la task:" + task);
		if(this.nroDeTareas[task] == 0) {
			notify();
		}
		
	}
	public synchronized void block(int task) {
		while(!canBlock(task)) {
			System.out.println("sus bloqueado por task "+ task);
			try {this.wait();} catch (InterruptedException e) {}
		}
		System.out.println("cambio el bloqueo de task:" + task);
		this.lastBlock = task;
		notifyAll();
		
	}
	
	public synchronized int getFinished () {
		int result = 0;
		for(int i=0; i<this.tareasUnicasRealizadas.length; i++) {
			result +=this.tareasUnicasRealizadas[i];
		}
		return result;
	}
	
	private boolean canBlock(int task) {
		return this.nroDeTareas[task] == 0;
	}
	
	private boolean taskIsBlock(int task) {
		return this.lastBlock == task;
	}
}
