import java.util.Iterator;

interface Set < E > extends Iterable < E > {
	public boolean add(E val);
	public boolean contains(E val);
	public boolean remove(E val);
	public int size();
	public Iterator < E > iterator();
}
