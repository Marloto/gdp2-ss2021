package iteration;

import java.util.Iterator;

public class SomeDatastructure<T> implements Iterable<T> {
    private T[] elements;
    
    public SomeDatastructure(T[] elements) {
        this.elements = elements;
    }
    
    public Iterable<T> partial(int offset, int max) {
        return new SomeDatastructureIterable<>(elements, offset, max);
    }

    public Iterator<T> iterator() {
        return new PartialArrayIterator<>(elements, 0, elements.length);
    }
}
