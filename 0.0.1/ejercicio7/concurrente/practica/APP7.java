package concurrente.practica;

public class APP7 {
    public static void main( String[] args ) throws InterruptedException
    {
    	Task[] tareas = new Task[100];
    	for(int i=0; i<100; i++) {
    		tareas[i] = new DummyTask();
    	}
    	
    	
    	ThreadPool pool = new ThreadPool(tareas, 8);

    	pool.start();
    }
}