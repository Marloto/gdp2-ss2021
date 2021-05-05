package konsolenbeispiel;

public class Animal implements DatenIo {

    private String name;
    private int alter;
    
    public Animal() {
        alter = -1;
    }

    public String wasFehltNoch() {
        if(name == null || name.isBlank()) {
            return "Tiername";
        }
        if(alter == -1) {
            return "Tieralter";
        }
        return null;
    }

    public void setzeNaechstenWert(String param) {
        if(name == null || name.isBlank()) {
            this.name = param;
        } else if(alter == -1) {
            this.alter = Integer.parseInt(param); // String zu int?
        }
    }

    @Override
    public String[] informationen() {
        String[] information = new String[2];
        information[0] = "Tiername = " + this.name;
        information[1] = "Tieralter = " + this.alter;
        return information;
    }

}