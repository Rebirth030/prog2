package de.hhn.prog2.lab02;
public class Main {
    /**
     * Erstellt Personen und zum Testen der Ausgaben, auf richtigkeit.
     * @param args
     */
    public static void main(String[] args) {
        try {
            Person person = PersonService.createPerson("ksk", "hap", 13, new Hobby[]{Hobby.HANDBALL, Hobby.BASKETBALL, Hobby.FUSSBALL, Hobby.SCHWIMMEN,Hobby.MALEN,Hobby.SKATEN});
            PersonService.printPerson(person);
        } catch (IllegalArgumentException | NoFreeTimeException e) {
            System.out.println(e);
        }
        try {
            Person person = PersonService.createPerson("Hugo", "Doll", 13, new Hobby[]{Hobby.BASKETBALL, Hobby.HANDBALL, Hobby.SCHWIMMEN});
            PersonService.printPerson(person);
        } catch (IllegalArgumentException | NoFreeTimeException e) {
            System.out.println(e);
        }
    }

}
