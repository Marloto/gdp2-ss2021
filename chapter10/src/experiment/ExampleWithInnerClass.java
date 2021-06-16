package experiment;

public class ExampleWithInnerClass {
    /*
         0: new           #22                 // class experiment/ExampleWithInnerClass$InnerClass
         3: dup
         4: aload_0
         5: invokespecial #24                 // Method experiment/ExampleWithInnerClass$InnerClass."<init>":(Lexperiment/ExampleWithInnerClass;)V
         8: astore_1
         9: aload_1
        10: invokeinterface #27,  1           // InterfaceMethod java/lang/Runnable.run:()V
        15: return
     */
    public void doSomething() {
        Runnable innerClass = new InnerClass();
        innerClass.run();
    }
    
    public InnerClass createObject() {
        return new InnerClass();
    }
    
    public class InnerClass implements Runnable {
        public void run() {
            System.out.println("Hello!");
            // Zugriff auf umschließende Klasse
            ExampleWithInnerClass.this.createObject();
        }
        
        public class MoreInnerClass implements Runnable {
            public void run() {
                System.out.println("Hello!");
                // Zugriff auf umschließende Klasse
                ExampleWithInnerClass.this.createObject();
                ExampleWithInnerClass.InnerClass.this.run();
            }
        }
    }
    
    public static void main(String[] args) {
        new ExampleWithInnerClass().doSomething();
    }

}
