import java.util.Scanner;

public class StringExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String schema = "",
				nutzer = "",
				kennwort = "",
				host = "",
				port = "",
				pfad = "",
				query = "",
				fragment = "";

		// https://googe.de
	    // https://www.zdf.de
	    // https://thi.de
		// http://localhost:1948/chapter02.md#/10/11
	    // <schema>://[<nutzer>[:<passwort>]@]<domain>[:<port>][/<pfad>][?<query>][#<fragment>]
	    
	    // -> alles vor dem :// herausnehmen
		// -> substring bis index vom ersten :
		
		// charAt -> liefert zeichen an position
		// -> input.charAt(0)
		
		// indexOf -> findet Position von Zeichenkette
		int positionVonSchema = input.indexOf("://");
		if(positionVonSchema >= 0) {
		    //System.out.println(positionVonSchema);
		    String teil = input.substring(0, positionVonSchema);
		    input = input.substring(positionVonSchema + 3);
		    //System.out.println(teil);
		    //System.out.println(input);
		    schema = teil;
		}
		
		int positionNutzer = input.indexOf("@");
		if(positionNutzer >= 0) {
		    String teil = input.substring(0, positionNutzer);
		    // <nutzer>:<passwort>
		    // split
		    String[] parts = teil.split(":"); // -> new String[] {"nutzer", "passwort"}
		    if(parts.length == 1) {
		        nutzer = parts[0];
		    } else if(parts.length == 2) {
		        nutzer = parts[0];
		        kennwort = parts[1];
		    }
		    input = input.substring(positionNutzer + 1);
		}
		
		// replace
		// -> reguläre Ausdrücke nach Möglichkeit vermeiden
//		input.replace("abc", "xyz"); // "abcabc" -> "xyzabc"
		// replaceAll
//		input.replace("abc", "xyz"); // "abcabc" -> "xyzxyz"
		// alternativ:
		//   iteration + charAt -> Austausch und neuen String erzeugen
		
		// substring -> liefert Teil eines String
//		input.substring(5);
//		input.substring(0, 5); // [0,5)
		// http://localhost:1948/chapter02.md#/10/11
		// -> (1) ttp://localhost:1948/chapter02.md#/10/11
		// -> (5) //localhost:1948/chapter02.md#/10/11
		// -> (0, 5) http:
		
		// Verarbeite Fragment, Query, Pfad und Host:Port gemeinsam
        // in umgekehrter Reihenfolge
        if (input.length() > 0) {
            // Pruefe ob es ein Fragment gibt, und verarbeite
            int fragmentBegin = input.indexOf('#');
            if (fragmentBegin != -1) {
                fragment = input.substring(fragmentBegin + 1);
                input = input.substring(0, fragmentBegin);
            }
            // Pruefe ob es einen Query-Part gibt, und verarbeite
            int queryBegin = input.indexOf('?');
            if (queryBegin != -1) {
                query = input.substring(queryBegin + 1);
                input = input.substring(0, queryBegin);
            }
            // Pruefe ob es einen Pfad gibt, und verarbeite
            int pfadBegin = input.indexOf('/');
            if (pfadBegin != -1) {
                pfad = input.substring(pfadBegin + 1);
                input = input.substring(0, pfadBegin);
            }
            // Der Rest ist Host:Port, Fehler wenn dem nicht so!
            if (input.length() > 0) {
                String[] hostParts = input.split(":");
                if (hostParts.length > 0) {
                    host = hostParts[0];
                }
                if (hostParts.length > 1) {
                    port = hostParts[1];
                }
            }
        }
		
		System.out.printf(
				"URL(\n  schema = %s,\n  nutzer = %s,\n  kennwort = %s,\n  host = %s,\n  "+
				"port = %s,\n  pfad = %s,\n  query = %s,\n  fragment = %s\n)\n",
				schema, nutzer, kennwort, host, port, pfad, query, fragment);
	}
}



//// Import -> Existing Maven Project -> Browse -> Extrahierten Ordner auswählen
//String example = new String();
//
//// byte[] beispiel = new byte[] {1, 2, 3}; 
//// -> erzeugt ein Array der länge 3 mit werten
//
//// String example2 = new String(new byte[] {96, 97, 98 });
//// -> nicht schön :)
//
//String example3 = "abc";
//String example4 = "abc";
//
//// example -> object -> reference
//// == vergleiche der referenzen
//// referenzieren example3 und 4 auf das selbe objekt!
////if (example3 == example4) { // false
////  
////}
//// equals -> Methode zum Vergleichen
//// "abc" == "abc"
//if(example3.equals(example4)) {
//    
//}
//
//int anzahlDerZeichen = example3.length();