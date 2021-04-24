/*
 * File: Block.java
 * Author: Dale Skrien
 * Date: May 28, 2006
 */
package ast2.node;

import java.util.List;

public class Block
        implements Node
{
    private List<Node> statements;

    public Block(List<Node> statements)
    {
        this.statements = statements;
    }

    public String prettyPrint(String indent)
    {
        String result = "{";
        if (getStatements().size() == 0)
            result += " }";
        else {
            result += "\n";
            for (Node node1 : getStatements()) {
                result += node1.prettyPrint(indent + "    ") + "\n";
            }
            result += indent + "}";
        }

        return result;
    }

    public List<Node> getStatements()
    {
        return statements;
    }
}
