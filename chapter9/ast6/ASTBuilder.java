/*
 * File: ASTBuilder.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast6;

import ast6.node.*;
import java.util.List;

public class ASTBuilder extends DefaultBuilder
{
    public IntLiteral buildIntLiteral(int value)
    {
        return new IntLiteral(value);
    }

    public Node buildAssignStatement(String name, IntLiteral value)
    {
        return new AssignStatement(name, value);
    }

    public Node buildMethodCall(String name)
    {
        return new MethodCall(name);
    }

    public Node buildEmptyStatement()
    {
        return new EmptyStatement();
    }

    public Node buildWhileStatement(String cond, Block body)
    {
        return new WhileStatement(cond, body);
    }

    public Block buildBlock(List<Node> statements)
    {
        return new Block(statements);
    }

    public Node buildClassDeclaration(String name, List<Node> children)
    {
        return new ClassDeclaration(name, children);
    }

    public Node buildMethodDeclaration(String type, String name, Block body)
    {
        return new MethodDeclaration(type, name, body);
    }

    public Node buildVarDeclaration(String type, String name)
    {
        return new VarDeclaration(type, name);
    }
}
