public class Wrapper {
    public static void main(String[] args) {
//        if(10 == Integer.valueOf(10)) {
//            System.out.println("int(10) gleich Integer(10)");
//        }
        
        Integer i3 = Integer.valueOf(10);
        Integer i4 = Integer.valueOf(10);
        // irgendwas passiert intern, dass bei gleichen int-Werten die selbe instanz kommt
        if(i3 == i4) {
            System.out.println("Integer(10) gleich Integer(10) (mit valueOf)");
        }

        Integer i5 = new Integer(10);
        Integer i6 = new Integer(10);
        if(i5 == i6) {
            System.out.println("Integer(10) gleich Integer(10) (mit new)");
        }

//        if(10000 == Integer.valueOf(10000)) {
//            System.out.println("int(10000) gleich Integer(10000)");
//        }
        
        Integer i9 = Integer.valueOf(10000);
        Integer i10 = Integer.valueOf(10000);
        if(i9 == i10) {
            System.out.println("Integer(10000) gleich Integer(10000)");
        }
    }
}
