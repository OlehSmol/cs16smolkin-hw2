package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList queue;

    public Queue(){
        this.queue = new ImmutableLinkedList();
    }

    public void enqueue(Object e) {
        this.queue = this.queue.addLast(e);
    }

    public Object dequeue() {
        Object e = this.pick();
        if(!e.equals(null)){
            this.queue = this.queue.removeFirst();
        }
        return e;
    }

    public Object pick() {
        if(!this.queue.isEmpty()){
            return this.queue.getFirst();
        }
        return null;
    }
}
