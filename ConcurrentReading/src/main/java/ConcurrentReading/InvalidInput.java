package ConcurrentReading;

/**
 * Created by Юлия on 11/1/14.
 */
public class InvalidInput extends Exception {

    private String errorMessage;

    public InvalidInput(){
        super();
    }

    public InvalidInput(String message){
        super(message);
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
