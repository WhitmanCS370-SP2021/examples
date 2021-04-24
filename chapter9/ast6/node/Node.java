package ast6.node;
/*
 * File: Node.java
 * Author: Dale Skrien
 * Date: May 26, 2006
 */

public interface Node
{
    Object accept(NodeVisitor visitor, Object o);
}
