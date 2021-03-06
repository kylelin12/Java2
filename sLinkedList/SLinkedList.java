public class SLinkedList implements List{

    // private attributes
    private Node _head, _tail; // _head refers to first node, _tail the last
    private int _size;  // # of elements in the list


    // Constructors
    public SLinkedList(){
		_head = _tail = null;
		_size = 0;
    }
    


    // ************  Accessors Methods *************************
    /* satisfies  List interface requirements */
    // 
    public String get(int index){
		if (index < 0 || index >= size())
		    throw new IndexOutOfBoundsException("index < 0 || index >= size()");
		Node temp = _head;
		for (int i = 0; i < index; i++)
			temp = temp.getNext();
		return temp.getValue();
	}

    public int size(){
		return _size;
    }
    
    // ************* Modifier Methods **************************
    /* required by List interface. */
    // postcondition: adds val to the end of the list
    public boolean add(String val){
		if (_tail != null) {
			_tail.setNext(new Node(val));
			_tail = _tail.getNext();
		} else {
			_head = _tail = new Node(val);
		}
		_size++;
		return true;
    }

    // postcondition: inserts val at index
    //               
    public void add(int index, String val){
		if (index > size() || index == -1)
			throw new IndexOutOfBoundsException("index > size + 1");
		if (index == size())
			add(val);
		else {
			Node insert = new Node(val);
			if (index == 0) {
				insert.setNext(_head);
				_head = insert;
			} else {
				Node cur = _head;
				for (int i = 1; i < index; i++)
					cur = cur.getNext();
				insert.setNext(cur.getNext());
				cur.setNext(insert);
			}
			_size++;
		}
    }	
    
    // postcondition: places val at position index; returns
    //                old value at the index.
    //                Throws an IndexOutOfBoundsException()
    public String set(int index, String val){
		if (index > size() || index == -1)
			throw new IndexOutOfBoundsException("index > size + 1");
		Node h = _head;
		for (int i = 0; i < index; i++)
			h = h.getNext();
		return h.setValue(val);
    }
    
    // postcondition: removes and returns the value stored at index.
    //                Throws an IndexOutOfBoundsException
    public String remove(int index){
		if (index > size() || index == -1)
			throw new IndexOutOfBoundsException("index > size + 1");
		String ans;
		if (size() == 1) {
			ans = _head.getValue();
			_head = _tail = null;
			_size--;
			return ans;
		} else if (index == 0) {
			ans = _head.getValue();
			_head = _head.getNext();
			_size--;
			return ans;
		} else {
			Node h = _head;
			for (int i = 0; i < index - 1; i++) 
				h = h.getNext();
			ans = h.getNext().getValue();
			Node a = h.getNext().getNext();
			h.setNext(a);
			_size--;
			return ans;
		}
    }
    
    public SLinkedList append(SLinkedList L) {
    	SLinkedList ans = new SLinkedList();
    	Node t = this._head;
		for (int i = 0; i < 2; i++) {
			while (t != null) {
				ans.add(t.getValue());
				t = t.getNext();
			}
			t = L._head;
		}
		return ans;
    }
    
    public Node getNode(int index) {
    	if (index < 0 || index >= size())
		    throw new IndexOutOfBoundsException("index < 0 || index >= size()");
		Node temp = _head;
		for (int i = 0; i < index; i++)
			temp = temp.getNext();
		return temp;
    }
    
    public void swap(Node x, Node y) {
    	if (x == y) return;
		Node prevX = new Node(null, _head);
		while (prevX.getNext() != x && prevX.getNext() != y)
			prevX = prevX.getNext();
		Node temp;
		if (prevX.getNext() == y) {
			temp = x;
			x = y;
			y = temp;
		}
		Node prevY = x;
		while (prevY.getNext() != y)
			prevY = prevY.getNext();
		if (_head == x) _head = y;
		if (_tail == y) _tail = x;
		prevX.setNext(y);
		prevY.setNext(x);
		Node afterY = y.getNext();
		y.setNext(x.getNext());
		x.setNext(afterY);
    }

	public void reverse() {
		Node temp = null;
		Node left = _tail = _head;
		while (left.getNext() != null) {
			Node right = left.getNext();
			left.setNext(temp);
			temp = left;
			left = right;
		}
		_head = temp;
	}


    // overwrite toString
    public String toString(){
        String ans = "";
        Node t = _head;
        while (t != null){
            ans += t.getValue() + ",";
            t = t.getNext();
        }
        // remove trailing comma
        if (ans.length() > 0) ans = ans.substring(0, ans.length() - 1);
        ans = "[" + ans + "]";
        return ans;
    }



    
}
