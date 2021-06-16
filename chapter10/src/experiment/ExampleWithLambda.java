package experiment;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ExampleWithLambda {
    /*
         0: invokedynamic #22,  0             // InvokeDynamic #0:run:()Ljava/lang/Runnable;
         5: astore_1
         6: aload_1
         7: invokeinterface #26,  1           // InterfaceMethod java/lang/Runnable.run:()V
        12: return
     */
    public void doSomething() {
        //   <parameterliste> -> <block> | <ausdruck>
        Runnable run = () -> {
            if(true) {
                System.out.println("Hello!");
            }
        };
        
        // Ergebnis des Ausdrucks wird automatisch
        // zurückgegeben
        Example2 ex1 = x -> x + 1; // repräsentiert Example.calc
        Example2 ex2 = (x) -> x + 1;
        Example2 ex3 = (x) -> {
            return x + 1;
        };
        
        Example ex4 = ex1;
        
        ex1.calc(2);
        
        Object obj = (Example) (x -> x + 1);
        
        // Comparator vs. Comparable
        Comparator<String> somethingToSort = (o1, o2) -> {
            // wie zu sortieren ist...
            return 0; // -1 od. +1
        };
        
        // f(x) => y
        // g(x) => true | false
        // h(x, y) => z
        
        Predicate<String> ex5Predicate = (str) -> str.contains("a");
        Consumer<String> ex6Consum = (str) -> System.out.println(str);
        
        ex5Predicate.test("abc");
        ex6Consum.accept("abc");
        
        run.run();
    }
    

    public interface Example {
        int calc(int a);
    }
    
    public interface Example2 extends Example {
        
    }

    public static void main(String[] args) {
        new ExampleWithLambda().doSomething();
    }
}
