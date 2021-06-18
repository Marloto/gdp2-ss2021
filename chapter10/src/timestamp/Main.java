package timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static Message last = null;

    public static void main(String[] args) {
        List<String> messages = Arrays.asList(
            "1581697831661:Message 1", 
            "1581553746009:Message 2",
            "1588854263313:Message 3", 
            "1589381962905:Message 4", 
            "1589379566771:Message 5");
        handleList(messages);
    }

    public static void handleList(List<String> messages) {
        // Frage: Wie haben wir bisher über alle Einträge einer Liste iteriert?
        // -> foreach oder for mit Zähler
        // -> Beispiel
        // for (String str : messages) {
        //     System.out.println(str);
        // }
        // for (int i = 0; i < messages.size(); i++) {
        //     System.out.println(str);
        // }
        
        //--------
        
        // Alternative: Streams, jeder Eintrag wird als ein "Ereignis" durch
        // eine Kette an Intermediate-Operations verarbeitet und durch eine
        // Terminal-Operation verbraucht
        
        // Einfaches Ausgaben mit Streams:
        // messages.stream().forEach(msg -> System.out.println(msg));
        
        // Beispiel mit Filter:
        // messages.stream()
        //    .filter(t -> t.contains("1851"))
        //    .forEach(msg -> System.out.println(msg));
        
        // Beispiel mit Map:
        // messages.stream()
        //    .map(t -> t.substr(0, 7))
        //    .forEach(msg -> System.out.println(msg));
        
        //--------
        
        // Ziel der Aufgabe: String-Liste verarbeiten und Message-Objekte erzeugen
        // dabei den TimeStamp umwandeln in ein Datum und das Ergebnis filtern
        // Schritt 0: Ergebnis ausgeben mit Terminal-Operation
        // Schritt 1: Transformation von String mittels split in String[]
        // Schritt 2: Erzeugen Sie mit dem String-Array eine Message
        //   -> Long.valueOf
        //   -> Konstruktor im Lambda-Ausdruck verwenden...
        // Schritt 3: Merken Sie sich das letzte Element mit peak vor dem forEach
        // Schritt 4: Filtern Sie so, dass keine "alten" Nachrichten angezeigt werden
        
        messages.stream()
            .map(str -> str.split(":"))
            .map(strArr -> new Message(Long.valueOf(strArr[0]), strArr[1]))
            .filter(msgObj -> last == null || msgObj.getTime() > last.getTime())
            .peek(msgObj -> last = msgObj)
            .forEach(msg -> System.out.println(msg));
        
        // Aufgabe: Formulieren Sie die Datenstromverarbeitung mit herkömmlicher Algorithmik, also ohne 
        // Streams und ohne Lambdas (ca. 5 Minuten).
        
//        List<Message> msgList = new ArrayList<>();
//        for(String msg : messages){
//            String[] strArr = msg.split(":");
//            msgList.add(new Message(Long.valueOf(strArr[0]), strArr[1]));
//        }
//        for (Message message : msgList) {
//            if(last == null || message.getTime() > last.getTime()) {
//                System.out.println(message);
//            }
//            last = message;
//        }
        
        for (String str : messages) {
            String[] strArr = str.split(":");
            Message msg = new Message(Long.valueOf(strArr[0]), strArr[1]);
            if (last == null || msg.getTime() > last.getTime()) {
                last = msg;
                System.out.println(msg);
            }
        }
        
        Message last = null;
        for (String string : messages) {
            String[] strArr = string.split(":");
            Message msg = new Message(Long.valueOf(strArr[0]), strArr[1]);
            
            if (last == null) { // Vorsicht, je nach Aufgabe: was wenn last == null? 
                // hier richtig, falls keine Ausgabe bei last == null
                last = msg;
                System.out.println(msg);
            } else {
                if (msg.getTime() > last.getTime()) {
                    last = msg;
                    System.out.println(msg);
                }
            }
        }
    }

}