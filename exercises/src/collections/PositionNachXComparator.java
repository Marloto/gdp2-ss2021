package collections;

import java.util.Comparator;

public class PositionNachXComparator implements Comparator<Position> {

    @Override
    public int compare(Position o1, Position o2) {
        // 1. prüfen identische referenzen
        // if (o1 == o2) return 0;
        
        // 2. o1 auf null prüfen 
        // if (o1 == null) return -1;
        
        // 3. o2 auf null prüfen 
        // if (o2 == null) return 1;
        
        // 4. fortfahren mit o1 != null und o2 != null
        
//        return Integer.compare(o1.getX(), o2.getX());
        
//        return Integer.valueOf(o1.getX()).compareTo(o2.getX());
        
        // Autoboxing und Cast
        return ((Integer) o1.getX()).compareTo(o2.getX());
        
//        if (o1 != null) {
//            if (o2 != null) {
//                return o1.getX() - o2.getX();
//            } else {
//                return -1;
//            }
//        } else {
//            if (o2 != null) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
    }
    
    
    // Implementieren Sie einen Comparator für die Klasse
    // Position und sortieren Sie nach x
}
