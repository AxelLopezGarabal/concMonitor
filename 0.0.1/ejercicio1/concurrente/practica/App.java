package concurrente.practica;

import concurrente.practica.monitor.MonitorContador;
import concurrente.practica.monitor.UsuarioDelContador;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	MonitorContador contador = new MonitorContador();
        UsuarioDelContador t1 = new UsuarioDelContador(contador);
        UsuarioDelContador t2 = new UsuarioDelContador(contador);
        UsuarioDelContadorRestador t4 = new UsuarioDelContadorRestador(contador);
        UsuarioDelContadorRestador t5 = new UsuarioDelContadorRestador(contador);
        
        t1.start();
        t2.start();
        t4.start();
        t5.start();
     
        Thread.sleep(100);
        t1.interrupt();
        t2.interrupt();
        t4.interrupt();
        t5.interrupt();
        System.out.println();
        System.out.println();
        System.out.println(contador.getNro());
        System.out.println();
        System.out.println();
    }
}
