/*
 * File: LeftParenToken.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast6.token;

public class LeftParenToken extends Token
{
    public LeftParenToken(String s, int p)
    {
        super(s, p);
    }

    public Object accept(TokenVisitor v, Object o)
    {
        return v.visitLeftParenToken(this, o);
    }
}
