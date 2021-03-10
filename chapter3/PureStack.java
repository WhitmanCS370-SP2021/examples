public interface PureStack {
    public void push(Object o);
    public Object pop();
    public Object peek();
    public boolean isEmpty();
}

public class MyStack implements PureStack {
    private java.util.Stack stack;
    public PureStack()         { stack = new java.util.Stack(); }
    public void push(Object o) { stack.push(o); }
    public Object pop()        { return stack.pop(); }
    public Object peek()       { return stack.peek(); }
    public boolean isEmpty()   { return stack.empty(); }
}
