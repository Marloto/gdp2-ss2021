
public class Quadrat1 {
    double seitenLaenge;
    public Quadrat1(double seitenLaenge) {
        // Frage: woher kennen wir "this" bereits?
        // -> this(); für Verkettung von Konstruktoren
        this.seitenLaenge = seitenLaenge;
    }
    
    public void ausgeben() {
        // Schlüsselwort "this" in Methoden
        System.out.println("Seitenlaenge: " + seitenLaenge);
    }
    
    public static void main(String[] args) {
        Quadrat1 ref1 = new Quadrat1(1.0);
        Quadrat1 ref2;
        Quadrat1 ref3 = new Quadrat1(3.0);
        
        ref2 = ref1;

        ref2 = ref3;
        
        ref2.seitenLaenge = 4;
        
        ref2 = ref1;
        
        ref1.seitenLaenge = 5;
        ref2.seitenLaenge = 6;
        
        
        // Frage: Was sind die Ausgaben?
        
        ref1.ausgeben(); // 6.0
        ref2.ausgeben(); // 6.0
        ref3.ausgeben(); // 4.0
        
        // Frage: Gehen Referenzen auch für primitive Datentypen/Strings/Arrays?
        // -> Strings und Arrays sind Objekte
        
        String str1 = "Hallo, Welt!";
        String str2 = str1;
        
        str2 += "2";
        
        int int1 = 1;
        int int2 = int1;
        
        int2 = 2;
    }
}
