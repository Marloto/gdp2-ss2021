import java.util.Scanner;

public class Quadrat4 {
    double seitenLaenge;
    
    public Quadrat4(double seitenLaenge) {
        this.seitenLaenge = seitenLaenge;
    }
    
    protected void finalize() throws Throwable {
        System.out.println("Zerstoerung von " + this.seitenLaenge);
    }
    
    public static void main(String[] args) {

        Quadrat4 ref1 = new Quadrat4(1.0); // object1 -> z == 1 
        Quadrat4 ref2; // keine einfluss 
        
        ref2 = ref1; // object1 -> z == 2
        
        ref1 = null; // object1 -> z == 1
                
        ref2 = null; // object1 -> z == 0
        
        System.gc(); // auslösen des Garbage Collectors, in produktiv Systemen
        // niemals machen!
        
        // verhindern, dass sich die VM beendet
        new Scanner(System.in).nextLine();
    }

}
