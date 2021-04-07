import java.util.Scanner;

public class Verzweigung {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int zahl = scanner.nextInt();
        
        boolean check = zahl == 42;
        if (check) {
            System.out.println("Antwort richtig!");
        } else if(zahl == 21) {
            System.out.println("Antwort fast richtig");
        } else {
            System.out.println("Antwort falsch");
        }
        
        switch ("aabc") { // datentypen bei Switch?
            case "a":
                System.out.println("Antwort immer noch richtig!");
                break;
            case "c":
                System.out.println("Antwort immer noch fast richtig!");
                break;
            default:
                System.out.println("Antwort immer noch falsch");
        }
        
        
        // Vorsicht: Scope von Variablen!
        int var1 = 12;
        { // einfacher Block
            int var2 = 24;
            var2 += var1;
        }
        // var1 += var2; <- geht nicht
    }

}
