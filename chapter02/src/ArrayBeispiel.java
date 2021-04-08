
public class ArrayBeispiel {
    public static void main(String[] args) {
        int x = 0;
        x = 1 + 2;
        
        // -> Datentype "int-Array"
        int[] y;
        y = new int[3]; // <- Üblich, Erklärung
        
        int[] y2 = y;
        //int z[];
        //int []a;
        // Frage: wie war es in C? Zugriff und Erzeugung?
        // -> Zugriff über einen Index
        // -> y[0] = 0;
        // -> float messwerte[3]; messwerte[0] = 23.0;
        y[0] = 0; // es fehlt Initialisierung!
        y[1] = 1;
        y[2] = 42;
        
        double[] defDouble = new double[3]; // 0.0
        boolean[] defBool= new boolean[3]; // false
        String[] defString = new String[3]; // null als default
        ArrayBeispiel[] defArrayBeispiel = new ArrayBeispiel[3]; // null
        
        System.out.println(y[2]);
        //System.out.println(y[3]); // syntax fehler, semantisch
        
        int i = 4;
        int [] y3 = new int[i]; // <- array der länge 4
        
        // Iteration
        // Frage: Wie haben Sie in C über die Einträge eines Arrays iteriert?
        // -> Mit einer Schleife
        /*
         * for (int i = 0; i < SIZE; i++) {
              printf("%u\n", prices[i]);
            }
         * while(Array[i] != '\0') { i++}
         */
        
        int anzahl = y3.length;
        for(int j = 0; j < anzahl; j ++) {
            y3[j] = 21 * j;
        }
        
//        int k = 0;
//        while(k < anzahl) {
//            System.out.println(y3[k]);
//            k ++;
//        }
        
        // for-each
        for(int value : y3) { // geht nicht nur für arrays!
            // geht nicht: value = 0; !
            System.out.println(value);
        }
        
        // Mehrdimensionale Arrays
        int[][] mehrereDim = new int[2][2];
        System.out.println("test");
        
        mehrereDim[0] = y3;
        //mehrereDim[1] = y3;
        //mehrereDim[0] = new int[2];
        
        System.out.println(mehrereDim.length);
        System.out.println(mehrereDim[0].length);
        System.out.println(mehrereDim[1].length);
        
        for(int[] ersteDimension : mehrereDim) {
            for(int wertInZweiteDimension : ersteDimension) {
                System.out.println();
            }
        }
    }
}
