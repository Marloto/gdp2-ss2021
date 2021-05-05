
public enum AmpelZustand {
    // 1. Zeile listet Kommasepariert alle möglichen Zustände
    
    ROT("123"), GELB, GRUEN("xyz"), ROT_GELB("987");
    // 0, 1,    2,      3
    
    private int zufallszahl = 0;
    private String irgendwas;
    
    private AmpelZustand() {
    }
    
    private AmpelZustand(String irgendwas) {
        this.irgendwas = irgendwas;
        this.zufallszahl = (int) Math.random() * 10;
    }
    
    public int getZufallszahl() {
        return zufallszahl;
    }
    
    public void doSomething() {
        System.out.println("Hello, World!");
    }
}
