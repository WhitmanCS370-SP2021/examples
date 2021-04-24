/*
 * File: WhileToken.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast6.token;

public class WhileToken extends Token
{
    public WhileToken(String s, int p)
    {
        super(s, p);
    }

    public Object accept(TokenVisitor v, Object o)
    {
        return v.visitWhileToken(this, o);
    }
}
