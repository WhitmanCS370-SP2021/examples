/*
 * File: SemicolonToken.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast6.token;

public class SemicolonToken extends Token
{
    public SemicolonToken(String s, int p)
    {
        super(s, p);
    }

    public Object accept(TokenVisitor v, Object o)
    {
        return v.visitSemicolonToken(this, o);
    }
}
