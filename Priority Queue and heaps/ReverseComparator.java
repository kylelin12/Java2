import java.util.Comparator;

public class ReverseComparator < T > implements Comparator < T > {

	public int compare(T a, T b) throws ClassCastException {
		return ((Comparable < T > ) b).compareTo(a);
	}

}
