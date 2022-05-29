package buffer;

public class APP3 {
	public static void main( String[] args ) throws InterruptedException
    {
		Buffer buffer = new Buffer(5);
		Producer prod = new Producer(buffer);
		Comsumer coms = new Comsumer(buffer);
		
    	prod.start();
    	coms.start();
    }
}
