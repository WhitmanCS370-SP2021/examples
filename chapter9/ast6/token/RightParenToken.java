/*
 * File: RightParenToken.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast6.token;

public class RightParenToken extends Token
{
    public RightParenToken(String s, int p)
    {
        super(s, p);
    }

    public Object accept(TokenVisitor v, Object o)
    {
        return v.visitRightParenToken(this, o);
    }
}
