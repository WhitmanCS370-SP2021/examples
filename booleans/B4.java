class B4 {
    private static Boolean f() {
        System.out.println("f called");
        return true;
    }
    
    public static void main(String[] args) {
    
        // Can this statement be simplified?
        /*
        if (f() && false) 
            System.out.println("yes");
        else 
            System.out.println("no");
        */

        // If f() has side effects, we must call it.
        f();
        // Regardless, we should print out "no".
        System.out.println("no");

        // If we don't know whether f() has side effects, call it to be safe.

        // If we know f() follows the Command-Query Separation Principle,
        // then it's safe to skip calling f().
    }
}
