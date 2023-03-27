package de.hhn.prog2.lab02;

public class NoFreeTimeException extends RuntimeException{
    public NoFreeTimeException(String errorMessage){
        super(errorMessage);
    }
}
