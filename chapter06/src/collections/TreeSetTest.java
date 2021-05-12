package collections;

import java.util.TreeSet;

public class TreeSetTest extends Messwerkzeuge {
    public static void main(String[] args) {
        TreeSet<Data> treeSet = new TreeSet<Data>();
        // ---------------- Hinzufügen ----------------------------
        start();
        for (int i = 0; i < ITERATIONS; i++) {
            // Fügen Sie das Objekt dummy zum Anfang der ArrayList hinzu
            Data dummy = dummy(i);
            treeSet.add(dummy);
        }
        stopAndPrint("Hinzufügen: %fns");

        // ------------------ Element enthalten -------------------
        start();
        for (int i = 0; i < ITERATIONS; i++) {
            Data dummy = dummy(i);
            // Prüfen Sie ob ein Element in der Menge enthalten ist
            treeSet.contains(dummy);
        }
        stopAndPrint("Element enthalten: %fns");

        // -------------- Iterieren (mit for-each) ----------------
        start();
        for (Data obj : treeSet) {
            // ... hier ist nichts zu tun, betrachten Sie jedoch das Ergebnis
            System.out.println(obj);
        }
        stopAndPrint("Iterieren (mit for-each): %fns");

        // --------------------- Löschen --------------------------
        TreeSet<Data> copySet = new TreeSet<>(treeSet);
        start();
        for (int i = 0; i < ITERATIONS; i++) {
            Data dummy = dummy(i);
            // Entfernen Sie das Element dummy aus der Menge
            copySet.remove(dummy);
        }
        stopAndPrint("Löschen: %fns");
    }

}