/*
 * File: AssignStatement.java
 * Author: Dale Skrien
 * Date: May 28, 2006
 */
package ast2.node;

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

    public String prettyPrint(String indent)
    {
        return indent + getVariable() + " = " + getValue().prettyPrint("") + ";";
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
