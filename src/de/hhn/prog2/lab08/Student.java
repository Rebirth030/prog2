package de.hhn.prog2.lab08;

/**
 * Stellt einen Studenten dar.
 */
public class Student {
    private String prename;
    private String lastname;
    private int studentNumber;

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * Konstruktor ...
     * @param prename String
     * @param lastname String
     * @param studentNumber Integer
     */
    public Student(String prename, String lastname, int studentNumber) {
        this.prename = prename;
        this.lastname = lastname;
        this.studentNumber = studentNumber;
    }
}
