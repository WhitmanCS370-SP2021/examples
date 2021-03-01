class Dog {
    public void bark() {
        System.out.println("Woof!");
    }
    public void bark(int times) {
        for (int i=0; i<times; i++) {
            bark();
        }
    }
    public void bark(boolean loud) {
        if (loud) {
            System.out.println("WOOF!");
        } else  {
            System.out.println("Woof!");
        }
    }
    public void bark(int times, boolean loud) {
        for (int i=0; i<times; i++) {
            bark(loud);
        }
    }
}
class Hound extends Dog {
    public void bark() {
        System.out.println("Bay!");
    }
    public void sniff() {
        System.out.println("sniiiifffff");
    }
}
public class Dogs1 {
    public static void main(String [] args){
        Dog clifford = new Dog();
        Dog mac = new Hound();
        clifford.bark(3,true);
        mac.bark(3,true);
    }
}
// What is the output of running this program?
// Where is an example of method overloading?
// Where is an example of method overriding?
