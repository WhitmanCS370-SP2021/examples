import java.awt.Point;
import java.awt.Color;

class Triangle {
  Point p1, p2, p3;
  public Triangle(Point p1, Point p2, Point p3) {
    this.p1 = p1; this.p2 = p2; this.p3 = p3;
  }
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (obj.getClass() != this.getClass()) return false;
    Triangle other = (Triangle)obj;
    return (p1.equals(other.p1) && p2.equals(other.p2) && p3.equals(other.p3));
  }
  public String toString() {
    return "Triangle:" + p1.toString() + p2.toString() + p3.toString();
  }
}

class ColoredTriangle extends Triangle {
  Color color;
  public ColoredTriangle(Point p1, Point p2, Point p3, Color c) {
    super(p1,p2,p3); this.color = c;
  }
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (obj.getClass() != this.getClass()) return false;
    if (!super.equals(obj)) return false;
    ColoredTriangle other = (ColoredTriangle)obj;
    return this.color.equals(other.color);
  }
}

class Triangles {
  public static void main(String args[]) {
    Triangle[] tri = new Triangle[3];
    tri[0] = new Triangle(new Point(0,3),new Point(4,0), new Point(4,3));
    tri[1] = new Triangle(new Point(0,3),new Point(4,0), new Point(4,3));
    tri[2] = new ColoredTriangle(new Point(0,3), new Point(4,0), new Point(4,3),
                                 Color.RED);

    for (Triangle t1 : tri) {
      System.out.println(t1);
      for (Triangle t2 : tri) {
        System.out.println(t1.equals(t2));
      }
    }
  }
}
