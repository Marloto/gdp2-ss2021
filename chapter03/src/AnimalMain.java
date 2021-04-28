
public class AnimalMain {
    public static void main(String[] args) {
        final Dog dog = new Dog("Zoe", 2, "Mischling");
        Cat cat = new Cat("Paul", 5);
        
        //Animal animal = new Animal("Test", 1); geht nicht, weil abstrakt!
        
        Animal animal = dog; // durch Vererbung möglich!
        //int age = animal.humanAge();
        
        // Statische Methoden lassen sich trotz abstract Keyword nutzen
        Animal.doSomethingStatic();
        
        //dog = new Dog("Zoe", 2, "Mischling");
        
        // System.out.println(dog.equals(new Cat("Zoe", 2)));
        
        // (1) instanceof
//        if(dog instanceof Dog) {
//            System.out.println("Der Hund ist ein Hund!");
//        }
//        if(dog instanceof Animal) {
//            System.out.println("Der Hund ist ein Tier!");
//        }
//        if(dog instanceof Object) {
//            System.out.println("Der Hund ist ein Objekt!");
//        }
        
        // (2) Cast / Downcast
        // (3) Super
        // (4) Überschreiben, gilt für statische methoden
        // (5) final -> "finale defintion"
        // -> Klassen: keine weiteren Kinder möglich! String sind finale Klassen
        // -> Methoden: unterbindet das überschreiben von methoden! auch bei statischen methoden
        // -> "Variablen": nicht änderbar!
        //   -> Attributen: spätestens im Konstruktionsprozess müssen Attribute mit final initialisiert
        //   -> Parametern
        //   -> Variablen
        // (6) abstract
    }
}
