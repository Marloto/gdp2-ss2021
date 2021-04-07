// Klassendefinition, es existiert kein Objekt davon
class Quadrat {
    // Klassenattribut, Camel Case -> Großbuchstaben bei neuen Wörtnern
    // Default-Value -> = 1234
    // <typ> <name> [= <default>];
    double seitenLaenge; // 8 byte
    
    // Konstruktor
    // Default-Konstruktor -> haben keine Parameter
    // Warum kein Rückgabe-Datentyp, wenn es doch Ähnlichkeit zu einer Methode hat?
    // -> um es von einer Methode zu unterscheiden!
    Quadrat() {
        // ...
        this(12345.0);
        System.out.println("Default Konstruktor verwendet!");
    }
    Quadrat(double l) {
        System.out.println("Objekt wird mit double erzeugt!");
        seitenLaenge = l;
    }
    Quadrat(int l) {
        this((double) l);
        System.out.println("Objekt wird mit int erzeugt!");
    }
    
    // Methoden, die Dienstleistungen unserer Objekte
    // <rückgabedatentyp> <name>(<parameterliste>) { ... }
    void ausgabe() {
        System.out.printf("Quadrat mit %f%n", seitenLaenge);
    }
    
    // Überladen von Methoden -> bei selben Namen andere Parameterlisten (basierend auf Datentypen)
    void setzeSeitenLaenge(double l) {
        System.out.println("Setze mit double");
        seitenLaenge = l;
    }
    
    void setzeSeitenLaenge(int l) {
        System.out.println("Setze mit int");
        seitenLaenge = l;
    }
    
    public static void main(String[] args) {
        // Erzeugen Objekte mittels "new" + "Klassenname"
        double d = 123.0;
        Quadrat q1 = new Quadrat(d);
        q1.seitenLaenge = 12;
        
        Quadrat q2 = new Quadrat(1234);
        Quadrat q3 = new Quadrat();
        
        q2.setzeSeitenLaenge(12);
        q2.setzeSeitenLaenge(12.0);
        
        q1.ausgabe();
        q2.ausgabe();
        q3.ausgabe();
    }
}