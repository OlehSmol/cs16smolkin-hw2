package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList{
    final private Node head;
    final private int size;
    public ImmutableLinkedList() {
        this.head = null;
        this.size = 0;
    }

    private ImmutableLinkedList(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    interface Operetion{
        Node execute(Object[] c, Node originNode);
    }

    private Node Copy(int index, Object[] c, Node originNode, int position, Operetion operation){
        Node copyNode;

        if(position > index) {
            copyNode = new Node(originNode.getData(), Copy(index, c, originNode.getNext(), position - 1, operation));
        }
        else {
            copyNode = operation.execute(c, originNode);
        }

        return copyNode;
    }

    //додає елемент у кінець
    public ImmutableLinkedList add(Object e) {
        Node newNode = new Node(e, this.head);
        return new ImmutableLinkedList(newNode, this.size + 1);
    }

    //додає елемент до колекції за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public ImmutableLinkedList add(int index, Object e) {
         return addAll(index, new Object[]{e});
    }

    //додає масив елементів у кінець колекції
    public ImmutableLinkedList addAll(Object[] c) {
        Node nextNode = this.head;
        for(int i = 0; i < c.length; i++) {
            Node newNode = new Node(c[i], nextNode);
            nextNode = newNode;
        }

        return new ImmutableLinkedList(nextNode, this.size + c.length);
    }

    // додає масив елементів починаючи з зазначеного індекса, та кидає - ситуацію, якщо індекс виходить за межі колекції
    public ImmutableLinkedList addAll(int index, Object[] c) {
        validateIndex(index);
        Operetion add =  new Operetion () {
            public Node execute(Object[] c, Node originNode) {
                Node nextNode = originNode;
                for(int i = 0; i < c.length; i++) {
                    nextNode = new Node(c[i], nextNode);
                }
                return nextNode;
            }
        };
        return new ImmutableLinkedList(Copy(index, c, this.head, this.size, add), this.size + c.length);
    }

    //повертає елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public Object get(int index) {
        validateIndex(index);
        Node currentNode = this.head;
        for(int i = size - 1; i > -1; i--){
            if(i == index){
                break;
            }
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    //видаляє елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public ImmutableLinkedList remove(int index) {
        Operetion remove =  new Operetion () {
            public Node execute(Object[] c, Node originNode) {
                return originNode.getNext();
            }
        };
        return new ImmutableLinkedList(Copy(index + 1, null, this.head, this.size, remove), this.size - 1);
    }

    //змінює значення елементу за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public ImmutableLinkedList set(int index, Object e) {
        Operetion set =  new Operetion () {
            public Node execute(Object[] c, Node originNode) {
                return new Node(c[0], originNode.getNext());
            }
        };
        return new ImmutableLinkedList(Copy(index, new Object[]{e}, this.head, this.size, set), this.size);
    }

    //шукає індекс елемента (повертає індекс першого який знайшов, або -1 у випадку відсутності)
    public int indexOf(Object e) {
        Node currentNode = this.head;
        for(int i = this.size - 1; i > -1; i--) {
            if(currentNode.getData().equals(e)) {
                return i;
            }
            currentNode = currentNode.getNext();
        }
        return -1;
    }

    //розмір колекції
    public int size() {
        return this.size;
    }

    //очищує вміст колекції
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    //якщо у колеції нема елементів то повертає true
    public boolean isEmpty() {
        if(this.size == 0) {
            return true;
        }
        return false;
    }

    //перетворює колекцію до масиву обєктів
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node currentNode = head;

        for(int i = size - 1; i > -1; i--){
            array[i] = currentNode.getData();
            currentNode = currentNode.getNext();
        }

        return array;
    }

    @Override
    //повертає рядок, де через кому відображаютсься елементи колекції
    public String toString() {
        String result = head.getData().toString();
        Node currentNode = head.getNext();

        for(int i = size - 2; i > -1; i--){
            result = currentNode.getData() + ", " + result;
            currentNode = currentNode.getNext();
        }

        return result;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return this.add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return this.add(e);
    }

    public Object getFirst() {
        return this.get(0);
    }

    public Object getLast() {
        return this.get(this.size - 1);
    }

    public ImmutableLinkedList removeFirst() {
        return this.remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return this.remove(this.size - 1);
    }

    private void validateIndex(int index){
        if(index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }
}
