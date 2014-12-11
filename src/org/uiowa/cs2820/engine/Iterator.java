import java.util.iterator;

//The iterator must compare multiple modification counts
//When abnormal counts are found, they are considered an exception and are thrown
//Used to maintain the consistency of the iterator(s)
public class LinkedStack<S> implements Search<S>{

    private Node<S> object;
    private int size;
    private int modCount;

    public LinkedStack(){
        this.object = null;
        this.size = 0;
        this.modCount = 0;
    }

    public void push(S element){
        this.object = new Node<S>(element, object);
        this.size += 1;
        this.modCount += 1;
    }

    public S pop(){
        S element = this.object.data;
        this.items = this.object.next;
        this.size -= 1;
        this.modCount += 1;
        return element;
    }

    public S look(){
        return this.object.data;
    }

    public boolean Empty(){
        return this.size() == 0;
    }

    public int size(){
        return this.size;
    }

    public Iterator<S> iterator(){
        return new StackIterator<S>();
    }

    private class StackIterator<S> implements Iterator<S>{

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

    private class Node<S>{

        private S data;
        private Node next;

        private Node(S data, Node next){
            this.data = data;
            This.next = next;
        }
    }
}
//The searching iterator implemented by the linked stack
Search<String> stack = new LinkedStack<String>();
        i = stack.iterator();
        while (i.hasNext()){
        String element = i.next()
        // process element
        }

        for (String element : stack){
        // process element

        }



