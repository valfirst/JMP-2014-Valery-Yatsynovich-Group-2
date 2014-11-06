package ConcurrentReading;

/**
 * Created by Юлия on 10/25/14.
 */
public class Reader extends Thread {

    private SharedSource sharedSource = null;

    public Reader(SharedSource d, String threadName){
        this.sharedSource = d;
        this.setName(threadName);
    }

    private boolean runForestRun = true;
    @Override
    public void run(){
        System.out.println("Reader starts now!!!");
        while(runForestRun){

            sharedSource.read();

            try{
                System.out.println("Reader is sleeeeeeeping....");
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void stopReader(){
        System.out.println("Reader ends now....");
        this.runForestRun = false;
        this.interrupt();
    }
}
