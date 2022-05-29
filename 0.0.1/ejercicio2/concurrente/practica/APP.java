package concurrente.practica;

import monitor.Semaforo;

public class APP 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	Semaforo semaforo = new Semaforo(1);
    	UsuarioDelSemaforo t1 = new UsuarioDelSemaforo(semaforo, 1);
    	UsuarioDelSemaforo t2 = new UsuarioDelSemaforo(semaforo, 2);
    	UsuarioDelSemaforo t3 = new UsuarioDelSemaforo(semaforo, 3);
    	UsuarioDelSemaforo t4 = new UsuarioDelSemaforo(semaforo, 4);
    	UsuarioDelSemaforo t5 = new UsuarioDelSemaforo(semaforo, 5);
    	
    	t1.start();
    	t2.start();
    	t3.start();
    	t4.start();
    	t5.start();
    }
}