package concurrente.practica;

public class APP4
{
    public static void main( String[] args ) throws InterruptedException
    {
    	MonitorBarrera barrera = new MonitorBarrera(5);
    	UserDeBarrera t1 = new UserDeBarrera(barrera, "A", 1);
    	UserDeBarrera t2 = new UserDeBarrera(barrera, "B", 2);
    	UserDeBarrera t3 = new UserDeBarrera(barrera, "C", 3);
    	UserDeBarrera t4 = new UserDeBarrera(barrera, "D", 4);
    	UserDeBarrera t5 = new UserDeBarrera(barrera, "E", 5);
    
    	t1.start();
    	t2.start();
    	t3.start();
    	t4.start();
    	t5.start();
    }
}