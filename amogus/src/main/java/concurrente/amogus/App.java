package concurrente.amogus;

public class App 
{
    public static void main( String[] args )
    {   	
    	Integer nroDeTareas = 4;
        Monitor monitor = new Monitor(nroDeTareas);
        Impostor sus = new Impostor(monitor);
        Tripulante a = new Tripulante(monitor, 1);
        Tripulante b = new Tripulante(monitor, 2);
        Tripulante c = new Tripulante(monitor, 3);
        Tripulante d = new Tripulante(monitor, 4);
        
        b.start();
        sus.start();
        a.start();
        c.start();
        d.start();
    }
}
