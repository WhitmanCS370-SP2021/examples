public interface Comparator {
  public static int compare(Object x, Object y);
}

public class IntegerComparator implements Comparator {
    public static int compare(Object x, Object y) {
      return (Integer) x - (Integer) y;
    }
}

public class StringComparator implements Comparator {
    public static int compare(Object x, Object y) {
       return ((String)x).compareTo((String)y);
    }
}

public class Sorter {
  public static void sort(Object[] data, Comparator comp) {
    for (int i=data.length-1; i >= 1; i--) {
      // in each iteration through the loop
      // swap the largets value in data[0]..dta[i] into position i
      int indexOfMax = 0;
      for (int j=1; j <= i; j++) {
        if (comp.compare(data[j], data[indexOfMax]) > 0)
          indexOfMax = j
      }
      Object temp = data[i];
      data[i] = data[indexOfMax];
      data[indexOfMax] = tmp;
    }
  }
}
