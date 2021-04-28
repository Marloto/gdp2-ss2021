
// Superklasse Object... auch wenn wir das nicht wollen!
// Abstrakte Klassen sind nicht instanzierbar!
public abstract class Animal extends Object {
    // eine Dog Klasse
    // und eine Cat Klasse ...
    // Erben die Cat und Dog Klassen von Animal
    
    private final String name;
    private int age;
    
    protected int example;
    
    // Aufgabe: Konstruktoren definieren
    // -> Animal benötigt name und age
    // -> Cat passenden Konstruktor erstellen
    // -> Dog entsprechenden wie Cat zzgl. breed
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Überschreiben ist wenn Methoden
    // der selben Signatur aus der
    // Vererbunghierarchy überschrieben werden
    public boolean equals(Object obj) {
        if(obj instanceof Animal) {
            Animal animal = (Animal) obj;
            return this.name.equals(animal.name) && 
                    this.age == animal.age;
        }
        return false;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    // -----
    // Aufgabe: Ergänzen Sie eine einfache
    // abstrakte Methoden void makeSound()
    // und implementieren Sie diese in Cat
    // und Dog. (ca. 5 Minuten)
    // -----
    // Frage: was für Sichtbarkeiten sind möglich?
    public abstract void makeSound();
    
    
    // Abstrakte Methoden sind noch nicht voll
    // implementiert, Methodenkörper fehlt!
    public abstract int humanAge();
    
    // Mehr Methoden gehen auch:
    // public abstract void doSomething();
    // public abstract void doOtherthing();
    
    public static void doSomethingStatic() {
        
    }
}
