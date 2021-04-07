


public class Methoden {

    public static int rechne2(int a, int b) {
        int ergebnis = a - b;
        return ergebnis;
    }

    public static int rechne(int a, int b) {
        int ergebnis = a + b;
        return ergebnis;
        
        // return a + b;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int ergebnis = rechne(2, 4);
        System.out.println(ergebnis);
    }

}
