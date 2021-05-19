package iteration;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        String[] elements = new String[] {"A", "B", "C"};
        List<String> list = List.of(elements); // schnelle Möglichkeit um eine Liste aus einem Array zu erzeugen

        // ---
//        System.out.println("---");
//        // Wir wissen, wir können So über Arrays iterieren...
//        for(String element : elements) {
//            System.out.println(element);
//        }
//        // ---
//        System.out.println("---");
//        // Wir wissen, wir können So über Listen iterieren...
//        for(String element : list) {
//            System.out.println(element);
//        }
//
//        // Zwei neue Schnittstellen: Iterable und Iterator
//        // ---
//        System.out.println("--- While-Variante");
//        // Zwei neue Schnittstellen: Iterable und Iterator
//        PartialArrayIterator<String> pai = new PartialArrayIterator<>(elements, 1, 2);
//        while(pai.hasNext()) {
//            String element = pai.next();
//            System.out.println(element);
//        }
//        // ---
//        System.out.println("--- For-Variante");
//        for(PartialArrayIterator<String> pai2 = new PartialArrayIterator<>(elements, 1, 2); pai2.hasNext() ;) {
//            System.out.println(pai2.next());
//        }

        // ---
        System.out.println("--- For-Each-SomeDatastructure-Variante");
        SomeDatastructure<String> datastructure = new SomeDatastructure<>(elements);
        for(String element : datastructure) {
            System.out.println(element);
        }

//        Wird übersetzt zu:
//        for(Iterator<String> pai2 = datastructure.iterator(); pai2.hasNext() ;) {
//            String element = pai2.next();
//            System.out.println(element);
//        }

        // ---
//        System.out.println("--- For-Each-SomeDatastructure-Partial-Variante");
//        for(String element : datastructure.partial(0, 100)) {
//            System.out.println(element);
//        }
        
        HashMap<String, String> maps = new HashMap<>();
        // maps.entrySet() -> rückgabedatentyp?
        // maps.keySet()  -> rückgabedatentyp?
        // maps.values()  -> rückgabedatentyp?
        // was passiert da unter der haupe? (grob)
//        Set<String> keySet = maps.keySet();
//        Collection<String> values = maps.values();
//        Iterator<String> iterator = values.iterator();
//        while(iterator.hasNext()) {
//            iterator.next();
//        }
//        
//        Set<Entry<String, String>> entrySet = maps.entrySet();
//        for(Entry<String, String> entry : entrySet) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//        }
    }
}
