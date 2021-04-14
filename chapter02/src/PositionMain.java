
public class PositionMain {
    public static void main(String[] args) {

        Position p1 = new Position(10, 5);
        System.out.println(Position.aktuellerZaehler()); // Statischer Zähler auf 1
        
        Position p2 = new Position(10, 5);
        System.out.println(Position.aktuellerZaehler()); // Statischer Zähler auf 2
        
        Position p3 = p1;
        System.out.println(Position.aktuellerZaehler()); // Statischer Zähler bleibt auf 2
        
        System.out.println(p1);
        
        // Wie könnte man p1 und p2 vergleichen?
        // p1.equals(p2) -> ginge bei Zeichenketten direkt, bei eigenen Klassen nicht
        // Wann wäre denn p1 und p2 gleich? -> alle Attribute gleich
        // -> Möglichkeit: über Getter alle Informationen abfragen
        //   -> double p1X = p1.getX();
        //   -> double p2X = p2.getX();
        //   -> if(p1.getX() == p2.getX() && p1.getY() == p2.getY()) {
        // -> Alternativ toString nutzen
        //   -> if(p1.toString().equals(p2.toString())) {
        //   -> möglich, wenn toString die vergleichenden Attribute ausgibt und kein 
        //   -> Informationsverlust damit verbunden ist (z.B. Kürzen von Fließkommazahlen)
        // -> Besser: Equals-Methode in der Klasse Position definieren
        if(p1.equals(p2)) {
            System.out.println("(1) p1 gleich p2");
        }
        // Operator == prüft nur referenzielle Gleichheit bei Objekten - gilt nicht für
        // primitive Datentypen.
        if(p1 == p3) {
            System.out.println("(2) p1 gleich p3"); // nur diese!
        }
    }
}
