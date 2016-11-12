package ua.edu.ucu.collections.immutable;

/**
 * Created by oleh on 03.11.16.
 */
public class Node {
    private final Object data;
    private final Node next;

    public Node(Object data, Node next){
        this.data = (Object)data;
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }

    public Object getData() {
        return this.data;
    }
}
