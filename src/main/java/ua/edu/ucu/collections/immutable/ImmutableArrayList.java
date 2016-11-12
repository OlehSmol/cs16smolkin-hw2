package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {
    //додає елемент у кінець колекції
    public ImmutableArrayList add(Object e) {
        return new ImmutableArrayList();
    }

    //додає елемент до колекції за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public ImmutableArrayList add(int index, Object e) {
        return new ImmutableArrayList();
    }

    //додає масив елементів у кінець колекції
    public ImmutableArrayList addAll(Object[] c) {
        return new ImmutableArrayList();
    }

    // додає масив елементів починаючи з зазначеного індекса, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public ImmutableArrayList addAll(int index, Object[] c) {
        return new ImmutableArrayList();
    }

    //повертає елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public Object get(int index) {
        return new ImmutableArrayList();
    }

    //видаляє елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public ImmutableArrayList remove(int index) {
        return new ImmutableArrayList();
    }

    //змінює значення елементу за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public ImmutableArrayList set(int index, Object e) {
        return new ImmutableArrayList();
    }

    //шукає індекс елемента (повертає індекс першого який знайшов, або -1 у випадку відсутності)
    public int indexOf(Object e) {
        return -1;
    }

    //розмір колекції
    public int size() {
        return -1;
    }

    //очищує вміст колекції
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    //якщо у колеції нема елементів то повертає true
    public boolean isEmpty() {
        return true;
    }

    //перетворює колекцію до масиву обєктів
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    //повертає рядок, де через кому відображаютсься елементи колекції
    public String toString() {
        return new String();
    }
}
