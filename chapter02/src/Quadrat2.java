
public class Quadrat2 {
    double seitenLaenge;
    public Quadrat2(double seitenLaenge) {
        // Frage: woher kennen wir "this" bereits?
        // -> this(); für Verkettung von Konstruktoren
        this.seitenLaenge = seitenLaenge;
    }
    
    public void sinnvolleMethode() {
        System.out.println("Ping " + this.seitenLaenge); // this. nicht notwendig
    }
    
    public void ausgeben() {
        // Schlüsselwort "this" in Methoden
        this.sinnvolleMethode(); // this. nicht notwendig!
        System.out.println("Seitenlaenge: " + this.seitenLaenge);
    }
    
    public static void main(String[] args) {
        Quadrat2 ref1 = new Quadrat2(1.0);
        Quadrat2 ref2;
        Quadrat2 ref3 = new Quadrat2(3.0);
        
        ref2 = ref1;
        
        ref1.ausgeben();
        ref2.ausgeben();
        ref3.ausgeben();
    }
}
