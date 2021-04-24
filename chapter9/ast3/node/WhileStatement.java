/*
 * File: WhileStatement.java
 * Author: Dale Skrien
 * Date: May 28, 2006
 */
package ast3.node;

public class WhileStatement
    implements Node
{
    private String condition;
    private Block body;

    public WhileStatement(String condition, Block body)
    {
        this.condition = condition;
        this.body = body;
    }

    public String prettyPrint(String indent)
    {
        String result = indent + "while(" + getCondition() + ") ";
        result += getBody().prettyPrint(indent);
        return result;
    }

    public boolean findMethod(String methodName, String desiredClassName,
                              String currentClassName)
    {
        return false;
    }

    public String getCondition()
    {
        return condition;
    }

    public Block getBody()
    {
        return body;
    }

}
