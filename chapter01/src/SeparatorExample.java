
public class SeparatorExample {
    public static void main(String[] args) {
        char sep = java.io.File.separatorChar;
        System.setProperty("file.separator", "\\");
        String separatorString = System.getProperty("file.separator");
        char separatorChar = System.getProperty("file.separator").charAt(0);
        System.out.println(sep);
        System.out.println(separatorString);
        System.out.println(separatorChar);
        
//        String name = System.getProperty("os.name");
//        String nameInLowerCase = name.toLowerCase();
//        
//        System.out.println(name);
//        System.out.println(nameInLowerCase);
//        // Ergebnis bei Ihnen im System?
//        // -> Windows 10, wenn windows 11
//        // -> Mac OS X
//        // -> Linux
//        
//        int position = nameInLowerCase.indexOf("win"); // -1 wenn nicht gefunden, andernfalls >= 0
//        System.out.println(position);
//        // System.out.println(name.indexOf("Win"));
//        if(position >= 0) {
//            System.out.println("Ist Windows");
//        } else {
//            System.out.println("Ist kein Windows");
//        }
          if(isWindows()) {
              System.out.println("Ist Windows");
          } else {
              System.out.println("Ist kein Windows");
          }
    }
    
    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().indexOf("win") >= 0;
    }
}
