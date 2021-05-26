package poly;

class DoSomethingImplementation1 implements DoSomething {
    public void doIt() {
        System.out.println("Hello, World!");
    }
}

class DoSomethingImplementation2 implements DoSomething {
    public void doIt() {
        System.out.println("Hello, Universe!");
    }
}

class DoSomethingImplementation3 implements DoSomething {
    public void doIt() {
        System.out.println("Hello, Other!");
    }
}

public class Hidden {
    public static DoSomething someUnknownProcessToCreateAnObject() {
        double random = Math.random();
        if(random < 0.33) {
            return new DoSomethingImplementation1();
        } else if(random < 0.66) {
            return new DoSomethingImplementation2();
        }
        return new DoSomethingImplementation3();
    }
}
