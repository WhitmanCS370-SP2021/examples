package ast5.node;
/*
 * File: Node.java
 * Author: Dale Skrien
 * Date: May 26, 2006
 */

public interface Node
{
    Object accept(Visitor visitor, Object o);
}
