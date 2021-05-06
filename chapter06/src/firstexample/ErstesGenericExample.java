package firstexample;

// neuer Syntax... Spitze / Eckige Klammern..
// Default <I>: alle Spezialisierungen von Object dürfen übergeben werden!
// Wenn eingrenzen wollen <I extends AudioFile>: Ab dieser Stufe ist es möglich, speziellere Klassen gehen ebenso!
public class ErstesGenericExample<I, W> {
    private I something;
    private W otherthing;

    public ErstesGenericExample(I something) {
        this.something = something;
    }
    
    public W getOtherthing() {
        return otherthing;
    }

    public I getSomething() {
        return something;
    }
}
