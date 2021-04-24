/*
 * File: ProgramTool.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast6;

import ast6.node.Node;

public class ProgramTool
{
    public String prettyPrint(String program)
    {
        Node root = new Parser().parse(program, new ASTBuilder());
        return new PrettyPrinter().prettyPrint(root, "");
    }

    public boolean findMethod(String methodName,
                              String className,
                              String program)
    {
        Node root = new Parser().parse(program, new ASTBuilder());
        return new MethodFinder().findMethod(methodName, className,
                                             root);
    }
}
