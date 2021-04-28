//public class SingletonExample {
//    
//    private static SingletonExample obj = new SingletonExample();
//    
//    private SingletonExample() {
//
//    }
//
//    public static SingletonExample returnObject() {
//        return obj;
//    }
//}

class SuperSingleton {
    protected SuperSingleton() {
        
    }
}

public class SingletonExample extends SuperSingleton {

    private static SingletonExample instance;
    
    

    private static void SingletonExample() {
        //super();
    }

    // Reflektieren Sie das mit Kapitel 11 später
    static SingletonExample getInstance() {
        if (instance != null)
            instance = new SingletonExample();
        return instance;
    }

}