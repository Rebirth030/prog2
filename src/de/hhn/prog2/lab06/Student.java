package de.hhn.prog2.lab06;

public class Student {
    private String name, prename;
    private int matriculationNumber;

    public Student(String name, String prename, int matriculationNumber) {
        try {
            setName(name);
            setPrename(prename);
        } catch (IllegalArgumentException e) {
            System.out.println("Bitte geben sie valide Werte für den Vor- und Nachnamen ein.");
        }
        try {
            setMatriculationNumber(matriculationNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("Bitte geben sie eine sechsstellige Matrikelnummer ein");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (containsLetter(name)) this.name = name;
        else throw new IllegalArgumentException();
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) throws IllegalArgumentException {
        if (containsLetter(prename)) this.prename = prename;
        else throw new IllegalArgumentException();
    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(int matriculationNumber) throws IllegalArgumentException {
        if (matriculationNumber >= 100000 && matriculationNumber < 1000000)
            this.matriculationNumber = matriculationNumber;
        else throw new IllegalArgumentException();
    }

    private boolean containsLetter(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(string.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
