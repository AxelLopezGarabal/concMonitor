package ejercicio1;

public class AppSim {
    public static void main( String[] args ) throws InterruptedException
    {
    	int M = 5;
    	MonitorEncoder monitor = new MonitorEncoder(M);
    	FrameProductor p = new FrameProductor(monitor);
    	FrameConsumer  c = new FrameConsumer(monitor);
    	
    	p.start();
    	c.start();
    }
}