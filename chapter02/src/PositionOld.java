public class PositionOld {

    
    private double x;
    private double y;
    
    public PositionOld(double x, double y) {
        this.x = x;
        this.y = y;
        
        zaehler ++;
    }
    
    // (1) Sichtbarkeiten (public, private)
    // -> 4 Stufen der Sichtbarkeit in Java
    // -> public -> alles ist öffentlich, für jeden der die Klasse nutzt
    // -> protected (machen wir in Kapitel 3)
    // -> kein Schlüsselwort bedeutet "package internal"
    // -> private 
    // "Wer könnten Nutzer sein"
    // -> Nutzung aus Perspektive der Klasse Position
    // -> Nutzung aus Perspektive der Klasse PositionMain
    // -> Über Projektgrenzen hinweg
    // -> Über Paketgrenzen hinweg
    
    
    // (2) Getter und Setter
    // -> Attribute besser geheim halten
    // -> Lesen und Schreiben über Getter und Setter
    // -> Standard-Struktur in Java
    // private <Datentyp> <name>
    // Typische Getter in Java
    // <Sichtbarkeit> <Rückgabe-Datentyp> get<Name>() { // ohne Parameter!
    //     return this.<name>;
    // }
    
    // Typische Setter in Java
    // <Sichtbarkeit> void set<Name>(<Datentyp> <name>) {
    //     this.<name> = var;
    // }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }

    // Spezieller mit Rückgabe der Klassen-Instanz zum verketteten Aufruf von
    // Settern:
    // public Position setX(double x) {
    //     this.x = x; // z.B. dafür sorgen, dass im Wertebereich bleibt
    //     return this;
    // }
    // -> erlaubt sowas wie new Position(1, 2).setX(10).setY(5).setX(42).setY(13);
    
    public void setX(double x) {
        this.x = x; // Transformieren oder Wertebereichsprüfungen möglich
    }
    
    public void setY(double y) {
        this.y = y;
    }

    // (3) toString
    // Standardmethode toString zur Beschreibung der Repräsentation als 
    // eines Objektes als String
    public String toString() {
        return this.x + " / " + this.y;
    }
    
    // (4) Überprüfung auf Gleichheit
    // Standardmethode equals kann genutzt werden, um zu beschrieben, wie 
    // zwei Instanzen / Objekte der Klasse verglichen werden
    public boolean equals(Object o) {
        // int a = (int) 1.2345; // <- cast von double zu int
        Position p = (Position) o; // <- cast von Object zu Position, vgl. Kapitel 3
        
        return this.getX() == p.getX() && this.getY() == p.getY();
        
        // Alternativ sieht es so aus:
        // if(this.getX() == p.getX() && this.getY() == p.getY()) {
        //     return true;
        // }
        // return false;
    }
    
    // (5) Statische Elemente (static)
    // Erlaubt Attribute und Methoden die ohne Instanzen genutzt werden können
    // Zugriff über eine Instanz bedeutet damit, dass alle Instanzen auf das 
    // selbe Attribut zugreifen, bzw. die Methode ohne this-Bezug ausführen
    
    private static int zaehler = 0;
    
    public static int aktuellerZaehler() {
        return zaehler;
    }
}
