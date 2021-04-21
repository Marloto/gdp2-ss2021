package otherTest;

public class ChildSamePackage extends Base {
    public ChildSamePackage() {
        // Frage: Was denken Sie ist hier sichtbar?
        // -> private ist nicht zu sehen
        // -> (protected)
        // -> package internal
        // -> public
        // -> alles außer private
        // Frage: was ist sichtbar?
        // -> a, b, c, f(), g(), h()
    }
}
