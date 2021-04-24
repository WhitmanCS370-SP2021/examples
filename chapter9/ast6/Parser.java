/*
 * File: Parser.java
 * Author: Dale Skrien
 * Date: May 29, 2006
 */
package ast6;

import ast6.node.*;
import ast6.token.*;

import java.util.ArrayList;
import java.util.List;

public class Parser
{
    private Scanner scanner;
    private Token currentToken;
    private DefaultBuilder builder;

    public Parser()
    {
        this.builder = null;
        this.scanner = null;
        this.currentToken = null;
    }

    public Node parse(String code, DefaultBuilder builder)
    {
        this.builder = builder;
        this.scanner = new Scanner(code);
        advance(); //get the first token

        Node root = parseDeclaration();  //build the whole AST

        //do final error checking
        if (! (root instanceof ClassDeclaration))
            error("A program must consist of a class declaration.");
        else
            matchAndAdvance(EOFToken.class);
        return root;
    }

    private Node parseDeclaration()
    {
        DefaultTokenVisitor visitor = new DefaultTokenVisitor()
        {
            public Object visitToken(Token t, Object o)
            {
                error("The wrong kind of token (" + currentToken +
                      ") was found at position " + currentToken.getPosition());
                return null;
            }

            public Object visitSemicolonToken(SemicolonToken t, Object o)
            {
                String[] args = (String[]) o;
                advance();
                return builder.buildVarDeclaration(args[0], args[1]);
            }

            public Object visitLeftParenToken(LeftParenToken t, Object o)
            {
                String[] args = (String[]) o;
                advance();
                matchAndAdvance(RightParenToken.class);
                Block body = parseBlock();
                return builder.buildMethodDeclaration(args[0], args[1], body);
            }

            public Object visitLeftBraceToken(LeftBraceToken t, Object o)
            {
                String[] args = (String[]) o;
                advance();
                List<Node> children = new ArrayList<Node>();
                while (!(currentToken instanceof RightBraceToken)) {
                    children.add(parseDeclaration());
                }
                advance();
                return builder.buildClassDeclaration(args[1], children);
            }
        };

        if (! (currentToken instanceof SymbolToken) &&
            ! (currentToken instanceof ClassToken)) {
            error("The wrong kind of token (" + currentToken +
                  ") was found at position " + currentToken.getPosition());
        }
        String type = currentToken.getSpelling();
        advance();
        String name = currentToken.getSpelling();
        matchAndAdvance(SymbolToken.class);
        return (Node) currentToken.accept(visitor, new String[]{type, name});
    }

    private Block parseBlock()
    {
        matchAndAdvance(LeftBraceToken.class);
        List<Node> statements = new ArrayList<Node>();
        while (! (currentToken instanceof RightBraceToken)) {
            statements.add(parseStatement());
        }
        matchAndAdvance(RightBraceToken.class);
        return builder.buildBlock(statements);
    }

    private Node parseStatement()
    {
        DefaultTokenVisitor visitor = new DefaultTokenVisitor()
        {
            public Object visitToken(Token t, Object o)
            {
                error("The wrong kind of token (" + currentToken +
                        ") was found at position " +
                        currentToken.getPosition());
                return null;
            }

            public Object visitSemicolonToken(SemicolonToken t, Object o)
            {
                advance();
                return builder.buildEmptyStatement();
            }

            public Object visitWhileToken(WhileToken t, Object o)
            {
                advance();
                matchAndAdvance(LeftParenToken.class);
                String cond = currentToken.getSpelling();
                advance();
                matchAndAdvance(RightParenToken.class);
                Block body = parseBlock();
                return builder.buildWhileStatement(cond, body);
            }

            public Object visitSymbolToken(SymbolToken t, Object o)
            {
                String name = currentToken.getSpelling();
                advance();
                if (currentToken instanceof LeftParenToken) {
                    advance();
                    matchAndAdvance(RightParenToken.class);
                    matchAndAdvance(SemicolonToken.class);
                    return builder.buildMethodCall(name);
                }
                else if (currentToken instanceof EqualsToken) {
                    advance();
                    IntLiteral value = parseIntLiteral();
                    matchAndAdvance(SemicolonToken.class);
                    return builder.buildAssignStatement(name, value);
                }
                else {
                    error("Incorrect Token: " + currentToken);
                    return null;
                }
            }
        };

       return (Node) currentToken.accept(visitor, null);
    }

    private IntLiteral parseIntLiteral()
    {
        int value = 0;
        try {
            value = Integer.parseInt(currentToken.getSpelling());
            advance();
        } catch (NumberFormatException e) {
            error("Illegal integer value: " + currentToken);
        }
        return builder.buildIntLiteral(value);
    }

    private void advance()
    {
        currentToken = scanner.getNextToken();
    }

    private void matchAndAdvance(Class c)
    {
        if (!(currentToken.getClass().isAssignableFrom(c)))
            error("The wrong kind of token (" + currentToken
                    + ") was found at position " + currentToken.getPosition());
        advance();
    }

    private void error(String message)
    {
        throw new ParseException("Parse error: " + message);
    }

    private class ParseException extends RuntimeException
    {
        public ParseException(String message)
        {
            super(message);
        }
    }
}
