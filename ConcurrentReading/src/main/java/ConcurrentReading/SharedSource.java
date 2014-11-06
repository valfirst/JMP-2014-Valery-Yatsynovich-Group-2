package ConcurrentReading;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Julia on 10/25/14.
 */
public class SharedSource implements ISharedSource{

    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock read  = readWriteLock.readLock();
    private final Lock write = readWriteLock.writeLock();
    private String path = null;
    private File file = null;

    public SharedSource(){
        this.path = "D://test.txt";
        this.file = new File(path);
    }

    public SharedSource(String path) throws InvalidInput {
        if(path == null || "".equals(path)){
           throw new InvalidInput("SharedSource is not configured correctly.");
        }
        this.path = path;
        this.file = new File(path);
    }

    public String write(String line) throws InvalidInput {
        read.lock();
        try{
            if(line == null || "".equals(line)){
                throw new InvalidInput("Line to write can not be null");
            }
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
                return "success";
            }  catch (IOException e) {
                e.printStackTrace();
                return "failure";
            }
        }finally{
            read.unlock();
        }
    }

    public boolean read(){
        write.lock();
        boolean flag = false;
        try{
            try {
                if(file.exists()){
                    return false;
                }
                FileReader reader = new FileReader(file);
                BufferedReader buffer = new BufferedReader(reader);

                String line = null;
                while ((line = buffer.readLine()) != null) {
                    System.out.println(line);
                    flag = true;
                }
                return flag;
            } catch (IOException e) {
                e.printStackTrace();
                return flag;
            }
        }finally{
            write.unlock();
        }
    }
}
