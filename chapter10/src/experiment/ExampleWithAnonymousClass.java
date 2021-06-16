package experiment;

public class ExampleWithAnonymousClass {
    /*
         0: new           #15                 // class experiment/ExampleWithAnonymousClass$1
         3: dup
         4: aload_0
         5: invokespecial #17                 // Method experiment/ExampleWithAnonymousClass$1."<init>":(Lexperiment/ExampleWithAnonymousClass;)V
         8: astore_1
         9: aload_1
        10: invokeinterface #20,  1           // InterfaceMethod java/lang/Runnable.run:()V
        15: return
     */
    
    public interface Example {
        int calc(int a);
    }
    
    public void doSomething() {
        Runnable run = new Runnable() {
            public void run() {
                System.out.println("Hello!");
            }
        };
        Example ex = new Example() {
            public int calc(int a) {
                return a + 1;
            }
        };
        
        run.run();
    }
    
    public static void main(String[] args) {
        new ExampleWithAnonymousClass().doSomething();
    }
}
