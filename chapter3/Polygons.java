abstract class Polygon {
  private String name;
  private Point center;
  public PolygonData(String n, Point c) { name = n; center = c; }
  public String getName()               { return name; }
  public Point getCenter()              { return center; }
  public void draw(Graphics g);
}

class Square {
  public void draw(Graphics g) { ... }
}

class Rectangle {
  public void draw(Graphics g) { ... }
}

class Triangle {
  public void draw(Graphics g) { ... }
}

public void Polygons {
  private  Collection<Polygon> polygons;
  public void paint(Graphics g) {
    for (Polygon p: polygons) {
      p.draw();
    }
  }
}
