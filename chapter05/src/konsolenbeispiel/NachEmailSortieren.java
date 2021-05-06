package konsolenbeispiel;

import java.util.Comparator;

// Implementieren Sie die Schnittstelle java.util.Comparator, mit der notwendigen Methode

// Neue Klasse, Schnittstelle "implementieren" 
// ... und notwendige Methode vorsehen?

public class NachEmailSortieren implements Comparator {


    public int compare(Object o1, Object o2) {
        if(o1 == o2) { // referentiell identisch, z.B. null == null
            return 0;
        }
        
        // if(o1 == null || o2 = null)
        
        // null vgl. etwas != null
        if(o1 == null) {
            return -1;
        }
        
        if(o2 == null) {
            return 1;
        }
        
        // Bei primitiven Datentypen könnte man direkt 
        // vergleichen und mit -1 oder 1 beantworten...
//        if(o1.alter < o2.alter) {
//            return -1;
//        }
        
        Person p1 = (Person) o1;
        Person p2 = (Person) o2;
        
        // o1 == o2 =>  0
        // o1  < o2 => -1
        // o1  > o2 =>  1
        
        // wenn compare(o1, o2) == -1 dann 
        // ist wichtig, dass compare(o2, o1) == 1
        
        String email1 = p1.getEmail();
        String email2 = p2.getEmail();
        // was könnte probleme bereiten?
        // -> name1 oder name2 könnte null sein!
       
        
        if(email1 == email2) {
            return 0;
        }
        if(email1 == null) {
            return -1;
        }
        if(email2 == null) {
            return 1;
        }
        
        return email1.compareTo(email2);
    }
    
    // Aufgabe zum Reflektieren:
    // Sortieren sie zuerst nach name und dann nach email => da wo name 0 ist, 
    // dann noch mal email prüfen...!

}
