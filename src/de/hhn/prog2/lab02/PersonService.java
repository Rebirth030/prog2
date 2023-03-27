package de.hhn.prog2.lab02;


import java.util.HashMap;

public class PersonService {

    public static Person createPerson(String prename, String lastname, int age, Hobby[] hobbys ) {
        return new Person(prename,lastname,age, hobbys);
    }

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
