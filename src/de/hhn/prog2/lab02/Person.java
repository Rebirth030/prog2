package de.hhn.prog2.lab02;

public class Person {
    private String prename, lastname;
    private int age;

    private Hobby[] hobbys;

    public Hobby[] getHobbys() {
        return hobbys;
    }

    public void setHobbys(Hobby[] hobbys) {
        boolean y = true;
        if (hobbys.length > 5) throw new NoFreeTimeException("Zu viele Hobbys");
        for (int i = 0; i < hobbys.length; i++) {
            for (int o = 0; o < hobbys.length; o++) {
                if (hobbys[i] == hobbys[o] && !(i == o)) {
                    y = false;
                    break;
                }
            }
        }
        if (y) this.hobbys = hobbys;
        else throw new IllegalArgumentException("Ein Hobby darf nur einmal eingetragen werden");
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        if (!(prename == null || prename.isEmpty())) this.prename = prename;
        else throw new IllegalArgumentException("Es muss ein Vorname eingetragen werden");
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        if (!(lastname == null || lastname.isEmpty())) this.lastname = lastname;
        else throw new IllegalArgumentException("Es muss ein Name eingetragen werden");
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (!(age < 0 || age >= 120)) this.age = age;
        else throw new IllegalArgumentException("Es muss ein gültiges Alter eingetragen werden");
    }

    public Person(String prename, String lastname, int age, Hobby[] hobbys) throws NoFreeTimeException {
        setAge(age);
        setLastname(lastname);
        setPrename(prename);
        setHobbys(hobbys);
    }
}
