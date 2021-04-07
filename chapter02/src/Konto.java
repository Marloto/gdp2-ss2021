
class Konto { 
  String nr;
  double kontoStand;
  int geheimzahl;
  
  void zahleEin(double betrag) {
    kontoStand += betrag;
  }
  
  void zahleAus(double betrag) {
    kontoStand -= betrag;
  }
  
  void druckeKontoAuszug() {
    System.out.println("Konto " + nr + 
      ": Kontostand = " + kontoStand);
  }
  
  public static void main(String[] args) {
    // Datentyp = Konto    Variable    die Objekterzeugung
    Konto                  k1 =        new Konto();
    k1.nr = "1234";
    k1.geheimzahl = 1234;
    k1.kontoStand = 1000;
    k1.druckeKontoAuszug();
  }
}
