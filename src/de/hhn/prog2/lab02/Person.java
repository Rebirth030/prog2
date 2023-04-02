package de.hhn.prog2.lab02;


/**
 * Klasse Person, um personen erstelllen zu können.
 */
public class Person {
    private String prename, lastname;
    private int age;

    private Hobby[] hobbys;

    /**
     * Methode um Hobbies zurückzugeben
     * @return Array von Hobby
     */
    public Hobby[] getHobbys() {
        return hobbys;
    }

    /**
     * Methode zum setzten von Hobbies
     * @param hobbys als Array
     */
    public void setHobbys(Hobby[] hobbys) {
        if (hobbys.length > 5) throw new NoFreeTimeException("Zu viele Hobbys");
        for (int i = 0; i < hobbys.length; i++) {
            for (int o = 0; o < hobbys.length; o++) {
                if (hobbys[i] == hobbys[o] && !(i == o)) {
                    throw new IllegalArgumentException("Ein Hobby darf nur einmal eingetragen werden");
                }
            }
        }


    }

    /**
     * gibt prename zurück
     * @return String
     */
    public String getPrename() {
        return prename;
    }

    /**
     * setzt den prename
     * @param prename String
     */
    public void setPrename(String prename) {
        if (!(prename == null || prename.isEmpty())) this.prename = prename;
        else throw new IllegalArgumentException("Es muss ein Vorname eingetragen werden");
    }

    /**
     * gibt lastname zurück
     * @return String
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * setzt lastname
     * @param lastname String
     */
    public void setLastname(String lastname) {
        if (!(lastname == null || lastname.isEmpty())) this.lastname = lastname;
        else throw new IllegalArgumentException("Es muss ein Name eingetragen werden");
    }

    /**
     * gibt age zutück
     * @return int
     */
    public int getAge() {
        return age;
    }

    /**
     * setzt das age
     * @param age int
     */
    public void setAge(int age) {
        if (!(age < 0 || age >= 120)) this.age = age;
        else throw new IllegalArgumentException("Es muss ein gültiges Alter eingetragen werden");
    }

    /**
     * Konstruktor zum erstellen und zuweisen eines Personenobjekts und seinen Attributen.
     * @param prename String
     * @param lastname String
     * @param age int
     * @param hobbys Arry aus Hobbys
     * @throws NoFreeTimeException muss abgefangen werden!
     */
    public Person(String prename, String lastname, int age, Hobby[] hobbys) throws NoFreeTimeException {
        setAge(age);
        setLastname(lastname);
        setPrename(prename);
        setHobbys(hobbys);
    }
}
