// Exercise 4.14, p. 123
public class B {
  private int x = 0;

  public B(int x) { 
    this.x = x; 
  }

  public boolean equals(Object obj) {
    if (obj == null)                       return false;
    if (obj.getClass() != this.getClass()) return false;
    if (!super.equals(obj))                return false;

    B b = (B)obj;
    return this.x == b.x;
  }

  public static void main(String args[]) {
    B b1 = new B(1);
    B b2 = new B(1);
    System.out.println(b1.equals(b2));
  }
}
