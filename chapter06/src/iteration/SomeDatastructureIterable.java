package iteration;

import java.util.Iterator;

public class SomeDatastructureIterable<T> implements Iterable<T> {

    private T[] elements;
    private int offset;
    private int max;

    public SomeDatastructureIterable(T[] elements, int offset, int max) {
        this.elements = elements;
        this.offset = offset;
        this.max = max;
    }
    
    public Iterator<T> iterator() {
        return new PartialArrayIterator<>(elements, offset, max);
    }

}
