import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class IteratorAssignment {

	// For-each loop
	public static int countEvensFE(List<Integer> L) {
		int evens = 0;
		for (Integer x : L)
			if (x % 2 == 0)
				evens++;
		return evens;
	}
	
	// Using iterator directly
	public static int countEvensI(List<Integer> L) {
		Iterator<Integer> itr = L.iterator();
		int evens = 0;
		while (itr.hasNext()) {
			if (itr.next() % 2 == 0);
			evens++;
		}
		return evens;
	}
	
	// Using the get(int index) method
	public static int countEvensG(List<Integer> L) {
		int evens = 0;
		for (int i = 0; i < L.size(); i++) {
			if (L.get(i) % 2 == 0)
				evens++;
		}
		return evens;
	}
	
	public static void main(String[] args) {
		List<Integer> numbersA = new ArrayList<Integer>();
		List<Integer> numbersL = new LinkedList<Integer>();
		for (int i = 0; i < 100000; i++) {
			numbersA.add(i);
			numbersL.add(i);
		}
		System.out.println(countEvensFE(numbersA));
		System.out.println(countEvensI(numbersA));
		System.out.println(countEvensG(numbersA));
		System.out.println(countEvensFE(numbersL));
		System.out.println(countEvensI(numbersL));
		System.out.println(countEvensG(numbersL));
	}
}
