import java.util.iterator;

//The iterator must compare multiple modification counts
//When abnormal counts are found, they are considered an exception and are thrown
//Used to maintain the consistency of the iterator(s)
public interface Iterator{

    public boolean hasNext();
    public Object next();
    void remove();
}





