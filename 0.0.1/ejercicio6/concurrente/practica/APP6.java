package concurrente.practica;

public class APP6
{
    public static void main( String[] args ) throws InterruptedException
    {
    	String elementoSerializable = null;
    	MonitorRW monitor = new MonitorRW(elementoSerializable);
    	
    	Escritor t1 = new Escritor(monitor, "t1");
    	Escritor t2 = new Escritor(monitor, "t2");
    	
    	Lector t3 = new Lector(monitor, "t3");
    	Lector t4 = new Lector(monitor, "t4");
    	Lector t5 = new Lector(monitor, "t5");
    	Lector t6 = new Lector(monitor, "t6");
    	
    	t1.start();
    	t3.start();
    	t4.start();
    	
    	t2.start();
    	t5.start();
    	t6.start();
    	
    }
}