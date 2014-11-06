package com.epam.exception;

/**
 * Created by Julia on 10/26/14.
 */
public class BankException extends Exception {

    private String errorMessage;

    public BankException(){
        super();
    }

    public BankException(String exceptionMessage){
        super(exceptionMessage);
        this.errorMessage = exceptionMessage;
    }

    public BankException(Exception e){
        super(e);
    }

}
