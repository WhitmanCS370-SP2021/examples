class Dog {
    protected String sound;
    public Dog() {
        sound = "woof";
    }
    public void bark() {
        bark(1, false);
    }
    public void bark(int times) {
        bark(times, false);
    }
    public void bark(int times, boolean loud) {
        for (int i=0; i<times; i++) {
            if (loud) {
                System.out.println(sound.toUpperCase());
            } else {
                System.out.println(sound.toLowerCase());
            }
        }
    }
}
class Hound extends Dog {
    public Hound () {
        sound = "bay";
    }
    public void sniff() {
        System.out.println("sniff");
    }
    public void sniff(Dog dog) {
        System.out.println("shnuff");
    }
    public void sniff(Hound dog) {
        System.out.println("whoof");
    }
}
public class Dogs {
    public static void main(String [] args){
        Dog clifford = new Dog();
        Dog mac = new Hound();
        clifford.bark(3, true);
        mac.bark();
        mac.sniff(clifford);
    }
}
// What is the output of running this program?
// Where is an example of method overloading?
// Where is an example of method overriding?
