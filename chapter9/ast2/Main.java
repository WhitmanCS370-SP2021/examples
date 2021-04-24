/*
 * File: Main.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast2;

import ast2.node.Node;

public class Main
{
    public static void main(String[] args)
    {
        PrettyPrinter printer = new PrettyPrinter();
        Parser parser = new Parser();

        String code = "class A { void main() { print(); } }";
        Node root = parser.parse(code);
        String prettyCode = printer.prettyPrint(root,"");
        System.out.println("ORIGINAL CODE");
        System.out.println(code);
        System.out.println("PPRINTED CODE");
        System.out.println(prettyCode);

        code = "class A{ int x; void foo(){x = 3; while(x) {" +
                "  x = 4;while(x){x=5;}}} void main(){}}";
        root = parser.parse(code);
        prettyCode = printer.prettyPrint(root,"");
        System.out.println("\nORIGINAL CODE");
        System.out.println(code);
        System.out.println("PPRINTED CODE");
        System.out.println(prettyCode);

        code = "class A{int x;void foo(){;x=3;while(x){foo();}}" +
                "class B{int y;void bar(){}}}";
        root = parser.parse(code);
        prettyCode = printer.prettyPrint(root,"");
        System.out.println("\nORIGINAL CODE");
        System.out.println(code);
        System.out.println("PPRINTED CODE");
        System.out.println(prettyCode);
    }
}
