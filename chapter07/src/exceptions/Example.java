package exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;

public class Example {
    public Example() {
    }

    private void doSomething() {
//        try {
            String value = null;
            value.length();
//        } catch (NullPointerException exc) {
//            exc.printStackTrace();
//            System.out.println("passt immer noch nicht (2)");
//            
//            String value2 = null;
//            value2.length();
//        }
    }
    
    // Kommasepariert aufgeführt, was für Exception auftreten können
    private static void doSomethingMore() throws CustomException {
//        if(Math.random() > 0.5) {
//            throw new IOException();
//        } else {
//            throw new ClassNotFoundException();
//        }
        throw new CustomException("Etwas ist passiert!");
    }
    
    private static void doOtherthing() throws SpecialException {
        try {
            doSomethingMore();
        } catch (CustomException e) {
            throw new SpecialException("Causefehler", e);
        }
    }
    
    private static void doOtherthing2() throws SpecialException {
        try {
            doOtherthing();
        } catch (SpecialException e) {
            SpecialException exc = new SpecialException("Causefehler", e);
            throw exc;
        }
    }
    
    private static void doRethrowThing() throws CustomException {
        try {
            doSomethingMore();
        } catch(CustomException exc) {
            System.out.println("Hier spezielle Behandlug...");
            throw exc;
        }
    }
    
    public static void doFinally() throws CustomException {
        try {
            String value = null;
            value.length();
        } catch(NullPointerException exc) {
            throw new CustomException("finally...");
        } finally {
            System.out.println("Finally-Block!");
        }
        System.out.println("Afterwards...");
    }

    public static void main(String[] args) throws CustomException {
        // Wie würden Sie Exception mit eigenen Wort beschreiben, was ist das?
        // -> Klassen die bestimmte Laufzeitfehler beschreiben
        
        // Wir können Exception behandeln, mit z.B. Try-Catch
        // -> Eine Fehlerbehandlung
        // -> Man erklärt dem Programm, was passieren soll, wenn ein bestimmter Fehler auftritt
        // -> ausnahmen die beim ablauf verkommen können
        // -> um kritischen Code zu bearbeiten, und das Programm trotzdem am laufen zu halten
        
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
        
        // "unchecked"-Exception

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
//            exc.printStackTrace(); // bewusstes ausgeben des StackTraces!
//        }
        
        // 5. Difference btw. Throwable, Exception, RuntimeException and other
//          try {
//              new Example().doSomething();
//          } catch (NullPointerException exc) {
//              System.out.println("passt immer noch nicht (3)");
//          } catch (RuntimeException exc) {
//              System.out.println("passt immer noch nicht (4)");
//          }
//          try {
//              new Example().doSomething();
//          } catch (Exception exc) {
//              if(exc instanceof ArrayIndexOutOfBoundsException) {
//                  System.out.println("passt immer noch nicht (5)");
//              }
//          }
          
        // 5.1 finally
//        try {
//            new Example().doSomething();
//        } catch (NullPointerException exc) {
//            System.out.println("passt immer noch nicht (3)");
//            String value = null;
//            value.endsWith(".");
//        } catch (RuntimeException exc) {
//            System.out.println("passt immer noch nicht (4)");
//        } finally {
//            System.out.println("finally"); // nicht ausgeführt!
//        }

        // 6. Throw something wrong
//        doSomethingMore();
//        doOtherthing2();

        // 7. Define new Exceptions
        // siehe 6.
          
        // 8. Throws & Inheritance
        // Warum könnte man in der Kind-Klasse Throws weg lassen?
        // - throws wird immer übernommen?
        // - überladung
//        Special sp = new Special();
//        General ge = sp;
//        ge.doSomething();
        // Faustformel: weniger exception is ok, mehr schlecht!
        // Eingrenzung der Exception über Vererbung möglich!

        // 9. Multi Catch -> seit Java 7
        try {
            doSomethingMore();
            doOtherthing();
        } catch(CustomException | SpecialException exc) {
            
        }
        // Frage: warum nicht einfach "catch(Exception exc)"
        // -> würde diese Variante auch eine NullPointerException fangen?

        // 10. Rethrow
        //  -> werfen von Instanzen auch zw. drin möglich

        // 11. Try-Catch-Resource / Try-Catch-Closable -> Java 7
//        FileWriter fw = null;
//        try {
//            fw = new FileWriter("xyz");
//            fw.write("...");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        
//        try(FileWriter fw2 = new FileWriter("abc")) {
//            fw2.write("...");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // Tipp: Eigene Klasse mit Closable-Implements 
        // und dann in Try-Catch-Resource nutzen
        try {
            doFinally();
        } catch(Exception exc) {
            // ...
        }

    }
}
