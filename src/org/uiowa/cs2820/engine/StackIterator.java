package org.uiowa.cs2820.engine;

import java.util.*;


public class StackIterator implements Iterator {
    public Node curPos;
    public int curModCount;
    public Exception IOException;;      //Initialize variables
    public Node object;
    public int size;
    public int modCount;

    public StackIterator(){
        this.curPos = object;
        this.curModCount = modCount;
    }

    public boolean hasNext(){
        return curPos != null;
    }
    public Node next(){
        if (! this.hasNext())
            throw new IllegalStateException();
        if (this.curModCount != modCount)
            throw new ConcurrentModificationException();
        Node data = Node.data;
        this.curPos = this.next();
        return data;
    }


    public void remove() {      //Remove any elements with invalid inputs
        try {
            throw IOException;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}