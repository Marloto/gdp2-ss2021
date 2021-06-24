package collections;

import java.util.Iterator;

public class PositionsIterator implements Iterator<Position> {
    
    private Positions positions;
    private int pointer;

    public PositionsIterator(Positions positions) {
        this.positions = positions;
        this.pointer = 0;
    }

    @Override
    public boolean hasNext() {
        // Beantworte die Frage, ob es ein weiteres Element
        // in der Iterationsmenge gibt
        Position[] ps = this.positions.getPositions();
        return this.pointer < ps.length;
    }

    @Override
    public Position next() {
        // Das aktuelle Element (z.B. über pointer)
        // zurückgeben UND den pointer verändern
        // ... würde das nicht passieren
        //     entsteht eine Endlositeration
        Position[] ps = this.positions.getPositions();
        return ps[this.pointer ++];
    }

}
