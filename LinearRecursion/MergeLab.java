public class MergeLab{

    // Insertion Sort: O(n^2);
    // precondition: aLow <= bLow and bLow <= bHigh
    //               the data within [aLow, bLow) is sorted in ascending order
    //               the data within [bLow, bHigh) is sorted in ascending order
    // postcondtion : Without using any additional data structure
    //                the data within [aLow, bHigh) is sorted in ascending order
    public static void mergeInPlace(int[] data, int aLow, int bLow, int bHigh) {
	/*
	if (aLow < bLow && bLow < bHigh) {
	    if (data[aLow] >= data[bLow]) {
		int placeHolder = data[aLow];
		data[aLow] = data[bLow];
		data[bLow] = placeHolder;
		mergeInPlace(data, aLow, bLow + 1, bHigh);
	    }
	    if (data[aLow] < data[bLow]) {
		int placeHolder = data[aLow + 1];
		data[aLow + 1] = data[bLow];
		data[bLow] = placeHolder;
		mergeInPlace(data, aLow + 1, bLow + 1, bHigh);
	    }
	}
	*/
	/*
	while (bLow < bHigh) {
	    int i = bLow;
	    while (i > aLow && data[i - 1] > data[i]) {
		int temp = data[i];
		data[i] = data[i - 1];
		data[i - 1] = temp;
		i--;
	    }
	    bLow++;
	}
	*/

	if (bLow < bHigh) {
	    int i = bLow;
	    while (i > aLow && data[i-1] > data[i]) {
		int temp = data[i];
		data[i] = data[i - 1];
		data[i - 1] = temp;
		i--;
	    }
	    mergeInPlace(data, aLow, bLow + 1, bHigh);
	}
    }
    
    // precondtion: aLow <= bLow, bLow <= bHigh
    //              the data within [aLow, bLow) is sorted in ascending order
    //              the data within [bLow, bHigh) is sorted in ascending order
    // postcondition: return of copy of the data in ascending order
    public static int[] merge(int[] data, int aLow, int bLow, int bHigh){
	int n = bHigh - aLow;
	int[] merged = new int[n];
	return merged;
    }

    public static void printArray(int[] data) {
	System.out.print("[");
	for (int i = 0; i < data.length - 1; i++)
	    System.out.print(data[i] + ",");
	System.out.println(data[data.length - 1] + "]");
    }

    public static void main(String[] args) {
	
	int[] test = {1, 3, 0, 4};
	mergeInPlace(test, 0, 2, 4);
	printArray(test);
	int[] test1 = {1, 9, 11, 2, 4, 6, 7, 8, 9};
	mergeInPlace(test1, 0, 3, 9);
	printArray(test1);
	int[] test2 = {4, 5, 9, 2, 3, 6, 7, 8, 10};
	mergeInPlace(test2, 0, 3, 9);
	printArray(test2);
	
	/*
	int[] test = {1, 3, 0, 4};
	printArray(merge(test, 0, 2, 4));
	*/
    }
}
