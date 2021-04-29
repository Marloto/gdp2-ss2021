
public class ThisExample {
    
    private double abc;

    public ThisExample(double abc) {
        this.abc = abc;
        // this.parsePathname()
    }
    
    // parsePathname
    //  -> this.pname = ...
    
    public double getSomething() {
        return 2;
    }
    
    public void doSomething() {
        this.getSomething();
        System.out.println("Wert: " + this.abc);
         // this.pAuthor = ""; sichtbarkeit (protected?), final
    }
    
    public static void main(String[] args) {
        // new ThisExample() => Objekt Erzeugung
        ThisExample e1 = new ThisExample(42.0);
        
        ThisExample e2 = new ThisExample(21.0);

        e1.doSomething();
        e2.doSomething();
    }
}
