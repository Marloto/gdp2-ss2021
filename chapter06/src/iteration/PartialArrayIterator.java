package iteration;

import java.util.Iterator;

// implementieren Sie die Schnittstelle java.util.Iterator
public class PartialArrayIterator<T> implements Iterator<T> {
    
    private T[] elements;
    private int position;
    private int max;
    
    /**
     * new PartialArrayIterator(new String[]{"a", "b", "c"}, 1, 2); -> b
     * for(int i = 1; i < 2 && i < elements.length; i ++) {
     *      String element = elements[i];
     * }
     * 
     * new PartialArrayIterator(new String[]{"a", "b", "c"}, 0, 2); -> a, b
     * for(int i = 0; i < 2 && i < elements.length; i ++)
     * 
     * new PartialArrayIterator(new String[]{"a", "b", "c"}, 0, 3); -> a, b, c
     * for(int i = 0; i < 3 && i < elements.length; i ++)
     * 
     * new PartialArrayIterator(new String[]{"a", "b", "c"}, 0, 100); -> a, b, c
     * for(int i = 0; i < 100 && i < elements.length; i ++)
     */
    
    public PartialArrayIterator(T[] elements, int offset, int max) {
        this.elements = elements;
        this.position = offset;
        this.max = max;
    }
    
    public boolean hasNext() {
        // gibt es noch ein weiteres element?
        return position < max && position < elements.length;
    }
    
    public T next() {
        // das nächste zurückgeben, zzgl. "eins weiter schieben"
        int p = position;
        position += 1;
        return elements[p];
        //Alternativ: return this.elements[position ++];
    }
}
