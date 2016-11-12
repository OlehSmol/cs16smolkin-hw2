package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack;

    public Stack() {
        this.stack = new ImmutableLinkedList();
    }

    public Object pick() {
        if(!this.stack.isEmpty()){
            return this.stack.getLast();
        }
        return null;
    }

    public  Object pop() {
        Object e = this.pick();
        if (!e.equals(null)) {
            this.stack = this.stack.removeLast();
        }
        return e;
    }

    public void push(Object e) {
        this.stack = this.stack.addLast(e);
    }
}
