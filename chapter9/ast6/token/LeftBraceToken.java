/*
 * File: LeftBraceToken.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast6.token;

public class LeftBraceToken extends Token
{
    public LeftBraceToken(String s, int p)
    {
        super(s, p);
    }

    public Object accept(TokenVisitor v, Object o)
    {
        return v.visitLeftBraceToken(this, o);
    }
}
