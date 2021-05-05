package konsolenbeispiel;

// Wie implementiert man die Schnittstelle DatenEinlesen?
public class Person implements DatenEinlesen, DatenAusgeben, Comparable {

    private String name;
    private String email;
    
    public Person() {
    }
    
    // Immer eine Zeichenkette zurückgeben, solange noch
    // was eingelesen werden soll...
    // Wenn nichts einzulesen, dann null!
    public String wasFehltNoch() {
        if(name == null || name.isBlank()) {
            return "Name";
        }
        // Attribut E-Mail ebenso berücksichtigen...
        if(email == null || email.isBlank()) {
            return "E-Mail";
        }
        return null;
    }
    
    public void setzeNaechstenWert(String param) {
        if(name == null || name.isBlank()) {
            this.name = param;
        } else if(email == null || email.isBlank()) {
            this.email = param;
        }
    }
    
    public String[] informationen() {
        String[] liste = new String[2];
        liste[0] = "Name = " + this.name;
        liste[1] = "E-Mail = " + this.email;
        return liste;
    }

    public int compareTo(Object o) {
        // Referentiell prüfen... 
        if(this == o) {
            return 0;
        }
        
        // was wenn o == null
        if(o == null) {
            return 1;
        }
        
        Person p = (Person) o;
        
        // - this == p => 0
        //   -> equals == true
        //   -> oder alle Attribute prüfen die gleich sein sollen
        //   -> überflüssig, geht auch über String.compareTo
        if(this.name.equals(p.name)) {
            return 0;
        }
        
        // Ziel ist this mit o zu vergleichen
        // Wir sollen entscheiden ob:
        // - this < p => -1
        // - this > p =>  1
//        String name = p.name;
//        Comparable c = name;
//        c.compareTo(o)
        return this.name.compareTo(p.name);

        // primitive Daten nicht direkt
        // dafür über Integer.compare(x, y)
    }

}
