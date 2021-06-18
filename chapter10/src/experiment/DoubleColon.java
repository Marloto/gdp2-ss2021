package experiment;

public class DoubleColon {
    public interface Example {
        int abc(int a, int b);
    }
    public int calc(int a, int b) {
        return a + b;
    }
    public int doSomething(Example ex) {
        return ex.abc(30, 12);
    }
    public static void main(String[] args) {
        DoubleColon example = new DoubleColon();
        int calc2 = example.doSomething(example::calc);
    }
}
