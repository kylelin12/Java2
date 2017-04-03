public class NodeQueue<E> implements Queue<E>{


    private Node<E> _head,_tail;
    private int _size;

    // constructor 
    public NodeQueue(){
	// **** Your Code Goes Here ****
    }

    public int size() {
	return _size;
    }

    public boolean empty(){
	return size() == 0;
    }

    public E front() throws EmptyQueueException{
	// **** Your Code Goes Here ****
    }

    public E dequeue() throws EmptyQueueException{
		// **** Your Code Goes Here ****
    }

    public void  enqueue(E value){
		// **** Your Code Goes Here ****
    }

    public String toString(){
	String ans = "[";
	if (size() > 0) ans += front();
	if (size() > 1){
	    Node<E> curr = _head.getNext();
	    while (curr != null){
		ans += ", "  + curr.getValue();
		curr = curr.getNext();
	    }
	}
	ans += "]";
	return ans;
    }

    public static void main(String [] args){
        Queue<Integer> q = new NodeQueue<Integer>();
        System.out.println(q);
	/*
        for (int i = 0; i < 5 ; i++){
            q.enqueue(i);
            System.out.println("enqueue : " + i + " q: " + q);
        }

        while (!q.empty()){
            if (Math.random() < 0.75)
                System.out.println("dequeue " + q.dequeue() + " q: " + q);
            else {
                int x = (int)(Math.random() * 100) ;
                q.enqueue(x);
                System.out.println("enqueue : " + x + " q: " + q);
            }
        }

	*/
    }




}
