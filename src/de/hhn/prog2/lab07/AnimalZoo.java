package de.hhn.prog2.lab07;

import java.util.ArrayList;

/**
 * Da ich das nicht geschrieben habe, kommentiere ich das mal auch nicht
 */
interface Animal {
    void eat();
}

class Tiger implements Animal {
    public void eat() {
        System.out.println("crunch crunch, roaaaar!");
    }
}

class Pig implements Animal {
    public void eat() {
        System.out.println("munch munch, oink!");
    }
}

public class AnimalZoo {
    public static void main(String[] args) {
        ArrayList<Tiger> tigers = new ArrayList<>();
        tigers.add(new Tiger());

        ArrayList<Pig> pigs = new ArrayList<>();
        pigs.add(new Pig());

        feed(tigers);
        feed(pigs);
    }

    // Modify the implementation of this method so that all animals (tigers, pigs, ...)
    // can be fed in the same way with this single (generic) method

    /**
     * ruft die Eat Methode des Tieres auf
     * @param animals Animal List
     * @param <T> AnimalType
     */
    public static <T extends Animal> void feed(ArrayList<T> animals) {
        for (T animal : animals) {
            animal.eat();
        }
    }

}

