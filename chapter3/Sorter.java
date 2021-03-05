interface Comparator {
  public double compare(Object x, Object y);
}

class IntegerComparator implements Comparator {
    public double compare(Object x, Object y) {
      return (Integer) x - (Integer) y;
    }
}

class StringComparator implements Comparator {
    public double compare(Object x, Object y) {
       return ((String)x).compareTo((String)y);
    }
}

class StringIgnoreCaseComparator implements Comparator {
    public double compare(Object x, Object y) {
       return ((String)x).compareToIgnoreCase((String)y);
    }
}

class Vector2D {
    private double x;
    private double y;
    public Vector2D(double x, double y) { this.x = x; this.y = y; }
    public String toString() { return String.format("<%f,%f>", x, y); }
    public double magnitude() { return Math.sqrt(x*x + y*y); }
    public double direction() { return Math.atan(y/x); } // Is this right?
    public static class MagnitudeComparator implements Comparator {
      public double compare(Object x, Object y) {
        return ((Vector2D)x).magnitude() - ((Vector2D)y).magnitude();
      }
    }
    public static class DirectionComparator implements Comparator {
      public double compare(Object x, Object y) {
        return ((Vector2D)x).direction() - ((Vector2D)y).direction();
      }
    }
}

public class Sorter {
  public static void sort(Object[] data, Comparator comp) {
    for (int i=data.length-1; i >= 1; i--) {
      // in each iteration through the loop
      // swap the largets value in data[0]..dta[i] into position i
      int indexOfMax = 0;
      for (int j=1; j <= i; j++) {
        if (comp.compare(data[j], data[indexOfMax]) > 0) {
          indexOfMax = j;
        }
      }
      Object temp = data[i];
      data[i] = data[indexOfMax];
      data[indexOfMax] = temp;
    }
  }
  public static void main(String[] args) {
     String[] strings = {"Leila", "Laska", "Vreni", "Ryan", "Stephanie", "Tony", "Haley"};
     sort(strings, new StringComparator());
     for (String s : strings) System.out.println(s);

     Integer[] integers = {42, 17, 0, -1, 1, 6, 8, 255};
     sort(integers, new IntegerComparator());
     for (int i : integers) System.out.println(i);

     Vector2D[] vectors = { new Vector2D(0,1), new Vector2D(3,4),
                            new Vector2D(-1,-1), new Vector2D(1.5,0) };

     System.out.println("Sorted by magnitude");
     sort(vectors, new Vector2D.MagnitudeComparator());
     for (Vector2D v : vectors) System.out.println(v);

     System.out.println("Sorted by direction");
     sort(vectors, new Vector2D.DirectionComparator());
     for (Vector2D v : vectors) System.out.println(v);
  }
}
