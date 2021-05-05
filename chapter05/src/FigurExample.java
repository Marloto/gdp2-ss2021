//abstract class Figur {
//    public abstract double flaeche();
//}

// Definition eines neuen Interfaces
// -> Schnittstellen "Namen" sind wieder Datentypen
interface Figur {
    // attribute auch nicht
    // keine konstruktoren
    /*public*/ double flaeche();
    
    // weitere Methoden möglich (i.R. keine methodenkörper)
    
    // aber per "default" möglich, was meisten passieren sollte
    // Hinweis: das hinten an stellen
    default void doSomething() {
        System.out.println("Hello, World");
    }
}

// Meine Klasse "commited" sich darauf diese Schnittstelle anzubieten
// -> Klasse implementiert die Schnittstelle über "implements"
class Kreis implements Figur {
    private double radius;

    public Kreis(double radius) {
        this.radius = radius;
    }

    public double flaeche() {
        return Math.PI * radius * radius;
    }
    
    public double addiereFlaeche(Figur figur) {
        return this.flaeche() + figur.flaeche();
    }
}

class Rechteck implements Figur {
    private double hoehe;
    private double breite;

    public Rechteck(double hoehe, double breite) {
        this.hoehe = hoehe;
        this.breite = breite;
    }

    public double flaeche() {
        return hoehe * breite;
    }
}

public class FigurExample {
    public static void main(String[] args) {
        
        Figur figur1 = new Kreis(10);
        Figur figur2 = new Rechteck(4, 2);
        
        // ----
        
        System.out.println(figur1.flaeche());
        System.out.println(figur2.flaeche());
        
        // ----
        
        // Downcast
        Kreis kreis = (Kreis) figur1;
        kreis.addiereFlaeche(figur2);
    }
}
