package test;

import otherTest.Base;

public class MainOtherPackage {
    public static void main(String[] args) {
        // Frage: Was sollte ist für Base sichtbar?
        // -> nur noch public
        Base b3 = new Base();
        // Frage: was ist sichtbar?
        //b3.a
        //b3.f()
    }
}
