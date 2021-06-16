package timestamp;
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
        // Frage: wie bisher über alle Einträge der Liste?
        // -> foreach
//        for(String str : messages) {
//            System.out.println(str);
//        }
//        for(int i = 0; i < messages.size(); i ++) {
//            
//        }
        
        
//        Stream<String> stream = messages.stream();
        // Schritt 1 (jetzt mit Sinn :)): Transformation von String mittels
        //   split in String[]
        //   "abc:1234".split(":"); // Ergebnis war String[] -> new String[2]
        //   forEach, filter, map? -> forEach nur, wenn damit das "Ende",
        //     für eine spätere Weiterverarbeitung "map"

        
//        Stream<String[]> splitResult = stream.map(str -> str.split(":"));
        // Schritt 2: erzeugen Sie mit dem String-Array eine Message
        //   -> Long.valueOf
        //   -> Konstruktor im Lambda-Ausdruck verwenden...

//        Stream<Message> messageResult = splitResult.map(strArr -> new Message(Long.valueOf(strArr[0]), strArr[1]));
//        splitResult.map(strArr -> {
//            String[] splitRes = strArr;
//            // Long.valueOf vom ersten String-Element
//            Long timeStamp = Long.valueOf(splitRes[0]);
//            
//            // Konstruktion von Message
//            Message message = new Message(timeStamp, splitRes[1]);
//            
//            // Return
//            return message;
//        });
//        messageResult.forEach(msg -> System.out.println(msg));
        
        messages.stream()
            .map(str -> str.split(":"))
            .map(strArr -> new Message(Long.valueOf(strArr[0]), strArr[1]))
            .forEach(msg -> System.out.println(msg));
        
//        Stream<String> stream = messages.stream();
//        Stream<String> filter = stream.filter(str -> str.startsWith("1581"));
////        Stream<String> filter = stream.filter(new Predicate<String>() {
////            public boolean test(String t) {
////                return t.contains("1851");
////            }
////        }); 
//        // Aufgabe: einfaches Predicate
//        // welches z.B. einen Teil-String sicherstellt, wie "1581"
//        // -> contains, indexOf
//        
//        
//        Stream<Integer> map = filter.map((str) -> Integer.valueOf(str));
//        map.forEach(con -> System.out.println(con));
//        
//        messages.stream()
//            .filter(null)
//            .map((str) -> Integer.valueOf(str))
//            .forEach(con -> System.out.println(con));

//        stream.forEach(new Consumer<String>() {
//            public void accept(String str) {
//                System.out.println(str);
//            }
//        });
//        stream.forEach(con -> System.out.println(con));
    }

}