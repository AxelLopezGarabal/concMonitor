package concurrente.practica;

public class APP6b {
    public static void main( String[] args ) throws InterruptedException
    {
    	String elementoSerializable = null;
    	MonitorRWP monitor = new MonitorRWP(elementoSerializable);
    	
    	Writer t1 = new Writer(monitor, "t1");
    	Writer t2 = new Writer(monitor, "t2");
    	
    	Reader t3 = new Reader(monitor, "t3");
    	Reader t4 = new Reader(monitor, "t4");
    	Reader t5 = new Reader(monitor, "t5");
    	Reader t6 = new Reader(monitor, "t6");
    	
    	t1.start();
    	t3.start();
    	t4.start();
    	
    	t2.start();
    	t5.start();
    	t6.start();
    	
    }
}
