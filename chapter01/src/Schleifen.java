
public class Schleifen {

    public static void main(String[] args) {
        // while
        // -> min. null mal durchlaufen
        // -> kopf
        
        int i = 0;
        while(i < 10) { // while ausdruck true
            System.out.printf("While %d%n", i);
            i ++;
        }
        
        // do-while
        // -> min. einmal durchlaufen
        // -> fuß
        do {
            System.out.printf("Do-While %d%n", i);
            i ++;
        } while(i < 0);
        
        // for
        // -> zählschleifen
        //for(<startbedingung>;<ausdruck für neuen durchlauf>;<nachbedingung>) {
        for(int j = 0; j < 10; j ++) {
            System.out.printf("For %d%n", j);
        }
    }

}
