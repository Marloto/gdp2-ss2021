// package <name1>.<name2>.<name3>. ...
//  -> name1/name2/name3/


// beispiel.Position => Full Qualified Class Name
public class Position {

    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // (2) Getter
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    // (3) toString
    public String toString() {
        return this.x + " / " + this.y;
    }

    // (4) Überprüfung auf Gleichheit
    public boolean equals(Object o) {
        Position p = (Position) o; // <- cast von Object zu Position, vgl. Kapitel 3

        return this.getX() == p.getX() && this.getY() == p.getY();
    }

    // add, sub, mul und div
    // ...

    // dot
    // ...

    // distance
    // ...

//    public Position add(int x, int y) {
//        this.x += x;
//        this.y += y;
//
//        return this;
//    }
    
    // public Position add(int x, int y) {
      public Position add(Position p) {
          return new Position(p.getX() + this.x, p.getY() + this.y);
      }
//      public Position add(Position p) {
//          Position p1 = new Position(0, 0);
//          p1.x = this.x + p.x;
//          p1.y = this.y + p.y;
//          return p1;
//      }
    
    // new Position(10, 5).add(1, 1).add(2, 3)
    // -> 

//    public Position sub(int x, int y) {
//        this.x -= x;
//        this.y -= y;
//
//        return this;
//    }
//
//    public Position mul(int f) {
//        this.x *= f;
//        this.y *= f;
//
//        return this;
//    }
//
//    public Position div(int f) {
//        this.x /= f;
//        this.y /= f;
//
//        return this;
//    }

    public double dot(Position p) {
        return (this.x * p.x) + (this.y * p.y);
    } // <- Hier schauen, Frage, was wäre:
    // Position p = new Position(10, 10);
    // p.dot(p);
    // -> 10 * 10 + 10 * 10
    // -> 10^2 + 10^2

    public double distance(Position p) {
        // Frage: Alternative mit Methoden der Klasse, ohne hier zu rechnen
        // -> sub mul, usw.
        
        // Wurzel(x^2 + y^2)
        //return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
        
        Position result = this.sub(p);
        return Math.sqrt(result.dot(this.sub(p)));
    }

//    public Position add(Position p) {
//
//        Position padd = new Position(p.getX() + this.x, p.getY() + this.y);
//
//        return padd;
//
//    }
//
    public Position sub(Position p) {

        Position psub = new Position(this.x - p.getX(), this.y - p.getY());

        return psub;

    }

    public Position mul(double f) {

        Position pmul = new Position(this.x * f, this.y * f);

        return pmul;

    }

    public Position div(double f) {

        Position pdiv = new Position(this.x / f, this.y / f);

        return pdiv;

    }
//
//    public double dot(Position p) {
//
//        return (this.x * p.getX() + this.y * p.getY());
//
//    }
//
//    public double distance(Position p) {
//
//        return Math.sqrt((this.x - p.getX()) * (this.x - p.getX()) + (this.y - p.getY()) * (this.y - p.getY()));
//
//    }

    public static Position center(Position[] posArr) {
        Position neu = new Position(0, 0);
        for(int i = 0; i < posArr.length; i++) {
            neu = neu.add(posArr[i]);
        }
        Position ergebnis = neu.div(posArr.length);
        return ergebnis;
    }
    
    public static void main(String[] args) {
        // https://pastie.io/huidgb.java

        Position p1 = new Position(10, 10);
        Position p2 = new Position(12, 18);
        Position p3 = new Position(17, 16);
        Position p4 = new Position(14, 8);
        Position p5 = new Position(12, 7);
        
        // Wie könnte ein Positions-Array (für p1, ..., p5) aussehen?
        Position[] posArr = new Position[] { p1, p2, p3, p4, p5 };
        // posArr[0] = p1;
        
        // Frage: wie können wir unter Verwendung der Methoden oben das Zentrum, bzw. den
        // Schwerpunkt ermitteln?
        // -> Summe alle Positionen, anschließend durch die Anzahl der Punkte teilen
        
        Position ergebnis = center(posArr);
        System.out.println(ergebnis);
        
        // -> Versuch des Umfangs
    }
}
