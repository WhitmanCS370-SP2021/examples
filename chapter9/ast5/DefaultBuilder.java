/*
 * File: DefaultBuilder.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast5;

import ast5.node.IntLiteral;
import ast5.node.Node;
import ast5.node.Block;

import java.util.List;

public class DefaultBuilder
{
    public IntLiteral buildIntLiteral(int value)
    {
        return null;  //stub
    }

    public Node buildAssignStatement(String name, IntLiteral value)
    {
        return null;  //stub
    }

    public Node buildMethodCall(String name)
    {
        return null;  //stub
    }

    public Node buildEmptyStatement()
    {
        return null;  //stub
    }

    public Node buildWhileStatement(String cond, Block body)
    {
        return null;  //stub
    }

    public Block buildBlock(List<Node> statements)
    {
        return null;  //stub
    }

    public Node buildClassDeclaration(String name, List<Node> children)
    {
        return null;  //stub
    }

    public Node buildMethodDeclaration(String type, String name, Block body)
    {
        return null;  //stub
    }

    public Node buildVarDeclaration(String type, String name)
    {
        return null;  //stub
    }
}
