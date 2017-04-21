### For-each loops and Iterators

In Java, a **Collection** can utilize the for-each loop provided that it implements the Iterable interface.

#### Iterable Interface

* Iterable.java is located in `java.lang`.

```
<Interface>
---------------
|Iterable     |
|+ iterator() |
---------------
```

All lists, both ArrayLists and LinkedLists, **are iterable**.

```
                             ------------
<Interface>   <Interface>   /|ArrayList |
----------    ------------ / ------------
|Iterable| -->|List      | \ ------------
----------    ------------  \|LinkedList|
                             ------------
```

### Modify List.java

```
import java.util.Iterator;

interface List<E> extends Iterable<E> {
	int size();
	.
	.
	.
	Iterator<E> iterator();
}
```

### Methods of Iterator

```
public interface Iterator<E> {
	boolean hasNext();
	E next();
	void remove();
}
```

#### Example of using an iterator directly

```
.
.
.
List <Integer> L = <some kind of list>;
L.add(1); // [1]
L.add(2); // [1, 2]
Iterator<Integer> itr = L.iterator();
while (itr.hasNext()) {
	System.out.println(itr.next());
}
.
.
.
OUTPUT:
1
2
```

### Removing via an iterator
`public void remove() throws IllegalStateException`
This method can be called only once per call to next.
