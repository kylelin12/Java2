public class DLinkedList<E> {
    
    private DNode<E> _header, _trailer;  // dummy (sentinel) nodes
    private int _size;

    // constructor
    // instantiates an empty DLinkedList object
    public DLinkedList() {
    	_header = new DNode<E>(null, null, null);
    	_trailer = new DNode<E>(null, _header, null);
    	_header.setNext(_trailer);
		_size = 0;
    }

    // accessor methods
    public int size() {
		return _size;
    }

    public boolean empty() {
		return _size == 0;
    }
    // returns true if v is not the header node
    public boolean hasPrevious(DNode<E> v) {
		return v != _header;
    }
    // returns true if v is not the trailer node
    public boolean hasNext(DNode<E> v) {
		return v != _trailer;
    }
    
    public DNode<E> getFirst() {
		if (empty()) throw new IllegalStateException("empty list");
		return _header.getNext();
    }

    public DNode<E> getLast() {
		if (empty()) throw new IllegalStateException("empty list");
		return _trailer.getPrevious();
    }


    public DNode<E> getPrevious(DNode <E> current) {
		if (!hasPrevious(current))
	 	   throw new IllegalArgumentException("cannot move back past header");
		return current.getPrevious();
    }

    public DNode<E> getNext(DNode<E> current) {
		if (!hasNext(current))
	  	  throw new IllegalArgumentException("cannot move forward past trailer");
		return current.getNext();
    }

    //*******************************************************************
    // inserts node a before node b. 
    // An exception is thrown if b is the header
    public void addBefore(DNode<E> b, DNode<E> a) {
		if (_header == b)
			throw new IllegalArgumentException("Cannot insert a node before the header");
		DNode<E> temp = b.getPrevious();
		temp.setNext(a);
		a.setPrevious(temp);
		a.setNext(b);
		b.setPrevious(a);
		_size++;
    }

    public void addLast(DNode<E> node) {
		DNode<E> temp = _trailer.getPrevious();
		_trailer.setPrevious(node);
		node.setNext(_trailer);
		node.setPrevious(temp);
		temp.setNext(node);
		_size++;
    }

    // Needed for the List interface.
    public void add(E value) {
        addLast(new DNode<E>(value, _trailer.getPrevious(), _trailer));
    }


    //*******************************************************************
    // inserts node b after node a
    // throw exception if b is the trailer node
    public void addAfter(DNode<E> a, DNode<E> b) {
		if (_trailer == b)
			throw new IllegalArgumentException("Cannot insert a node after the trailer");
		DNode<E> temp = a.getNext();
		temp.setPrevious(b);
		b.setNext(temp);
		b.setPrevious(a);
		a.setNext(b);
		_size++;
    }


    public void addFirst(DNode<E> current) {
		addAfter(_header,current);
    }

    public void addFirst(E value) {
		addFirst(new DNode<E>(value,null,null));
    }
    
    public void add(int index, E val) {
    	if (index < 0 || index > size())
    		throw new IndexOutOfBoundsException("Can't add to this index");
    	if (index == 0)
    		addFirst(val);
    	else
    		addAfter(getNode(index - 1), new DNode<E>(val, null, null));
    }


   //*************************************************************
    // post: returns the (i+1)th DNode of the DLinkedList.
    //       Start at the _header when (i+1) is in the first half off
    //       the list; otherwise start at _trailer.
    public DNode<E> getNode(int i) {
		if (i < 0 || i >= size())
	 	   throw new IndexOutOfBoundsException("index < 0 || index >= size()");
	 	if (i < _size / 2) {
	 		DNode<E> temp = _header.getNext();
	 		for (int n = 0; n < i; n++)
	 			temp = temp.getNext();
	 		return temp;
	 	} else {
	 		DNode<E> temp = _trailer.getPrevious();
	 		for (int n = _size - 1; n > i; n--)
	 			temp = temp.getPrevious();
	 		return temp;
	 	}
    }
    
    public E get(int i) {
		return getNode(i).getValue();
    } 
    
    //****************************************************************
    // post: sets the value of the (i+1)th DNode to obj then returns
    //       the old value stored at the index.
    public  E set(int index, E obj) {
		return getNode(index).setValue(obj);
    }

    
    //*******************************************************************
    //precondition: v != null and is a node in the list
    //postconditon: removes the DNode which v refers to.
    //              Throws exception if v is header or trailer.
    public void remove(DNode<E> v) {
        if (v == _header || v == _trailer)
        	throw new IllegalArgumentException("Cannot remove the header or trailer");
        v.getPrevious().setNext(v.getNext());
        v.getNext().setPrevious(v.getPrevious());
        _size--;
    }

    // postcondition: removes the 1st DNode and returns the value stored
    //                in the removed DNode
    public E removeFirst() {
		E val = _header.getNext().getValue();
		remove(_header.getNext());
		return val;
    }

    // postcondition: removes the last DNode and returns the value stored
    //                in the removed DNode
    public E removeLast(){
        E val = _trailer.getPrevious().getValue();
        remove(_trailer.getPrevious());
        return val;
    }
    // postcondtion: removes the (i+1)th value from the DNode
    public E remove(int i){
		if (i < 0 || i >= size())
		    throw new IndexOutOfBoundsException("i < 0 || i >= size");
		E val = getNode(i).getValue();
		remove(getNode(i));
		return val;
    }

	public void takeAll(DLinkedList<E> rhs) {
		if (rhs == this || rhs == null || rhs.empty())
			return;
		if (empty())
			_header.setNext(rhs.getFirst());
		else
			getLast().setNext(rhs.getFirst());
		_tailer = rhs._trailer;
		rhs._header.setNext(rhs._trailer);
		rhs._trailer.setPrevious(rhs._header);
		_size += rhs._size;
		rhs._size = 0;
	}
    

    //*******************************************************************   
    public String toString() {
		String ans = "";
		DNode current = _header.getNext();
		while (current != _trailer){
			ans += current.getValue() + ", ";
	    	current = current.getNext();
		}
	
		int len = ans.length();
		if (len > 0) ans = ans.substring(0,len - 2);
		ans = "[" + ans + " ]";
		return ans;
    }




    public static void main(String [] args){
		DLinkedList<Integer> L = new DLinkedList<Integer>();
		
		System.out.println("*********testing  add **************");
        System.out.println("L : " + L);
        for (int i = 0; i < 5; i++){
            L.add(i);
            System.out.println("add " + i + " : " + L);
     	}

		System.out.println("*********testing  addFirst **************");
		for (int i = -1; i > -5; i--){
      	      L.addFirst(i);
      	      System.out.println("addFirst " + i + " : " + L);
     	}

		System.out.println("*********testing  get **************");
		for(int i = 0; i < 9; i++){
		    System.out.println("get " + i + " : " + L.get(i));
		}
		
		System.out.println("*********testing  set **************");
		System.out.println("L : " + L);
     	   for (int i = 0; i < L.size(); i++){
		    int r = (int)(Math.random() * (L.size() - i));
		    System.out.println("swap " + L.get(i)  + " and " + L.get(r));
	 	    L.set(i, L.set(r,L.get(i)));
		    System.out.println("L : " + L);
		}
		
		System.out.println("*********testing  remove **************");
		int i;
		System.out.println("L : " + L);
    	while (!L.empty()) {
		   	i = (int)(Math.random() * L.size());
		   	System.out.println("remove " + i + " : " + L.remove(i));
		   	System.out.println("L : " + L);
		}
		
    }
}
