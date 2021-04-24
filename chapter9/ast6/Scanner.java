/*
 * File: Scanner.java
 * Author: Dale Skrien
 * Date: May 26, 2006
 */

package ast6;

import ast6.token.*;

public class Scanner
{
    private static final char NULL_CHAR = '\u0000';

    private String inputString; //the string to be converted into tokens
    private String tokenString; //the current token's spelling
    private int index; //index of the next character in the inputString

    public Scanner(String s)
    {
        if (s == null)
            s = "";
        inputString = s;
        tokenString = "";
        index = 0;
    }

    private char currentCharacter()
    {
        char c = NULL_CHAR;
        try {
            c = inputString.charAt(index);
        } catch (IndexOutOfBoundsException e) {
            // do nothing, fall through to return the null character
        }

        return c;
    }

    public Token getNextToken()
    {
        // trim any initial whitespace & comments
        trimWhiteSpaceAndComments();

        tokenString = "";
        int startIndex = index;
        return createToken(startIndex);
    }

    private void trimWhiteSpaceAndComments()
    {
//      THIS CODE IS USED IF YOU ALLOW /COMMENTS/
//      while( Character.isSpaceChar(currentCharacter()) ||
//                currentCharacter() == '/' ) {
//            if( currentCharacter() == '/' ) {
//                index++;
//                while( currentCharacter() != '/' )
//                    index++;
//                index++;
//            }
//            else
//                index++;
//        }
        while (Character.isSpaceChar(currentCharacter()) ) {
            index++;
        }
    }

    private void addCharToToken()
    {
        // move the first character from the input buffer to the end of
        // the token buffer
        tokenString += (inputString.charAt(index));
        index++;

    }

    //create and return a Token of the appropriate type
    private Token createToken(int startIndex)
    {
        //handle symbols and keywords, all of which start with a letter
        if( Character.isLetter(currentCharacter()) ) {
            addCharToToken();
            while( Character.isLetter(currentCharacter()) ||
                    Character.isDigit(currentCharacter()) ) {
                addCharToToken();
            }
            if (tokenString.equals("class"))
                return new ClassToken(tokenString, startIndex);
            else if (tokenString.equals("while"))
                return new WhileToken(tokenString, startIndex);
            else
                return new SymbolToken(tokenString, startIndex);
        }
        // if it starts with a digit, it's an integer literal
        else if( Character.isDigit(currentCharacter()) ) {
            addCharToToken();
            while( Character.isDigit(currentCharacter()) ) {
                addCharToToken();
            }
            return new IntLiteralToken(tokenString, startIndex);
        }
        // handle all other special case characters
        else {
            switch( currentCharacter() ) {
                case '(':
                    addCharToToken();
                    return new LeftParenToken(tokenString, startIndex);
                case ')':
                    addCharToToken();
                    return new RightParenToken(tokenString, startIndex);
                case '{':
                    addCharToToken();
                    return new LeftBraceToken(tokenString, startIndex);
                case '}':
                    addCharToToken();
                    return new RightBraceToken(tokenString, startIndex);
                case ';':
                    addCharToToken();
                    return new SemicolonToken(tokenString, startIndex);
                case '=':
                    addCharToToken();
                    return new EqualsToken(tokenString, startIndex);
                case NULL_CHAR:
                    if( index >= inputString.length())
                        return new EOFToken(tokenString, startIndex);
                    else
                        return new ErrorToken(tokenString, startIndex);
                default: //any other characters are illegal
                    return new ErrorToken(tokenString, startIndex);
            }
        }
    }
}
