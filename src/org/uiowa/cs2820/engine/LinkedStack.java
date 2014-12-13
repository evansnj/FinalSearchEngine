package org.uiowa.cs2820.engine;
import java.util.*;

public class LinkedStack<S> implements Search {

    public Node object;
    public int size;
    public int modCount;        //Initial declaration of variables
    public Node curPos;
    public int curModCount;
    public Exception IOException;;

    public LinkedStack(){
        this.object = null;
        this.size = 0;

        this.modCount = 0;
    }

    public void push(S element){        //Push element S onto the stack
        this.object = new Node();
        this.size += 1;
        this.modCount += 1;
    }

    public Node pop(){                  //Pop element S from the stack
        Node element = Node.data;
        this.object = this.next();
        this.size -= 1;
        this.modCount += 1;
        return element;
    }
    public boolean hasNext(){
        return curPos != null;
    }   //Is there a next element?

    public Node next(){
        if (! this.hasNext())
            throw new IllegalStateException();
        if (this.curModCount != modCount)
            throw new ConcurrentModificationException();    //Return the next value of the element
        Node data = Node.data;
        this.curPos = this.next();
        return data;
    }


    public Node look(){
        return Node.data;
    }

    public boolean Empty(){
        return this.size() == 0;
    }

    public int size(){
        return this.size;
    }
    //As promised by the Search interface, the iterator method is implemented here
    //To satisfy the DIP, the "new" keyword is not used!
    public Iterator createIterator() {
        return null;
    }


}