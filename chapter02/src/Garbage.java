import java.util.Scanner;

public class Garbage {
    int x;
    
    public Garbage(int value) {
        x = value;
        System.out.println("Created (" + x + ")...");
    }
    
    protected void finalize() throws Throwable {
        System.out.println("Destroyed (" + x + ")...");
    }
    
    static Scanner scanner = new Scanner(System.in);
    public static void test() {
        Garbage g1 = new Garbage(1); // g1 -> z == 1
        Garbage g2 = new Garbage(2); // g2 -> z == 1
        
        System.out.print("Object Created...");
        scanner.nextLine();
        
        System.out.print("Collect garbage (1)...");
        scanner.nextLine();
        System.gc();
        
        System.out.print("Set g1 to null...");
        scanner.nextLine();
        g1 = null; // g1 -> z == 0
        
        System.out.print("Collect garbage (2)...");
        scanner.nextLine();
        System.gc();
    } // g2 -> z == 0
    
    public static void main(String[] args) {
        Garbage g3 = new Garbage(3);
        System.out.print("Start...");
        scanner.nextLine();
        System.out.print("Create Object...");
        scanner.nextLine();
        test();
        
        System.out.print("Collect garbage (3)...");
        scanner.nextLine();
        System.gc();
        
        System.out.print("Wait...");
        scanner.nextLine();
    }
}
