package de.hhn.prog2.lab09.model;

import java.time.LocalDate;
/**
 * Stellt einen Kunden dar
 */
public class Customer {
    private String prename,lastname;
    private LocalDate dateOfBirth;

    public Customer(String prename, String lastname, LocalDate dateOfBirth) {
        this.prename = prename;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getPrename() {
        return prename;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
