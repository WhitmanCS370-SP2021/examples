class B3 {
    public static void main(String[] args) {
        double x = Double.NaN;

        // What's inelegant about this code?
        if (x < 3)
            System.out.println("yes");
        else if (x > 3)
            System.out.println("no");
        else if (x == 3)
            System.out.println("equal");
        else
            System.out.println("other");
        // If x is an int, the "else" clause will never be executed.
        // If x is a float, the "else" clause is used when x is NaN.

        // Our intentions are unclear. How can we clarify?

        // If x is a float, then compare to floats as shown below.
        if (x < 3.0)
            System.out.println("yes");
        else if (x > 3.0) 
            System.out.println("no");
        else if (x == 3.0)
            System.out.println("equal");
        else
            System.out.println("other");

        // If y is an int, then delete the else block as shown below.
        int y=12;
        if (y < 3)
            System.out.println("yes");
        else if (y > 3) 
            System.out.println("no");
        else
            System.out.println("equal");
    }
}
