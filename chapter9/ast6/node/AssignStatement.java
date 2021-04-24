/*
 * File: AssignStatement.java
 * Author: Dale Skrien
 * Date: May 28, 2006
 */
package ast6.node;

public class AssignStatement
        implements Node
{
    private String variable;
    private IntLiteral value;

    public AssignStatement(String variable, IntLiteral value)
    {
        this.variable = variable;
        this.value = value;
    }

    public Object accept(NodeVisitor visitor, Object o)
    {
        return visitor.visitAssignStatement(this, o);
    }

    public String getVariable()
    {
        return variable;
    }

    public IntLiteral getValue()
    {
        return value;
    }
}
