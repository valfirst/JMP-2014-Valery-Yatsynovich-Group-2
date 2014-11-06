package ConcurrentReading;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Юлия on 10/25/14.
 */
public class SharedSource {

    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock read  = readWriteLock.readLock();
    private final Lock write = readWriteLock.writeLock();
    private final String path = "D://test.txt";
    private final File file = new File(path);

    public void write(String line){
        read.lock();
        try{
            try{
                if(file.exists()){
                    file.createNewFile();
                }
                FileWriter writer = new FileWriter(file,true);
                BufferedWriter buffer = new BufferedWriter(writer);
                PrintWriter printer = new PrintWriter(buffer);
                for(int i=0; i < 9 ; i++){
                    printer.write(line + " : " + i);
                    printer.write("\\n");
                }
                printer.close();

            }  catch (IOException e) {
                e.printStackTrace();
            }
        }finally{
            read.unlock();
        }
    }

    public void read(){
        write.lock();
        try{
            Path pathPath = Paths.get(path);
            try {
                FileReader reader = new FileReader(file);
                BufferedReader buffer = new BufferedReader(reader);

                String line = null;
                while ((line = buffer.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }finally{
            write.unlock();
        }
    }
}
