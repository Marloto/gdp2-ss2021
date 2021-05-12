package collections;

import java.util.TreeMap;

public class TreeMapTest extends Messwerkzeuge {

    public static void main(String[] args) {
        TreeMap<Data, String> treeMap = new TreeMap<>();
        // ---------------- Hinzufügen ----------------------------
        start();
        for (int i = 0; i < ITERATIONS; i++) {
            // Fügen Sie das den Wert value unter Verwendung von key 
            // in die Datenstruktur
            Data key = dummy(i);
            String value = dummyData(i);
            treeMap.put(key, value);
        }
        stopAndPrint("Hinzufügen: %fns");

        // ------------------ Element enthalten -------------------
        start();
        for (int i = 0; i < ITERATIONS; i++) {
            Data key = dummy(i);
            // Prüfen Sie ob der Schlüssel in der Menge enthalten ist
            treeMap.containsKey(key);
        }
        stopAndPrint("Element enthalten: %fns");

        // -------------- Iterieren (mit for-each) ----------------
        start();
        for (Data obj : treeMap.keySet()) {
            // ... hier ist nichts zu tun, betrachten Sie jedoch das Ergebnis
            System.out.println(obj);
            String value = treeMap.get(obj);
        }
        stopAndPrint("Iterieren (mit for-each): %fns");

        // --------------------- Löschen --------------------------
        TreeMap<Data, String> copyList = new TreeMap<>(treeMap);
        start();
        for (int i = 0; i < ITERATIONS; i++) {
            Data key = dummy(i);
            // Entfernen Sie den Schlüssel key aus der Datenstruktur
            copyList.remove(key);
        }
        stopAndPrint("Löschen: %fns");
    }
}