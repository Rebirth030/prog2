package de.hhn.prog2.lab02;


import java.util.HashMap;

/**
 * Eine Klasse zum Handeln von Personenobjekten.
 * @author Julian
 */
public class PersonService {

    /**
     * Eine Methode um ein Personenobjekt zu erstellen, wobei das Objekt wird zurückgegeben
     * @param prename String
     * @param lastname String
     * @param age int
     * @param hobbys Array aus Hobbys
     * @return Person
     */
    public static Person createPerson(String prename, String lastname, int age, Hobby[] hobbys ) {
        return new Person(prename,lastname,age, hobbys);
    }

    /**
     * Erstellt eine Hashmap, um die Enumwerte Strings zuzuteilen. Dann werden die Attribute des Personenobjekts ausgegeben, die Hobbies einzeln als Strings.
     * @param person Person
     */
    public static void printPerson(Person person) {
        HashMap<Hobby, String> hashMap = new HashMap<>();
        hashMap.put(Hobby.BASKETBALL,"Basketball");
        hashMap.put(Hobby.SCHWIMMEN,"Schwimmen");
        hashMap.put(Hobby.HANDBALL,"Handball");
        hashMap.put(Hobby.FUSSBALL,"Fußball");
        hashMap.put(Hobby.MALEN,"Malen");
        hashMap.put(Hobby.SKATEN,"Skaten");
        System.out.print("Die Person heißt: " + person.getPrename()+ " "+person.getLastname() + ", sie ist " + person.getAge() + " Jahre alt und seine Hobbys sind: ");
        for (Hobby hobby: person.getHobbys()) {
            System.out.print(hashMap.get(hobby) + " ");
        }
    }
}
