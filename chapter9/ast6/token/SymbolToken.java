/*
 * File: SymbolToken.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast6.token;

public class SymbolToken extends Token
{
    public SymbolToken(String s, int p)
    {
        super(s, p);
    }

    public Object accept(TokenVisitor v, Object o)
    {
        return v.visitSymbolToken(this, o);
    }
}
