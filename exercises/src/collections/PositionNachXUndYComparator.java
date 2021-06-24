package collections;

import java.util.Comparator;

public class PositionNachXUndYComparator implements Comparator<Position> {

    @Override
    public int compare(Position o1, Position o2) {
        if (o1 == o2) return 0;
        if (o1 == null) return -1;
        if (o2 == null) return 1;
        
        int compare = Integer.compare(o1.getX(), o2.getX());
        if(compare == 0) {
            return Integer.compare(o1.getY(), o2.getY());
        }
        return compare;
    }

}
