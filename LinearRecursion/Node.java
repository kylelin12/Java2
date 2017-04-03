public class Node{
    private String _value;
    private Node _next;

    // constructor
    public Node(String value){
	_value = value;
	_next = null;
    }

    public Node (String value, Node next){
	this(value);
	_next = next;
    }

    // accessor methods
    public String getValue(){
	return _value;
    }

    public Node getNext(){
	return _next;
    }

    // mutator methods
    public String setValue(String s){
	String ans = getValue();
	_value = s;
	return ans;
    }

    public Node setNext(Node n){
	Node ans = getNext();
	_next = n;
	return ans;
    }
    
    public static int length(Node h) {
    if (h == null)
    	return 0;
    if (h.getNext() == null)
    	return 1;
    return 1 + length(h.getNext());
    }
    
    public static void print(Node h) {
    	if (h != null) {
			System.out.println(h.getValue());
			print(h.getNext());
		}
    }
    
    public static void printReverse(Node h) {
		if (h != null) {
			printReverse(h.getNext());
			System.out.println(h.getValue());
		}
    }
    
    // Iterative computation of the length of the list
    public static int lengthI(Node h) {
    	int ans = 0;
    	while (h != null) {
    		ans++;
    		h = h.getNext();
    	}
    	return ans;
    }
    
    public static void printI(Node h) {
    	while (h != null) {
    		System.out.print(h.getValue());
    		h = h.getNext();
    	}
    	System.out.println();
    }
    
    public static void printReverseI(Node h) {
    	String output = "";
    	while (h != null) {
    		output = h.getValue() + output;
    		h = h.getNext();
    	}
    	System.out.println(output);
    }
    
    // Adding elements to a list
    // Returns the first Node of the new list.
    public static Node addFirst(Node h, String s) {
    	return new Node(s, h);
    }
    
    public static Node addLast(Node h, String s) {
    	if (h == null) return addFirst(h, s);
    	h.setNext(addLast(h.getNext(), s));
    	return h;
    }
    
    public static Node addLastI(Node h, String s) {
		if (h == null)
			return new Node(s);
		Node r = h;
		while ((h.getNext() != null))
			h = h.getNext();
		h.setNext(new Node(s));
		return r;
    }
    
    public static Node search(Node h, String s) {
    	if (h == null || s.equals(h.getValue())) return h;
    	return search(h.getNext(), s);
    }
    
    public static Node searchI(Node h, String s) {
    	if (h == null || s.equals(h.getValue())) return h;
    	while (!(h == null || s.equals(h.getValue()))) h = h.getNext();
    	return h;
    }
    
    public static Node removeFirstI(Node h, String s) {
    	// removes the first occurence of s from the linked list
    	// starting at h also returns the head of the modified link list.
    	// Node h = ... // h - a - b - a - b - null
    	// h = removeFirst(h, "b"); // h - a - a - b - null
    	if (h == null) return h;
    	Node r = null;
    	while (!s.equals(h.getValue())) {
    		addLastI(r, h.getValue());
    		h = h.getNext();
    	}
    	if (h.getNext() == null)
    		return r;
    	h = h.getNext();
		while (h.getNext() != null) {
			addLastI(r, h.getValue());
			h = h.getNext();
		}
    	return r;
    }
    
    public static void main(String[] args) {
    	String[] test = {"c", "b", "a"};
    	Node head = null;
    	for (String x : test)
    		head = new Node(x, head);
    	System.out.println("**Recursive**");
    	System.out.println("Length = " + length(head));
    	print(head);
    	printReverse(head);
    	System.out.println("**Iterative**");
    	printI(head);
    	printReverseI(head);
    	System.out.println("**Adding Elements**");
    	head = addFirst(head, "k");
    	printI(head);
    	System.out.println("*Recursive*");
    	head = addLast(head, "r");
    	printI(head);
    	System.out.println("*Iterative*");
    	head = addLastI(head, "p");
    	printI(head); 
    	System.out.println("**Searching**");
    	System.out.println("*Recursive*");
    	printI(search(head, "p"));
    	System.out.println("*Iterative*");
    	printI(searchI(head, "p"));
    	System.out.println("**Removal**");
    	System.out.println("*Iterative*");
    	head = removeFirstI(head, "b");
    	printI(head);
    }
    
}

/*
 * The Node Data Type:
 * Store a value. (String)
 * and a reference to another Node.
 * Node Diagram
 * |_value =       |  
 * |_next =        |
 *
 * new Node("a");
 * |_value = "a"   |
 * |_next ---------|-->null
 * |
 * 
 * A Linked List: A recursive data structure
 * Is either empty (null)
 * a node whose _next attribute references a linked list.
 *
 * Empty linked list
 *     null
 * otherwise
 * |_value->  |   |_value->  |   |_value->  |   
 * |_next     |-->|_next     |-->|_next     |-->null
 *
 * Example:
 * Node head = null; // head -> null
 * head = new Node("b"); // head -> b -> null
 * head = new Node("a", head); // head -> a -> b -> null    
 *
 * Evaluate the code.
 * (a) head.getValue(); // "a"
 * (b) head.getNext();  // Node that stores "b"
 * (c) head.getNext().getValue() // "b"
 * (d) head.getNext().getNext() // null
 * (e) head.getNext().getNext().getValue() // Runtime error, Null Pointer exception
 * (f) head = head.getNext();
 *     head.getValue(); // "b"
 *
 * Write code to add "c" to the end of the linked list.
 * head.getNext().setNext(new Node("c"));
 *
 * Write a recursive function to compute the length of the linked list starting at Node h.
 * public static int length(Node h) {
 *     if (h == null)
 *         return 0;
 *     if (h.getNext() == null)
 *         return 1;
 *     return 1 + length(h.getNext());
 * }
 */
