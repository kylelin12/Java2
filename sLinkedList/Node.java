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
    
    
}
