interface Comparator {
  public int compare(Object x, Object y);
}

class IntegerComparator implements Comparator {
    public int compare(Object x, Object y) {
      return (Integer) x - (Integer) y;
    }
}

class StringComparator implements Comparator {
    public int compare(Object x, Object y) {
       return ((String)x).compareTo((String)y);
    }
}

class StringIgnoreCaseComparator implements Comparator {
    public int compare(Object x, Object y) {
       return ((String)x).compareToIgnoreCase((String)y);
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
  }
}
