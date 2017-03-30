/
/**
 *  Code is based on :
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Quick {

 
    public static void sort(int[] a){
	sort(a, 0, a.length);
    }

    // quicksort the subarray from a[lo] to a[hi - 1]
    private static void sort(int[] a, int lo, int hi) { 
        if ( hi - lo < 2) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j);
        sort(a, j+1, hi);
    }

    // partition the subarray a[lo..hi-1] so that a[lo..j-1] <= a[j] <= a[j+1..hi-1]
    // and return the index j.
    private static int partition(int[] a, int lo, int hi) {
        int left = lo;
        int right = hi;
	hi--;
        int v = a[lo];
        while (true) { 

            // find item on lo to swap
            while (a[++left] < v)
                if (left == hi) break;

            // find item on hi to swap
            while (v < a[--right])
                if (right == lo) break;      // redundant since a[lo] acts as sentinel

            // check if pointers cross
            if (left >= right) break;
	    System.out.println("left = " + left + " right = " + right);
            exch(a, left, right);
	    show(a);
        }
	System.out.println("lo = " + lo + " right = " + right);
        // put partitioning item v at a[j]
        exch(a, lo, right);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return right;
    }

        
    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    // print array to standard output
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " " );
        }
	System.out.println();
    }

    public static void main(String[] args) {
        int [] a = {3,8,2,1,7,9,4};
	show(a);
	partition(a,0,a.length);
	show(a);
      	sort(a);
	show(a);
    }
    

}
