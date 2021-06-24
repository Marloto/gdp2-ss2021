package collections;

import java.util.Iterator;

public class RandomGenerator implements Iterable<Double> {

    @Override
    public Iterator<Double> iterator() {
        // 10 zufallszahlen 
        int pointer = 0;
        int anzahl = 10;
        
        // Math.random();
        
        return new Iterator<Double>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Double next() {
                return null;
            }
        };
    }
    
}
