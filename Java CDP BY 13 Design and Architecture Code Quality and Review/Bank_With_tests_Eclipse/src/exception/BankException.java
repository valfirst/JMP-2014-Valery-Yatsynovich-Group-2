package exception;

/**
 * Created by Julia on 10/26/14.
 */
public class BankException extends Exception {

    public BankException(){
        super();
    }

    public BankException(String exceptionMessage){
        super(exceptionMessage);
        String errorMessage = exceptionMessage;
    }

    public BankException(Exception e){
        super(e);
    }

}
