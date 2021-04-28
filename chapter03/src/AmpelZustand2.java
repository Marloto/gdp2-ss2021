// Wie könnte ein Aufzählungstyp ohne "enum" aussehen
public class AmpelZustand2 {
    
    public final static AmpelZustand2 ROT = new AmpelZustand2();
    public final static AmpelZustand2 GELB = new AmpelZustand2();
    public final static AmpelZustand2 GRUEN = new AmpelZustand2();
    public final static AmpelZustand2 ROT_GELB = new AmpelZustand2();
    
    private static int counter = 0;
    private int ordinal = 0;
    
    private AmpelZustand2() {
        ordinal = counter ++;
    }

    public void doSomething() {
        System.out.println("Hello, World!");
    }
    
    public static AmpelZustand2[] values() {
        return new AmpelZustand2[] {
                ROT,
                GELB,
                GRUEN,
                ROT_GELB
        };
    }
}
