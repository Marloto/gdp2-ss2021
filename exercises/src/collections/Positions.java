package collections;

import java.util.Iterator;

public class Positions implements Iterable<Position> {
    
    private Position[] positions;
    
    public Positions(Position[] positions) {
        this.positions = positions;
    }
    
    public Position[] getPositions() {
        return positions;
    }
    
    public static void main(String[] args) {
        Position p1 = new Position(10, 10);
        Position p2 = new Position(10, 15);
        Position p3 = new Position(20, 15);
        Position p4 = new Position(20, 0);
        
        Position[] arr = new Position[] {p1, p2, p3, p4 };
        
        Positions positions = new Positions(arr);
        
        for(Position p : positions) {
            
        }
        
        //vs.
        
        Iterator<Position> iterator = positions.iterator();
        while(iterator.hasNext()) {
            Position next = iterator.next();
            // ... das was im Body von for-each
        }
    }

    public Iterator<Position> iterator() {
        return null;
    }

}
