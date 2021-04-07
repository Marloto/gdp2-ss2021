
public class Quadrat3 {
    double seitenLaenge;
    public Quadrat3(double seitenLaenge) {
        this.seitenLaenge = seitenLaenge;
    }
    
    public double keineAhnung(double value) {
        value = 3;
        System.out.println("Ausgabe: " + value);
        return value;
    }
    
    public Quadrat3 vergroessern(Quadrat3 q) {
        q.seitenLaenge = 4.0;
        q = new Quadrat3(5);
        System.out.println("Seitenlaenge von q: " + q.seitenLaenge);
        return q;
    }
    
    public void stringBeispiel(String example) {
        System.out.println(example);
    }

    public static void main(String[] args) {
        Quadrat3 ref1 = new Quadrat3(1.0);
        Quadrat3 ref2 = new Quadrat3(3.0);
        
//        double original = 2.0;
//        ref1.keineAhnung(original);
//        System.out.println("Original: " + original);
        
//        ref2 = ref1.vergroessern(ref2);
//        System.out.println(ref2.seitenLaenge);
//        System.out.println(ref2.seitenLaenge);
        
        String orig = "Test";
        ref2.stringBeispiel(orig);
    }
}
