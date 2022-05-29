package concurrente.practica;

public class APP3
{
    public static void main( String[] args ) throws InterruptedException
    {
    	Buffer buffer = new Buffer(5);
    	Productor productor = new Productor(buffer);
    	Consumidor consumidor = new Consumidor(0, buffer);
    	Consumidor consumidor1 = new Consumidor(1, buffer);
    	Consumidor consumidor2 = new Consumidor(2, buffer);
    	
    	productor.start();
    	consumidor.start();   
    	consumidor1.start();
    	consumidor2.start();
    	
    }
}