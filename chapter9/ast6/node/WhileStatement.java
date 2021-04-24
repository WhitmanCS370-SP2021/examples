/*
 * File: WhileStatement.java
 * Author: Dale Skrien
 * Date: May 28, 2006
 */
package ast6.node;

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

    public Object accept(NodeVisitor visitor, Object o)
    {
        return visitor.visitWhileStatement(this, o);
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
