public class PureStack {
    private java.util.Stack stack;
    public PureStack()         { stack = new java.util.Stack(); }
    public void push(Object o) { stack.push(o); }
    public Object pop()        { return stack.pop(); }
    public Object peek()       { return stack.peek(); }
    public boolean isEmpty()   { return stack.empty(); }
}
