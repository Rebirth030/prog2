package de.hhn.prog2.lab07;

/**
 * Ich kommentiere mal nicht, weil nicht selbst geschreiben.
 */
public class GenericsExercise {

    public static void main(String[] args) {
        checkTypes("Hallo");
        checkTypes(41);
        checkTypes("A");
        checkTypes(3.1337);
    }

    /**
     * gibt den Klassennamen des Objektes in einem String wieder
     * @param t Objekt
     * @param <T> ObjektTyp
     */
    public static<T> void checkTypes(T t) {
        System.out.format("%s is of Type %s%n", t.toString(), t.getClass().getName());
    }
}
