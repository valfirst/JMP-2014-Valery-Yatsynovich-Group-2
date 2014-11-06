package ConcurrentReading;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SharedSource sharedSource = new SharedSource();

        new Thread(new Writer(sharedSource, "Mr. Writer 1")).start();
        new Thread(new Writer(sharedSource, "Mr. Writer 2")).start();
        new Thread(new Reader(sharedSource, "Mrs Reader 1")).start();
        new Thread(new Reader(sharedSource, "Mrs Reader 2")).start();
        new Thread(new Reader(sharedSource, "Mrs Reader 3")).start();
        new Thread(new Reader(sharedSource, "Mrs Reader 4")).start();
        new Thread(new Reader(sharedSource, "Mrs Reader 5")).start();


    }
}
