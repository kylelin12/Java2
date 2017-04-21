import java.util.Iterator;

interface List<E> extends Iterable<E>{
    int size();
    boolean add(E obj); // adds a obj to the end
    void add(int index, E obj);
    E get(int index);
    E set(int index, E obj);
    E remove(int index);
    Iterator<E> iterator();

}
