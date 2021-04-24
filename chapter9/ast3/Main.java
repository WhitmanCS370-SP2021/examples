/*
 * File: Main.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast3;

import ast3.node.Node;

public class Main
{
    public static void main(String[] args)
    {
        // Test both the PrettyPrinter and the MethodFinder

        PrettyPrinter printer = new PrettyPrinter();
        MethodFinder finder = new MethodFinder();
        Parser parser = new Parser();
        Node root;
        String prettyCode;

        String code = "class A { void main() { print(); } }";
        root = parser.parse(code);
        prettyCode = printer.prettyPrint(root, "");
        System.out.println("ORIGINAL CODE");
        System.out.println(code);
        System.out.println("PPRINTED CODE");
        System.out.println(prettyCode);

        code = "class A{ int x; void foo(){x = 3; while(x) {" +
                "  x = 4;while(x){x=5;}}} void main(){}}";
        root = parser.parse(code);
        prettyCode = printer.prettyPrint(root, "");
        System.out.println("\nORIGINAL CODE");
        System.out.println(code);
        System.out.println("PPRINTED CODE");
        System.out.println(prettyCode);

        code = "class A{int x;void foo(){;x=3;while(x){foo();}}" +
                "class B{int y;void bar(){}}}";
        root = parser.parse(code);
        prettyCode = printer.prettyPrint(root, "");
        System.out.println("\nORIGINAL CODE");
        System.out.println(code);
        System.out.println("PPRINTED CODE");
        System.out.println(prettyCode);

        code = "class A { void main() { print(); } }";
        root = parser.parse(code);
        System.out.println("ORIGINAL CODE");
        System.out.println(code);
        System.out.print("A contains main: Should be true, is ");
        System.out.println(finder.findMethod("main", "A", root));
        System.out.println();

        code = "class A{ int x; void foo(){x = 3; while(x) {" +
                "  x = 4;while(x){x=5;while(x){x=3;}}}} void main(){}}";
        root = parser.parse(code);
        System.out.println("ORIGINAL CODE");
        System.out.println(code);
        System.out.print("A contains bar: Should be false, is ");
        System.out.println(finder.findMethod("bar", "A", root));
        System.out.println();

        code = "class A{ int x;  void main(){} class B{ int x; void foo(){}}}";
        root = parser.parse(code);
        System.out.println("ORIGINAL CODE");
        System.out.println(code);
        System.out.print("A.B contains foo: Should be true, is ");
        System.out.println(finder.findMethod("foo", "A.B", root));
        System.out.println();

        code = "class A{ int x;  void main(){} class B{ int x; void foo(){}}}";
        root = parser.parse(code);
        System.out.println("ORIGINAL CODE");
        System.out.println(code);
        System.out.print("A contains foo: Should be false, is ");
        System.out.println(finder.findMethod("foo", "A", root));
        System.out.println();

        code = "class A{ int x;  class B{ int x; void bar(){}} void foo(){} }";
        root = parser.parse(code);
        System.out.println("ORIGINAL CODE");
        System.out.println(code);
        System.out.print("A contains foo: Should be true, is ");
        System.out.println(finder.findMethod("foo", "A", root));
        System.out.println();
    }
}
