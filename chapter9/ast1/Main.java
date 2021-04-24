/*
 * File: Main.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast1;

public class Main
{
    public static void main(String[] args)
    {
        String code = "class A { void main() { print(); } }";
        PrettyPrinter printer = new PrettyPrinter();
        String prettyCode = printer.prettyPrint(code);
        System.out.println("ORIGINAL CODE");
        System.out.println(code);
        System.out.println("PPRINTED CODE");
        System.out.println(prettyCode);

        code = "class A{ int x; void foo(){x = 3; while(x) {" +
                "  x = 4;while(x){x=5;}}} void main(){}}";
        prettyCode = printer.prettyPrint(code);
        System.out.println("\nORIGINAL CODE");
        System.out.println(code);
        System.out.println("PPRINTED CODE");
        System.out.println(prettyCode);

        code = "class A{int x;void foo(){;x=3;while(x){foo();}}" +
                "class B{int y;void bar(){}}}";
        prettyCode = printer.prettyPrint(code);
        System.out.println("\nORIGINAL CODE");
        System.out.println(code);
        System.out.println("PPRINTED CODE");
        System.out.println(prettyCode);
    }
}
