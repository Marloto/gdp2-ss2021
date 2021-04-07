// Einmal importieren
import java.util.Scanner;

public class Einlesen {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        //Erzeugen des Scanners zum Einlesen
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Gib etwas ein: ");
        String zeichenkette = scanner.nextLine();
        
        System.out.print("Eine Zahl: ");
        int zahl = scanner.nextInt();
        
        System.out.printf("Eingabe: %s und %d", zeichenkette, zahl);
        
        //System.out.flush();
        
        scanner.close();
        
        int rechnung = 13 + 2;
    }
}
