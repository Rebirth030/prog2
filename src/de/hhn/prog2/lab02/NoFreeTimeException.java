package de.hhn.prog2.lab02;

/**
 * Exeption NoFreeTime zur Ausgabe.
 */
public class NoFreeTimeException extends RuntimeException{
    public NoFreeTimeException(String errorMessage){
        super(errorMessage);
    }
}
