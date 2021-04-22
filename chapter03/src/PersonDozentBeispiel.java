
class Person {
    private String name;
    // Default-Konstruktoren
    public Person() { // hinweis: andere sprachen ggf. anderer Syntax, UML noch schwieriger
        this("Unbekannt");
        System.out.println("Person-Default");
    }
    // Konstruktorenverkettung
    public Person(String name) {
        this.name = name;
        System.out.println("Person-Mit-Parameter");
    }
}

class ZwischenKlasse extends Person {
    public ZwischenKlasse() {
        super();
    }
    public ZwischenKlasse(String name) {
        super(name);
    }
    
}

class Dozent extends ZwischenKlasse {
    // Default Konstruktor ist möglich
//    public Dozent() {
////        super(); // Schlüsselwort für morgen!
//        // automatisch den Default-Konstruktor von Person aufruft...
//        System.out.println("Dozent wird erzeugt!");
//    }
}

public class PersonDozentBeispiel {
    public static void main(String[] args) {
        Dozent dozent = new Dozent();
    }
}
