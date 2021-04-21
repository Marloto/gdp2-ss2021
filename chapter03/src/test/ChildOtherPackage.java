package test;

import otherTest.Base;

public class ChildOtherPackage extends Base {
    public ChildOtherPackage() {
        // Frage: ist jedenfall? public!
        // Frage: nicht sichtbar? private!
        // Frage: was ist noch sichtbar?
        // -> protected ist sichtbar
        // -> internal nicht!
        // Frage: was ist sichtbar?
        // -> a, b, f, g
    }
}
