public class Partition{

    public static void printArray(int [] data) {
	for(int x: data)
	    System.out.print(x + " ");
	System.out.println();
    }
    // returns a random array of 0 and 1, N is the length
    public static int[] sample(int n) {
	int [] ans = new int[n];
	for(int i = 0; i < n; i++)
	    ans[i] = (int)(Math.random() * 3);
	return ans;
    }

    
    
    // *************** QUESTION 1 *****************************************
    // precondition: 0 <= i,j < data.length
    // postcondition: swaps the values at positions i and j in data[]
    public static void exch(int[] data, int i , int j) {
	int t = data[i];
	data[i] = data[j];
	data[j] = t;
    }
        // *************** QUESTION 2 *****************************************
    // precondition: data != null
    // postcondition: returns true if data is sorted in ascending order;
    //                false otherwise
    public static boolean isSorted(int[] data) {
	for (int i = 0; i < data.length - 1; i++) {
	    if (data[i] > data[i + 1])
		return false;
	}
	return true;
    }

    // *************** QUESTION 3 *****************************************
    // precondition: data.length != null
    //               has at most 2 different values.
    public static void partition(int[] data) {
	if (!isSorted(data)) {
	    int m = min(data, 0, data.length);
	    int l = 0;
	    int r = data.length - 1;
	    while (l < r) {
		if (data[l] > m) {
		    exch(data, l, r--);
		} else {
		    l++;
		}
	    }
	}
    }

    public static void dutch(int[] data, int lower, int upper) {
	int min = Integer.MAX_VALUE;
	for (int i = lower; i < upper; i++) {
		if (min > data[i])
			min = data[i];
	}
	int low = lower, high = upper - 1;
	while (low < high) {
		if (data[low] == min) low++;
		else if (data[high] == min) {
			exch(data, low, high);
			high--;
			low++;
		}
		else high--;
	}
	if (!isSorted(data))
		partition(data, low, upper);	
    }

    public static int min(int[] data, int lower, int upper) {
	int min = data[lower];
	for (int i = lower; i < data.length; i++) {
	    if (data[i] < min) {
		min = data[i];
	    }
	}
	return min;
    }
    
    public static void main(String [] args){
	int start = 1;
	int [] data;
	for (int i = start; i < 50; i++){
	    data = sample(i);
	    System.out.print("orig: ");
	    printArray(data);
	    dutch(data, 0, data.length);
	    System.out.print("sort: ");
	    printArray(data);
	    if (isSorted(data))
		System.out.println("***** SORTED **** ");
	    else
		System.out.println("***** NOT SORTED **** ");
	}
	

    }
}
    


