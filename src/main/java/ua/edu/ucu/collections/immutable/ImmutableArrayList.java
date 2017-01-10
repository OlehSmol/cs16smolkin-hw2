package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {
    final private Object[] array;
    final private int size;
    //додає елемент у кінець колекції
    public ImmutableArrayList() {
        this.array = new Object[0];
        this.size = 0;
    }

    private ImmutableArrayList(Object[] array) {
        this.array = array;
        this.size = array.length;
    }

    public ImmutableArrayList add(Object e) {
        return this.add(this.size, e);
    }

    //додає елемент до колекції за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public ImmutableArrayList add(int index, Object e) {
        Object[] newArray = new Object[this.size + 1];

        for(int i = 0; i < index; i++) {
            newArray[i] = this.array[i];
        }
        newArray[index] = e;
        for(int i = index + 1; i < this.size + 1; i++) {
            newArray[i] = this.array[i - 1];
        }

        return new ImmutableArrayList(newArray);
    }

    //додає масив елементів у кінець колекції
    public ImmutableArrayList addAll(Object[] c) {
        return this.addAll(this.size, c);
    }

    // додає масив елементів починаючи з зазначеного індекса, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public ImmutableArrayList addAll(int index, Object[] c) {
        Object[] newArray = new Object[this.size + c.length];

        for(int i = 0; i < index; i++) {
            newArray[i] = this.array[i];
        }
        int j = 0;
        for(int i = index; i < index + c.length; i++){
            newArray[i] = c[j];
            j++;
        }
        for(int i = index + c.length; i < this.size + c.length; i++) {
            newArray[i] = this.array[i - c.length];
        }

        return new ImmutableArrayList(newArray);
    }

    //повертає елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public Object get(int index) {
        return this.array[index];
    }

    //видаляє елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public ImmutableArrayList remove(int index) {
        Object[] newArray = new Object[this.size - 1];

        for(int i = 0; i < index; i++) {
            newArray[i] = this.array[i];
        }
        for(int i = index + 1; i < this.size; i++) {
            newArray[i - 1] = this.array[i];
        }

        return new ImmutableArrayList(newArray);
    }

    //змінює значення елементу за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    public ImmutableArrayList set(int index, Object e) {
        Object[] newArray = new Object[this.size];
        for(int i = 0; i < this.size; i++){
            if(i + 1 == index){
                newArray[i] = e;
                continue;
            }
            newArray[i] = this.array[i];
        }
        return new ImmutableArrayList(newArray);
    }

    //шукає індекс елемента (повертає індекс першого який знайшов, або -1 у випадку відсутності)
    public int indexOf(Object e) {
        for(int i = 0; i < this.size; i++) {
            if (this.array[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //розмір колекції
    public int size() {
        return this.size;
    }

    //очищує вміст колекції
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    //якщо у колеції нема елементів то повертає true
    public boolean isEmpty() {
        if(this.size == 0){
            return true;
        }
        return false;
    }

    //перетворює колекцію до масиву обєктів
    public Object[] toArray() {
        Object[] copyArray = new Object[this.size];

        for(int i = 0; i< this.size; i++) {
            copyArray[i] = this.array[i];
        }

        return copyArray;
    }

    @Override
    //повертає рядок, де через кому відображаютсься елементи колекції
    public String toString() {
        String result = "";
        for(int i = 0; i < this.size; i++){
            result += this.array[i];
            if(i < this.size - 1){
                result += ", ";
            }
        }
        return result;
    }

    private void validateIndex(int index){
        if(index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }
}
