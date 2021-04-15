import beispiel.Something;
import beispiel.unterelement.Example;
import static beispiel.unterelement.Example.doSomething;

public class PackageExample {
    public static void main(String[] args) {
        doSomething();
        new Something();
        new Example(); // ohne import wäre es "new beispiel.unterelement.Example()"
    }
}
