
public class Main {
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
