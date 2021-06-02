package poly;

import static poly.Hidden.someUnknownProcessToCreateAnObject;

import java.util.LinkedList;
import java.util.List;


interface DoSomething {
    void doIt();
}

public class Poly {
    public int calc(int a, int b) {
        return a + b;
    }
    public double calc(double a, double b) {
        return a + b;
    }
    
    public void func1(Object param) {
        System.out.println("Object...");
    }
    
    public void func1(String param) {
        System.out.println("String...");
    }
    
    public void func1(List<String> param) {
        System.out.println("Liste...");
    }
    
    public static void main(String[] args) {
        // Statische Polymorphie
        Poly poly = new Poly();
        poly.calc(1, 2);
        poly.calc(1.0, 2.0);
        
        Object something = "";
        String otherthing = "";
        poly.func1(something);
        poly.func1(otherthing);
        poly.func1((List) null);
        
        
        
        
        // Dynamische Polymorphie
        DoSomething dos;
        
        dos = someUnknownProcessToCreateAnObject();
        dos.doIt();
    }
}
