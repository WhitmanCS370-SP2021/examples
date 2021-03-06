/*
 * File: RightBraceToken.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast6.token;

public class RightBraceToken extends Token
{
    public RightBraceToken(String s, int p)
    {
        super(s, p);
    }

    public Object accept(TokenVisitor v, Object o)
    {
        return v.visitRightBraceToken(this, o);
    }
}
