package collections;

import java.util.Iterator;

public class RandomGenerator implements Iterable<Double> {
    

    @Override
    public Iterator<Double> iterator() {
        int anzahl = 10;
        
        return new Iterator<Double>() {
            int pointer = 0;
            
            @Override
            public boolean hasNext() {
                return pointer < anzahl; // while Bedingung
            }

            @Override
            public Double next() {
                pointer ++; // Zustandsveränderung in der Schleife
                return Math.random(); // Wert je Schleifen-Durchlauf
            }
        };
    }
    
    public static void main(String[] args) {
        for(Double d : new RandomGenerator()) {
            System.out.println(d);
        }
        
    }
    
}
