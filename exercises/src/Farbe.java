import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Farbe {
    private int rot;
    private int gruen;
    private int blau;

    public Farbe(int rot, int gruen, int blau) {
        this.rot = rot;
        this.gruen = gruen;
        this.blau = blau;
    }

    public int getRot() {
        return rot;
    }

    public int getBlau() {
        return blau;
    }

    public int getGruen() {
        return gruen;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + blau;
        result = prime * result + gruen;
        result = prime * result + rot;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Farbe other = (Farbe) obj;
        if (blau != other.blau)
            return false;
        if (gruen != other.gruen)
            return false;
        if (rot != other.rot)
            return false;
        return true;
    }

    public static void main(String[] args) {
        String[] tokens = new String[] { 
                "rot", "255", "0", "0", 
                "weiss", "255", "255", "255", 
                "türkis", "0", "255", "255", 
                "orange", "255", "165", "0", 
                "grau", "128", "128", "128"
        };
        Map<Farbe, String> map = verarbeiten(tokens);
        ausgeben(map);
    }

    private static Map<Farbe, String> verarbeiten(String[] tokens) {
        // Was ist das Ziel, was muss "Algorithmisch" gemacht werde?
        // -> Token iterieren
        // -> neue Farb-Instanzen erstellen
        // -> Welche Art der Iteration (bzw. wie)
        //    for-Schleife
        // -> (Maps umgehen können)
        
        // farbe = new Farbe() mit jeweils "255", "0", "0"
        // Map hinzufügen (farbe, "rot")
        
        Map<Farbe, String> map = new HashMap<>();
        for(int i = 0; i < tokens.length; i += 4) {
            // 1. Durchlauf: 0
            // 2. Durchlauf: 4
            // n. Durchlauf: Vielfaches von 4
            // Mit Index Rechnen und die 4 Informationen aus dem Array ziehen
            String name = tokens[i];
            int rot = Integer.parseInt(tokens[i + 1]);
            int gruen = Integer.parseInt(tokens[i + 2]);
            int blau = Integer.parseInt(tokens[i + 3]);
            Farbe farbe = new Farbe(rot, gruen, blau);
            map.put(farbe, name);
            
            map.put(new Farbe(
                    Integer.parseInt(tokens[i + 1]), 
                    Integer.parseInt(tokens[i + 2]), 
                    Integer.parseInt(tokens[i + 3])), tokens[i + 0]);
        }
        
//        for(int i = 0; i < tokens.length / 4; i ++) {
//            map.put(new Farbe(
//                    Integer.parseInt(tokens[i * 4 + 1]), 
//                    Integer.parseInt(tokens[i * 4 + 2]), 
//                    Integer.parseInt(tokens[i * 4 + 3])), 
//                tokens[i * 4]);
//        }
        
        return map;
    }
    
    public static class FarbComparator implements Comparator<Farbe> {
        public int compare(Farbe f1, Farbe f2) {
            if (f1 == f2 || (f1 == null && f2 == null)) {
                return 0;
            }
            if (f1 != null && f2 == null) {
                return -1;
            }
            if (f1 == null && f2 != null) {
                return 1;
            }
            if (f1.getRot() != f2.getRot()) {
                return f1.getRot() - f2.getRot();
            }
            if (f1.getGruen() != f2.getGruen()) {
                return f1.getGruen() - f2.getGruen();
            }
            return f1.getBlau() - f2.getBlau();
        }
    }


    private static void ausgeben(Map<Farbe, String> map) {
        // Was ist das Ziel, was muss "Algorithmisch" gemacht werde?
        // -> Es sind die Schlüssel notwendig, map.keySet()
        // -> Wichtiger Schritt: Set nicht Sortierbar, 
        //    Umwandlung in Liste notwendig!
        
        // Beziehen der Keys
        Set<Farbe> keySet = map.keySet();
        
        // Wie bekommen wir daraus eine Liste?
        List<Farbe> sortable1 = new ArrayList<>(keySet);
        
        // Manueller Weg?
        List<Farbe> sortable2 = new ArrayList<>();
        for(Farbe farbe : keySet) {
            sortable2.add(farbe);
        }
        
        // Streams
        List<Farbe> sortable3 = keySet.stream().collect(Collectors.toList());
        
        // Sortieren?
        Collections.sort(sortable1, new FarbComparator());
        // sortable1.sort(new FarbComparator());
        
        // Finale Ausgabe?
        for(Farbe farbe : sortable1) {
            String name = map.get(farbe);
            System.out.println(farbe.getRot() + "," + 
                    farbe.getGruen() + "," + 
                    farbe.getBlau() + " = " + name);
        }
        
        
        
        

//        Set<Farbe> keySet = map.keySet();
//        List<Farbe> sortable1 = new ArrayList<>(keySet);
//        Collections.sort(sortable1, new FarbComparator());
//        for(Farbe farbe : sortable1) {
//            String name = map.get(farbe);
//            System.out.println(farbe.getRot() + "," + farbe.getGruen() + "," + farbe.getBlau() + " = " + name);
//        }
        
//        map.keySet()
//            .stream()
//            .sorted(new FarbComparator()).forEach(farbe -> 
//                System.out.println(farbe.getRot() + "," + 
//                        farbe.getGruen() + "," + 
//                        farbe.getBlau() + " = " + map.get(farbe))
//        );
    }
}