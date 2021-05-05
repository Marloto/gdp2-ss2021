
public class Ampel {
//    Alternativ vielleicht über Int-Statics?
//    public static int ROT = 1;
//    public static int GELB = 2;
//    public static int GRUEN = 3;
//    public static int ROT_GELB = 4;
    // 1 => rot
    // 2 => gelb
    // 3 => gruen
    // 4 => rotgelb
    
    private AmpelZustand zustand;
    
    public AmpelZustand getZustand() {
        return zustand;
    }
    
    public void setZustand(AmpelZustand zustand) {
        this.zustand = zustand;
    }
}
