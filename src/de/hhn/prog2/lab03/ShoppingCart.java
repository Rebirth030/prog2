package de.hhn.prog2.lab03;

import java.util.HashMap;
import java.util.Map;

/**
 * Ein Einkaufswagen wird Simuliert
 */
public class ShoppingCart {

    private final Map<Product, Integer> cart = new HashMap<>();

    /**
     * Fügt ein Produkt in einer gewissen Anzahl zum Einkaufswagen hinzu
     * @param product Product
     * @param quantity Int
     */
    public void addProduct(Product product, int quantity) {
        int count = cart.getOrDefault(product, 0);
        cart.put(product, count + quantity);
    } // 1 durch quantity ersetzen

    /**
     * Ruft "addProduct" mit der Quantität 1 auf.
     * @param product Product
     */
    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    /**
     * löscht ein Produkt in einer gewissen Anzahl aus dem Einkaufswaagen
     * @param product Product
     * @param quantity int
     */
    public void removeProduct(Product product, int quantity) {
        if(cart.containsKey(product)) {
            int count = cart.get(product);
            if(quantity >= count) {
                cart.remove(product);
            } else {
                cart.put(product, count - quantity);
            }
        } else {
            throw new IllegalStateException("Product not found.");
        }
    }

    /**
     * Ruft "removeProduct" mit der quantität 1 auf.
     * @param product Product
     */
    public void removeProduct(Product product) {
        removeProduct(product, 1);
    }

    /**
     * löscht alles aus dem Einkaufswaagen
     */
    public void removeAll() {
        cart.clear();
    }

    /**
     * überprüft ob der Einkaufswaagen leer ist
     * @return boolean
     */
    public boolean isEmpty() {
        return cart.isEmpty();
    }

    /**
     * guckt, ob ein Produkt im Einkaufswaagen ist
     * @param product Product
     * @return boolean
     */
    public boolean containsProduct(Product product) {
        return cart.containsKey(product);
    }

    /**
     * berechnet den Gesammtpreis der Produkte im Eikaufswaagen
     * @return double
     */
    public double totalPrice() {
        double ret = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            ret += (product.getPrice() * quantity);//hier noch produkt mit quantity multiplizieren
        }
        return ret;
    }

    /**
     * gibt die Anzahl eines Produktes zurück, wenn das Produkt nicht im Wahrenkorb ist, wird 0 zurückgegeben.
     * @param product Product
     * @return int
     */
    public int getQuantity(Product product) {
        int ret;
        try {
            ret = cart.get(product); //Nullpointer expt. wenn Objekt im einkaufswaagen nicht vorhanden.
        } catch (NullPointerException e){
            return 0;
        }
        return ret;
    }

    /**
     * gibt den gesammten inhalt des Einkaufswaagens als String zurück
     * @return String
     */
    public String toString() {
        return cart.toString();
    }

}
