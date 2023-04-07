package de.hhn.prog2.lab03;

/**
 * Klasse zum Darstellen eines Produktes
 */
public class Product {
    private final String name;
    private final double price;

    /**
     * Konstruktor für ein Produkt-Objekt
     * @param name String
     * @param price String
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * gibt Namen zurück
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt preis zurück
     * @return double
     */
    public double getPrice() {
        return price;
    }

    /**
     * gibt Produkt als Sting zurück
     * @return String
     */
    @Override
    public String toString() {
        return "Product{" + "name='" + name + '\'' + ", price=" + price + '}';
    }

}
