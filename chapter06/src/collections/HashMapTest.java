package collections;

import java.util.HashMap;

public class HashMapTest extends Messwerkzeuge {
    public static void main(String[] args) {
        HashMap<Data, String> hashMap = new HashMap<>();
        // ---------------- Hinzufügen ----------------------------
        start();
        for (int i = 0; i < ITERATIONS; i++) {
            // Fügen Sie das den Wert value unter Verwendung von key 
            // in die Datenstruktur
            Data key = dummy(i);
            String value = dummyData(i);
            // einfaches add geht nicht, da zwei Werte hinzumüssen
            hashMap.put(key, value);
        }
        stopAndPrint("Hinzufügen: %fns");

        // ------------------ Element enthalten -------------------
        start();
        for (int i = 0; i < ITERATIONS; i++) {
            Data key = dummy(i);
            // Prüfen Sie ob der Schlüssel in der Menge enthalten ist
            hashMap.containsKey(key);
        }
        stopAndPrint("Element enthalten: %fns");

        // -------------- Iterieren (mit for-each) ----------------
        start();
        for (Data obj : hashMap.keySet()) {
            // ... hier ist nichts zu tun, betrachten Sie jedoch das Ergebnis
            System.out.println(obj);
        }
        stopAndPrint("Iterieren (mit for-each): %fns");

        // --------------------- Löschen --------------------------
        HashMap<Data, String> copyMap = new HashMap<>(hashMap);
        start();
        for (int i = 0; i < ITERATIONS; i++) {
            Data key = dummy(i);
            // Entfernen Sie den Schlüssel key aus der Datenstruktur
            copyMap.remove(key);
        }
        stopAndPrint("Löschen: %fns");
    }

}