
class Lenkrad {
    
    private Auto auto;

    void doOtherthing() {
        System.out.println("Lenkrad");
    }
    void configAuto(Auto auto) {
        this.auto = auto;
    }
}

class Rad {
    void doSomething() {
        System.out.println("Rad");
    }
}

class Auto {
    private Lenkrad lenkrad; // Aggregation
    // private Rad vorneLinks;
    // private Rad vorneRechts;
    private Rad[] raeder;
    
    public Auto(Lenkrad lenkrad, Rad[] raeder) {
        this.lenkrad = lenkrad;
        this.lenkrad.configAuto(this);
        this.raeder = raeder;
    }
    
    // Default-Konstruktor
    public Auto() {
        this.lenkrad = new Lenkrad();
        Rad r1 = new Rad();
        Rad r2 = new Rad();
        
        this.raeder = new Rad[] {r1, r2};
    }
    
    void doAutothing() {
        this.lenkrad.doOtherthing();
        for(Rad rad : this.raeder) {
            rad.doSomething();
        }
    }
    
//    public static void main(String[] args) {
//        Lenkrad l1 = new Lenkrad();
//        Rad r1 = new Rad();
//        Rad r2 = new Rad();
//        
//        Rad[] raeder = new Rad[] {r1, r2};
//        
//        Auto a1 = new Auto(l1, raeder);
//        a1.doAutothing();
//        
//        // ----
//        
//        Auto a2 = new Auto();
//        a2.doAutothing();
//    }
}

// LKW ist spezieller als Auto
// LKW spezialisiert Auto
// LKW ist Kindklasse
// Auto ist genereller als LKW
// Auto ist Elternklasse
// Übernommen werden: Attribute und Methoden
public class Lkw extends Auto { // extends steuert die Vererbung
    // raeder und lenkrad nicht sichtbar aus Auto, existieren im Speicher!
    private Lenkrad lenkrad;
    public Lkw() {
        this.lenkrad = new Lenkrad();
    }
    
    public static void main(String[] args) {
        Lkw lkw = new Lkw();
        
        lkw.doAutothing();
    }
}

