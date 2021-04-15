
public class StringExperiment {
    public static void main(String[] args) {
        String s1 = "Hallo";
        String s2 = "Hallo";
        String s3 = new String("Hallo");
        
        // Was müsste das Ergebnis basierend auf den aktuellen Kenntnissen sein?
        System.out.println(s1 == s2); // -> false, ist aber true
        System.out.println(s1 == s3); // -> false
        
        // Was wäre zu bevorzugen?
        System.out.println("Hallo".equals(s1)); // A -> zum vermeiden von NullPointerException
        System.out.println(s1.equals("Hallo")); // B -> passt, solange s1 sicher ungleich 
                                                //      null ist
    }
}
