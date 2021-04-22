
// Superklasse... auch wenn wir das nicht wollen!
public class Animal extends Object {
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
    
    public static void main(String[] args) {
        
    }
}
