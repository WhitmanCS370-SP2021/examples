/*
 * File: Block.java
 * Author: Dale Skrien
 * Date: May 28, 2006
 */
package ast5.node;

import java.util.List;

public class Block
        implements Node
{
    private List<Node> statements;

    public Block(List<Node> statements)
    {
        this.statements = statements;
    }

    public Object accept(Visitor visitor, Object o)
    {
        return visitor.visitBlock(this, o);
    }

    public List<Node> getStatements()
    {
        return statements;
    }
}
