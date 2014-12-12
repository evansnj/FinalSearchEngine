package org.uiowa.cs2820.engine;
import java.util.*;

private class StackIterator implements Iterator{

    private Node curPos;
    private int curModCount;

    private StackIterator(){
        this.curPos = object;
        this.curModCount = modCount;
    }

    public boolean hasNext(){
        return curPos != null;
    }

    public S next(){
        if (! this.hasNext()
        throw new IllegalStateException();
        if (this.curModCount != modCount)
            throw new ConcurrentModificationException()
        S data = this.curPos.data;
        this.curPos = this.curPos.next();
        return data;
    }

    public void remove(){
        throw IOException();
    }
}