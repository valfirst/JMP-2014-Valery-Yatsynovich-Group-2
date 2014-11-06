package ConcurrentReading;

/**
 * Created by Юлия on 10/25/14.
 */
public class Writer extends Thread {

    private boolean runForestRun = true;
    private SharedSource sharedSource = null;

    public Writer(SharedSource d, String threadName){
        this.sharedSource = d;
        this.setName(threadName);
    }

    @Override
    public void run(){
        while(this.runForestRun){
            System.out.println("Writer starts now!!!");
            try {
                sharedSource.write("some test");
            } catch (InvalidInput invalidInput) {
                invalidInput.printStackTrace();
            }

            try{
                System.out.println("Writer is sleeeeping....");
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void stopWriter(){
        System.out.println("Writer ends now.....");
        this.runForestRun = false;
        this.interrupt();
    }
}
