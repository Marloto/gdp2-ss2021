
public class AmpelMain {
    public static void main(String[] args) {
        Ampel ampel = new Ampel();
        
        //AmpelZustand zustand = AmpelZustand.ROT;
        ampel.setZustand(AmpelZustand.ROT);
        
        System.out.println(AmpelZustand.GRUEN.ordinal()); // Laufzahl
        System.out.println(AmpelZustand.GRUEN.name()); // "ROT"
        System.out.println(AmpelZustand.GRUEN.toString()); // der Aufruf von .name()
        
        AmpelZustand[] zustaende = AmpelZustand.values();
        AmpelZustand zustand2 = AmpelZustand.valueOf("ROT");
        AmpelZustand zustand3 = AmpelZustand.ROT;
        
        System.out.println(zustand2);
        
        // Frage: Wie wirkt sich der Vergleich mit dem Vergleichsoperator aus?
        // Oder lieber Equals?
        
        if(zustand2 == zustand3) {
            System.out.println("Gleich!"); // ||
        } else {
            System.out.println("Nicht gleich!");
        }
        
        int zufallszahl = zustand2.getZufallszahl();
    }
}
