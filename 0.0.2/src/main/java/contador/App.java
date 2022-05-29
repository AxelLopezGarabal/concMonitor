package contador;


public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	Counter couter = new Counter();
    	UserDecrement t = new UserDecrement(couter);
    	User t1 = new User(couter);
    	User t2 = new User(couter);
    	User t3 = new User(couter);
    	UserDecrement t4 = new UserDecrement(couter);
    	UserDecrement t5 = new UserDecrement(couter);
    	
    	t1.start();
    	t.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
        Thread.sleep(100);
        System.out.println();
        System.out.println();
        System.out.println(couter.getNro());
        System.out.println();
        System.out.println();
    }
}
