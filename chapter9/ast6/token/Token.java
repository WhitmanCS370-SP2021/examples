/*
 * File: Token.java
 * Author: Dale Skrien
 * Date: May 26, 2006
 */

package ast6.token;

public abstract class Token
{
    //constants
    public static final int EOF = 0;
    public static final int ERROR = 1;
    public static final int INTLITERAL = 2;
    public static final int SYMBOL = 3;
    public static final int CLASS = 4;
    public static final int LEFTBRACE = 5;
    public static final int RIGHTBRACE = 6;
    public static final int LEFTPAREN = 7;
    public static final int RIGHTPAREN = 8;
    public static final int SEMICOLON = 9;
    public static final int WHILE = 10;
    public static final int EQUALS = 11;

    //instance variables
    private int position;    //the starting position of this token in the input
    private String spelling; //the characters in this token

    public Token(String s, int p)
    {
        spelling = s;
        position = p;
    }

    public String getSpelling()
    {
        return spelling;
    }

    public int getPosition()
    {
        return position;
    }

    public String toString()
    {
        return spelling;
    }

    public abstract Object accept(TokenVisitor v, Object o);
}