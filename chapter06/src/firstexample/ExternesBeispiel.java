package firstexample;

public class ExternesBeispiel {
    public static void main(String[] args) {
        ErstesGenericExample<String, String> var1 = new ErstesGenericExample<String, String>(""); // was ist ??? in diesem Fall, z.B. String!
        String something = var1.getSomething();
        
        ErstesGenericExample<Object, String> var2 = new ErstesGenericExample<Object, String>(new Object());
        Object something2 = var2.getSomething();
    }
}
