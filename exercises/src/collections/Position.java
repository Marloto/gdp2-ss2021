package collections;

import java.util.Arrays;

public class Position implements Comparable<Position> {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Object obj) {
        Position p = (Position) obj;
        return this.x == p.getX() && this.y == p.getY();
    }

    public String toString() {
        return x + "/" + y;
    }

    public static void main(String[] args) {
        Position p1 = new Position(10, 10);
        Position p2 = new Position(10, 15);
        Position p3 = new Position(20, 15);
        Position p4 = new Position(20, 0);
        
        Position[] arr = new Position[] {p1, p2, p3, p4 };
        
        Arrays.sort(arr); // nach eigener Reihenfolge, also Comparable
        Arrays.sort(arr, new PositionNachXUndYComparator());
    }

    @Override
    public int compareTo(Position o) {
        if (this == o) return 0;
        if (o == null) return 1;
        
        int compare = Integer.compare(this.getX(), o.getX());
        if(compare == 0) {
            return Integer.compare(this.getY(), o.getY());
        }
        return compare;
    }
}
