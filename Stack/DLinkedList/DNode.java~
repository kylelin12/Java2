public class DNode<E>{
    private E _value;
    private DNode<E> _previous, _next;

    public DNode(E value, DNode<E> previous, DNode<E> next){
	_value = value;
	_previous = previous;
	_next = next;

    }

    public E getValue(){
	return _value;
    }

    public DNode<E> getPrevious(){
	return _previous;
    }
    
    public DNode<E> getNext(){
	return _next;
    }
    
    public E setValue(E newValue){
	E ans = _value;
	_value = newValue;
	return ans;
    }

    public DNode<E> setPrevious(DNode<E> newPrevious){
	DNode<E> ans = getPrevious();
	_previous = newPrevious;
	return ans;
    }

    public DNode<E> setNext(DNode<E> newNext){
	DNode<E> ans = getNext();
	_next = newNext;
	return ans;
    }



    public String toString(){
	return _value.toString();
    }


    public static void main(String [] args){
	DNode<String> a = new DNode<String>("Amy", null, null);
	DNode<String> b = new DNode<String>("Bill", a, null);
	DNode<String> c = new DNode<String>("Carol", b, null);
	a.setNext(b);
	b.setNext(c);
        DNode<String> current = a;
	while (current != null){
	    System.out.println(current);
	    current = current.getNext();
	}
	current = c;
	while( current != null){
	    System.out.println(current);
	    current = current.getPrevious();

	}
	// swap the values of a and c
	a.setValue(c.setValue(a.getValue()));
	System.out.println(a);
	System.out.println(c);



    }


}
