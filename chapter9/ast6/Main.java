/*
 * File: Main.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast6;

public class Main
{
    public static void main(String[] args)
    {
        ProgramTool tool = new ProgramTool();

        //TEST the PrettyPrinter
        String code = "class A { void main() { print(); } }";
        String prettyCode = tool.prettyPrint(code);
        System.out.println("ORIGINAL CODE");
        System.out.println(code);
        System.out.println("PPRINTED CODE");
        System.out.println(prettyCode);

        code = "class A{ int x; void foo(){x = 3; while(x) {" +
                "  x = 4;while(x){x=5;}}} void main(){}}";
        prettyCode = tool.prettyPrint(code);
        System.out.println("\nORIGINAL CODE");
        System.out.println(code);
        System.out.println("PPRINTED CODE");
        System.out.println(prettyCode);

        code = "class A{int x;void foo(){;x=3;while(x){foo();}}" +
                "class B{int y;void bar(){}}}";
        prettyCode = tool.prettyPrint(code);
        System.out.println("\nORIGINAL CODE");
        System.out.println(code);
        System.out.println("PPRINTED CODE");
        System.out.println(prettyCode);

        //TEST the MethodFinder
        code = "class A { void main() { print(); } }";
        System.out.println("ORIGINAL CODE");
        System.out.println(code);
        System.out.print("A contains main: Should be true, is ");
        System.out.println(tool.findMethod("main", "A", code));
        System.out.println();

        code = "class A{ int x; void foo(){x = 3; while(x) {" +
                "  x = 4;while(x){x=5;while(x){x=3;}}}} void main(){}}";
        System.out.println("ORIGINAL CODE");
        System.out.println(code);
        System.out.print("A contains bar: Should be false, is ");
        System.out.println(tool.findMethod("bar", "A", code));
        System.out.println();

        code = "class A{ int x;  void main(){} class B{ int x; void foo(){}}}";
        System.out.println("ORIGINAL CODE");
        System.out.println(code);
        System.out.print("A.B contains foo: Should be true, is ");
        System.out.println(tool.findMethod("foo", "A.B", code));
        System.out.println();

        code = "class A{ int x;  void main(){} class B{ int x; void foo(){}}}";
        System.out.println("ORIGINAL CODE");
        System.out.println(code);
        System.out.print("A contains foo: Should be false, is ");
        System.out.println(tool.findMethod("foo", "A", code));
        System.out.println();

        code = "class A{ int x;  class B{ int x; void bar(){}} void foo(){} }";
        System.out.println("ORIGINAL CODE");
        System.out.println(code);
        System.out.print("A contains foo: Should be true, is ");
        System.out.println(tool.findMethod("foo", "A", code));
        System.out.println();
    }
}
