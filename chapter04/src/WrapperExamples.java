public class WrapperExamples {
    public static void main(String[] args) {
        // primitiven Datentypen
        // -> byte short int long float double char boolean
        
        // Klassen -> Datentypen
        
        // Frage: Was der unterschied zw. Variablen von primitiven Datentypen und Variablen von Klassen-Datentypen
        // -> Objekterzeugung für Klassen notwendig
        // -> Klassen Datentypen werden über eine Referenz gespeichert und primitive Datentypen nicht
        // -> "call by copy" hier eine gewisse
        
        // Wrapper-Klassen
        // int und Integer
        // byte und Byte
        // short und Short
        // boolean und Boolean
        
        boolean b1 = true;
        
        // -> Wrapper-Klassen sind daher einfache Klassen jeweils zu den primitiven Datentypen
        // -> nicht zuhause wiederholen :)
        Boolean b2 = new Boolean(true); // byte-größe + header
        
        int i1 = 42;
        Integer i2 = new Integer(0); // int-größe + header
        
        
        // -> Fragen: Warum dann nicht nur mit den Wrapper-Klassen arbeiten?
        // (In etwa könnte das so aussehen)
        // class Boolean {
        //   private boolean value;
        //   ... konstruktor
        //   ... methoden
        // }
        // -> Laufzeit
        // -> Speicher (jedes Attribut innerhalb der Klasse zzgl. header)
        
        // Typische Methoden mit Wrapper-Klassen
        // -> valueOf
        Boolean b3 = Boolean.valueOf("true");
        Boolean b4 = Boolean.valueOf(true);
        
        Integer i3 = Integer.valueOf("42");
        Integer i4 = Integer.valueOf(42);
        
        // Autoboxing / Autounboxing
        Integer i5 = 42; // autoboxing
        int i6 = Integer.valueOf(42); // Returntype ist Integer
        
        // var i = 10; // seit java 10
        // var i = irgendWelche().methoden().miteinander();
    }
}
