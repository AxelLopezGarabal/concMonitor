package concurrente.practica;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool{
	
	
	private Integer amountOfWorkers;
	private BufferPool buffer;

	public ThreadPool(Task[] tareas, Integer nroWorkers) {
		this.buffer = new BufferPool(tareas, tareas.length);
		this.amountOfWorkers = nroWorkers;
	}

	private List<Worker> workers(){
		List<Worker> workers = new ArrayList<Worker>();
		for(int i =0; i < this.amountOfWorkers; i++) {
			workers.add(new Worker(this.buffer));
		}
		return workers;
	}
	
	public void start() {
		List<Worker> w = this.workers();
		w.stream().forEach(worker -> worker.start());
		try {
			this.buffer.push(new RedPoison());
		} catch (InterruptedException e) {}
	}
}
