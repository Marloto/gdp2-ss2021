package konsolenbeispiel;

import java.util.Arrays;
import java.util.Scanner;

// Person ---())--+- KonsoleAnwendung
//                |
// Animal ---())--+

public class KonsolenAnwendung {
    
    private Scanner scanner;

    public KonsolenAnwendung() {
        scanner = new Scanner(System.in);
    }
    
    public void einlesen(DatenEinlesen einlesbar) {
        System.out.println("--------");
        String name;
        while((name = einlesbar.wasFehltNoch()) != null) {
            System.out.print(name + ": ");
            String nextLine = scanner.nextLine();
            einlesbar.setzeNaechstenWert(nextLine);
        }
    }
    
    public void ausgeben(DatenAusgeben ausgebbar) {
        System.out.println("--------");
        //String[] informationen = ausgebbar.informationen();
        for(String information : ausgebbar.informationen()) {
            System.out.println(information);
        }
    }
    
    /**
     * Aufgabe(1) : Implementieren Sie eine Schnittstelle
     * "DatenEinlesen" die zwei Methoden definiert:
     * - eine Methode "wasFehltNoch" mit einem String
     *   als Rückgabedatentyp
     * - eine Methode "setzeNaechstenWert" ohne Rückgabe-
     *   datentyp, die Methode soll eine Zeichenkette als
     *   Parameter erwarten
     * (ca. 5 Minuten)
     */
    /**
     * Aufgabe(2): Implementieren Sie eine Schnittstelle
     * "DatenAusgeben" die eine Methode definiert:
     * - eine Methode informationen die als Rückgabedatentyp
     *   ein Array von Strings verwendet
     */

    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        //Animal animal = new Animal();
        
//        DatenEinlesen einlesbar = animal; 
//        DatenAusgeben ausgebbar = animal;
//        DatenIo io = animal;
        
        KonsolenAnwendung controller = new KonsolenAnwendung();
        controller.einlesen(person1);
        controller.einlesen(person2);
        controller.einlesen(person3);
        
        Person[] liste = new Person[] { person1, person2, person3 };
        
        // Interface Comparable
        // Führt eine Inplace-Sortierung durch
        Arrays.sort(liste);
        
        for(Person p : liste) {
            controller.ausgeben(p);
        }
        
        // Interface Comperator
    }
}
