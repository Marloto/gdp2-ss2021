package exceptions;

import java.io.IOException;
import java.util.Map.Entry;

public class Example {
    public Example() {
    }

    private void doSomething() {
        try {
            String value = null;
            value.length();
        } catch (NullPointerException exc) {
            System.out.println("passt immer noch nicht (2)");
            
            String value2 = null;
            value2.length();
        }
    }

    public static void main(String[] args) {
        // 1. Do something forbidden
        // new FileWriter("xyz.log"); -> etwas nach hinten
        // java.lang.NullPointerException
//        String value = null;
//        value.length();

        // java.lang.ArrayIndexOutOfBoundsException
//        String[] elements = new String[0];
//        for (int pos = 0; pos <= elements.length; pos++) {
//            String e = elements[pos];
//        }
        
        // String charAt() von einem index der nicht existiert

        // 2. Call something in methods
        // new Example().doSomething();

        // 3. Catch something -> try-catch
//        try {
//            String value = null;
//            value.length(); // <- hier kommt der fehler!
//            System.out.println("Something!");
//        } catch(NullPointerException exc) {
//            // was soll passieren, wenn!
//            System.out.println("prüf nochmal den code, da stimmt was nicht!");
//        }
//        System.out.println("Weiter... so");

        // 4. StackTrace
//        try {
//            new Example().doSomething();
//        } catch (NullPointerException exc) {
//            System.out.println("passt immer noch nicht (1)");
//        }
        
        // 5. Difference btw. Throwable, Exception, RuntimeException and other
//          try {
//              new Example().doSomething();
//          } catch (NullPointerException exc) {
//              System.out.println("passt immer noch nicht (3)");
//          } catch (ArrayIndexOutOfBoundsException exc) {
//              System.out.println("passt immer noch nicht (4)");
//          }
          try {
              new Example().doSomething();
          } catch (Exception exc) {
              if(exc instanceof ArrayIndexOutOfBoundsException) {
                  System.out.println("passt immer noch nicht (5)");
              }
          }

        // 6. Throw something wrong

        // 7. Define new Exceptions
          
        // 8. Throw & Inheritance

        // 9. Multi Catch

        // 10. Rethrow

        // 11. Try-Catch-Resource / Try-Catch-Closable

    }
}
