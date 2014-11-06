package ConcurrentReading;

/**
 * Created by Юлия on 11/1/14.
 */
public interface ISharedSource {

    public String write(String line) throws InvalidInput;
    public boolean read();
}
