/*
 * File: PrettyPrinter.java
 * Author: Dale Skrien
 * Date: May 26, 2006
 */
package ast5;

import ast5.node.*;

import java.util.Iterator;

/**
 * This class can take VSSJ code (as a String) and pretty print it--
 * that is, it can create a new copy of the program with proper
 * formatting according to Java conventions.
 * The following output is an example of pretty-printed code:
 *  class A {
 *      int x;
 *
 *      void foo() {
 *          ;
 *          x = 3;
 *          while(x) {
 *              foo();
 *          }
 *      }
 *
 *      class B {
 *          int y;
 *
 *          void bar() { }
 *      }
 *  }
 */
public class PrettyPrinter
        implements Visitor
{
    /**
     * constructs a new copy of the program with proper formatting
     * according to Java conventions.
     *
     * @param root   the root Node of the ASt representing the program to
     *               be reformatted
     * @param indent the String of whitespace with which the whole program
     *               is to be indented
     * @return the properly formatted version of the program
     */
    public String prettyPrint(Node root, String indent)
    {
        return (String) root.accept(this, indent);
    }


    public Object visitClassDeclaration(ClassDeclaration node, Object o)
    {
        String indent = (String) o;
        String result = indent + "class " + node.getName() + " {\n";
        for (Iterator it = node.getDeclarations().iterator(); it.hasNext();) {
            Node node1 = (Node) it.next();
            result += node1.accept(this, indent + "    ") + "\n";
            if (it.hasNext())
                result += "\n"; //add blank line between declarations
        }
        result += indent + "}";
        return result;
    }

    public Object visitMethodDeclaration(MethodDeclaration node, Object o)
    {
        String indent = (String) o;
        String result = indent + node.getType() + " " + node.getName() +
                "() ";
        result += node.getBody().accept(this, indent);
        return result;
    }

    public Object visitVarDeclaration(VarDeclaration node, Object o)
    {
        String indent = (String) o;
        return indent + node.getType() + " " + node.getName() + ";";
    }

    public Object visitAssignStatement(AssignStatement node, Object o)
    {
        String indent = (String) o;
        String result = indent + node.getVariable() + " = ";
        result += node.getValue().accept(this, "") + ";";
        return result;
    }

    public Object visitBlock(Block node, Object o)
    {
        String indent = (String) o; //indent for right brace
        String result = "{";
        if (node.getStatements().size() == 0)
            result += " }";
        else {
            result += "\n";
            for (Node node1 : node.getStatements()) {
                result += node1.accept(this, indent + "    ") + "\n";
            }
            result += indent + "}";
        }

        return result;
    }

    public Object visitEmptyStatement(EmptyStatement node, Object o)
    {
        return o + ";";
    }

    public Object visitWhileStatement(WhileStatement node, Object o)
    {
        String indent = (String) o;
        String result = indent + "while(" + node.getCondition() + ") ";
        result += node.getBody().accept(this, indent);
        return result;
    }

    public Object visitMethodCall(MethodCall node, Object o)
    {
        String indent = (String) o;
        return indent + node.getName() + "()" + ";";
    }

    public Object visitIntLiteral(IntLiteral node, Object o)
    {
        String indent = (String) o;
        return indent + node.getValue();
    }
}
