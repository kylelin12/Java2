import java.util.List;
import java.util.ArrayList;

public class MergeSort{
    
    public static List<Integer> mergeSort(List<Integer> data){
	if (data.length() > 2) {
	    int half = data.length() / 2;
	    mergeSort(data.
	} 
	
    }

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

    public static void main(String[] args){
	int[] d = {85, 2, 12, 33, 45, 3, 4, 11};
	List<Integer> data1 = new ArrayList<Integer>();
	for (int x : d){
	    data1.add(x);
	}

	
    }
}
