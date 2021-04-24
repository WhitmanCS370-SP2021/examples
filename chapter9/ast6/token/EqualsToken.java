/*
 * File: EqualsToken.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast6.token;

public class EqualsToken extends Token
{
    public EqualsToken(String s, int p)
    {
        super(s, p);
    }

    public Object accept(TokenVisitor v, Object o)
    {
        return v.visitEqualsToken(this, o);
    }
}
