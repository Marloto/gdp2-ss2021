package otherTest;
public class Base {
  public int a; // ist egal wie von außerhalb sichtbar!
  protected int b;
  int c; // package internal
  private int d; // ist nur innerhalb von base sichtbar
 
  public void f() { System.out.println("Base.f"); }
  protected void g() { System.out.println("Base.g"); }
  void h() { System.out.println("Base.h"); }
  private void k() { System.out.println("Base.k"); }
 
  public static void main(String[] args) {
    Base b2 = new Base();
}
}