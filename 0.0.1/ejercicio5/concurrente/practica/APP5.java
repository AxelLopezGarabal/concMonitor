package concurrente.practica;

public class APP5
{
    public static void main( String[] args ) throws InterruptedException
    {
    	MonitorEvent event = new MonitorEvent();
    	Suscriptor t1 = new Suscriptor(event);
    	Suscriptor t2 = new Suscriptor(event);
    	Suscriptor t3 = new Suscriptor(event);
    	Suscriptor t4 = new Suscriptor(event);
    	
    	Publicador t5 = new Publicador(event);
    }
}