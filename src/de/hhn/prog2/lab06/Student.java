package de.hhn.prog2.lab06;

/**
 * Stellt einen Studenten in einer Datenbank dar.
 */
public class Student {
    private String name, prename;
    private int matriculationNumber;

    /**
     * Konstruktor
     * @param name String
     * @param prename String
     * @param matriculationNumber Integer
     */
    public Student(String name, String prename, int matriculationNumber) {
            setName(name);
            setPrename(prename);
            setMatriculationNumber(matriculationNumber);
    }

    public String getName() {
        return name;
    }

    /**
     * überprüft, ob name einen Buchstaben enthält, vor dem Setzen.
     * @param name String
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public void setName(String name) throws IllegalArgumentException {
        if (containsLetter(name)) this.name = name;
        else throw new IllegalArgumentException();
    }

    public String getPrename() {
        return prename;
    }
    /**
     * überprüft, ob prename einen Buchstaben enthält, vor dem Setzen.
     * @param prename String
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public void setPrename(String prename) throws IllegalArgumentException {
        if (containsLetter(prename)) this.prename = prename;
        else throw new IllegalArgumentException();
    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    /**
     * Grenzt den Zahlenraum ein, der für die Matrikelnummer gesetzt werden kann.
     * @param matriculationNumber Integer
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public void setMatriculationNumber(int matriculationNumber) throws IllegalArgumentException {
        if (matriculationNumber >= 100000 && matriculationNumber < 1000000)
            this.matriculationNumber = matriculationNumber;
        else throw new IllegalArgumentException();
    }

    /**
     * Überprüft, ob ein String einen Buchstaben enthält
     * @param string String
     * @return boolean
     */
    private boolean containsLetter(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(string.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
