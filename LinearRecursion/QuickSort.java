/*
 * Quicksort Algorithm : Assuming the data is random without many duplicates.
 * Let lower be the lower bound of a region within an array. (inclusive)
 * Let upper be the upper bound of a region within an array. (exclusive)
 **
 * 1. Pick a pivot. (Typically the value at the lower bound of the region.)
 * 2. Read data from left to right until a value that is greater than the pivot is found. 
 *    (Advance left)
 * 3. Read data from right to left until a value that is less than the pivor is found.
 *    (Advance right)
 * 4. If left < right then exchange the data at the positions left and right.
 *    Goto 2.
 * 5. If left >= right then exchange the data at the right and the pivotPosition(lower).
 *    (Placing the pivot).
 * 6. Recursively apply the algorithm to the regions [lower, pivotPosition)
 *    and [pivotPosition + 1, upper).
 */
 
public class QuickSort {
 
 	public static void QuickSort(int[] data) {
 		QuickSort(data, 0, data.length);
 	}
 
 	public static void QuickSort(int[] data, lower, upper) {
 		int pivot = getPivot(data, lower, upper);
 		QuickSort(data, lower, pivot)
 		
 	}
 
	public static void main(String[] args) {
 		
 	}
}

/*
 * QuickSort trace:
 * Data: 3, 8, 2, 1, 7, 9, 4
 * Pivot [3]: (l) 3, 8, 2, 1, 7, 9, 4 (r)
 * (Adv left) 3, (l) 8, 2, 1, 7, 9, 4 (r)
 * (Adv right) 3, (l) 8, 2, 1 (r), 7, 9, 4
 * (Exch l & r) 3, (l) 1, 2, 8 (r), 7, 9, 4
 * (Adv left) 3, 1, 2, (l) 8 (r), 7, 9, 4
 * (Adv right) 3, 1, 2 (r), (l) 8, 7, 9, 4
 * (Exch pivot) 2, 1, 3, 8, 7, 9, 4
 * QuickSort {2, 1}
 * QuickSort {8, 7, 9, 4}
 */
