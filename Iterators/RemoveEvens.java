import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class RemoveEvens {

    // uses get
    // ArrayList O(n)
    // LinkedList O(n*n)
    public static void removeEvens(List<Integer> L) {
		for (int i = 0; i < L.size(); i++){
		if (L.get(i) % 2 == 0)
			L.remove(i);
		}
    }
   
	// uses an iterator
	// ArrayList O(n)
	// LinkedList O(n)
    public static void removeEvens2(List<Integer> L) {
		Iterator<Integer> itr = L.iterator();
		while (itr.hasNext()){
			if (itr.next() % 2 == 0)
			itr.remove();
		}
    }

    public static void main(String [] args) {
		List<Integer> L1 = new ArrayList<Integer>();
		List<Integer> L2 = new ArrayList<Integer>();
		List<Integer> L3 = new LinkedList<Integer>();
		List<Integer> L4 = new LinkedList<Integer>();
		// initialize
		for (int i = 0; i < Integer.parseInt(args[0]); i++){
		    L1.add(i);
		    L2.add(i);
		    L3.add(i);
		    L4.add(i);
		}
       	System.out.println("AL remove with get ");
		removeEvens(L1);
		System.out.println("AL remove with iterator " );
		removeEvens2(L2);
		System.out.println("LL remove with get ");
		removeEvens(L3);
		System.out.println("LL remove with iterator " );
		removeEvens2(L4);
    }
}
