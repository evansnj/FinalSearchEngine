package org.uiowa.cs2820.engine;
import java.util.*;

public class LinkedStack implements Search {

    private Node<S> object;
    private int size;
    private int modCount;

    public LinkedStack() {
        this.object = null;
        this.size = 0;
        this.modCount = 0;
    }

    public void push(S element) {
        this.object = new Node<S>(element, object);
        this.size += 1;
        this.modCount += 1;
    }

    public S pop() {
        S element = this.object.data;
        this.items = this.object.next;
        this.size -= 1;
        this.modCount += 1;
        return element;
    }

    public S look() {
        return this.object.data;
    }

    public boolean Empty() {
        return this.size() == 0;
    }

    public int size() {
        return this.size;
    }
}