import java.util.LinkedList;

interface A {}

interface B extends A {}

class Vermoegen implements Comparable<Vermoegen> {
    public int compareTo(Vermoegen o) {
        return 0;
    }
}

class Bankkonto extends Vermoegen implements A {
    public int other;
}

class Wertpapier extends Vermoegen implements B {}

class Immobilie extends Vermoegen {}

class Sparkonto extends Bankkonto {}

class Girokonto extends Bankkonto {
    public int test;
}

class Optionsschein extends Wertpapier {}

class Aktie extends Wertpapier {}

public class Vererbung {
    private static Vermoegen vermoegen;

    public static void doSomething(Vermoegen vermoegen) {
        
    }
    
    public static Vermoegen doOtherthing() {
        return new Girokonto();
    }
    
    public static void main(String[] args) {
        // Substituierbarkeit
        
        // Variablen
        Girokonto konto = new Girokonto();
        Bankkonto konto2 = konto;
        Vermoegen konto3 = konto;
        Object konto5 = konto;

        if(konto5 instanceof Girokonto) {
            Girokonto konto6 = (Girokonto) konto5; // falls in konto5 keine Instanz von Girokonto (oder spezieller)
                                                   // dann ClassCastException!
        }
        
        if(konto2 instanceof Girokonto) {
            Girokonto konto7 = (Girokonto) konto2; // falls in konto2 keine Instanz von Girokonto (oder spezieller)
                                                   // dann ClassCastException!
        }
        
        // Attribute
        vermoegen = konto;
        
        // Parameter
        doSomething(konto);
        doSomething(konto2);
        doSomething(konto3);
        doSomething(new Girokonto()); // wird von Girokonto auf Vermoegen substituiert
        
        // Absicherung durch instanceof mit Downcast
        if(konto5 instanceof Girokonto) {
            doSomething((Girokonto) konto5);
        }
        
        // Rückgaben
        Vermoegen vermoegen1 = doOtherthing();
        Object vermoegen2 = doOtherthing();
        
        // Schnittstellen
        Comparable<Vermoegen> konto4 = konto;
        Comparable<Vermoegen> vermoegen3 = doOtherthing();
        
        // Arrays
        Girokonto[] girokonten = new Girokonto[] { konto };
        Bankkonto[] bankkonten = new Bankkonto[] { konto, konto2 };
        Vermoegen[] vermoegen = new Vermoegen[] { konto, konto2, konto3, (Vermoegen) konto5 };
        
        // Listen, Sets, Maps
        LinkedList<Girokonto> liste1 = new LinkedList<>();
        liste1.add(konto);
        LinkedList<Bankkonto> liste2 = new LinkedList<>();
        liste2.add(konto);
        liste2.add(konto2);
        LinkedList<Vermoegen> liste3 = new LinkedList<>();
        liste3.add(konto);
        liste3.add(konto2);
        liste3.add(konto3);
        
        // Aktie
        Aktie aktie = new Aktie();
        B b = aktie;
        A a = aktie;
        
        
        // Array-Subst.
        Bankkonto[] list = new Bankkonto[] { new Girokonto(), new Girokonto() };
        Vermoegen[] vermList = list;
        Comparable<Vermoegen>[] compList = list;
        A[] aList = list;
        
        // Girokonto[] giroList = (Girokonto[]) list; // geht nicht, da Bankkonto[]-Typ für Instanz verwendet!
        
        for(Bankkonto element : list) {
            if(element instanceof Girokonto) {
                
            }
        }
    }
}
