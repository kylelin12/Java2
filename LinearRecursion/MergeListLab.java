import java.util.List;
import java.util.ArrayList;

public class MergeListLab{
    // precondition: aLow <= bLow and bLow <= bHigh
    //               the data within [aLow, bLow) is sorted in ascending order
    //               the data within [bLow, bHigh) is sorted in ascending order
    // postcondtion : Without using any additional data structure
    //                the data within [aLow, bHigh) is sorted in ascending order
    public static void mergeInPlace(List<Integer> data, int aLow, int bLow, int bHigh){
	if (bLow < bHigh) {
	    int i = bLow;
	    while (i > aLow && data.get(i - 1) > data.get(i)) {
		int temp = data.get(i);
		data.set(i, data.get(i - 1));
		data.set(i - 1, temp);
		i--;
	    }
	    mergeInPlace(data, aLow, bLow + 1, bHigh);
	}
    }
    
    // precondtion: aLow <= bLow, bLow <= bHigh
    //              the data within [aLow, bLow) is sorted in ascending order
    //              the data within [bLow, bHigh) is sorted in ascending order
    // postcondition: return of copy of the data in ascending order
    public static List<Integer> merge(List<Integer> data, int aLow, int bLow, int bHigh){
	int size = bHigh - aLow;
	int aIndex = aLow;
	int bIndex = bLow;
	List<Integer> merged = new ArrayList<Integer>();
	while (merged.size() < size) {
	    int a = data.get(aIndex);
	    int b = data.get(bIndex);
	    if (bIndex < bHigh && aIndex < bLow) {
		if (b > a) {
		    merged.add(a);
		    aIndex++;
		} else {
		    merged.add(b);
		    bIndex++;
		}
	    } else if (bIndex < bHigh) {
		merged.add(b);
		bIndex++;
	    } else {
		merged.add(a);
		aIndex++;
	    }
	}
	return merged;
    }

    public static void main(String [] args){
	int[] d = {1,3,5,8,2,6,11};
	List<Integer> data1 = new ArrayList<Integer>();
	List<Integer> data2 = new ArrayList<Integer>();
	for (int x : d){
	    data1.add(x);
	    data2.add(x);
	}
	
	System.out.println("****** Merge In Place *******");
	System.out.println(data1);
	mergeInPlace(data1,0,4,7);
	System.out.println(data1);

	System.out.println("****** Merge  *******");
	System.out.println(data2);
	data2 = merge(data2,0,4,7);
	System.out.println(data2);
	

    }
}
