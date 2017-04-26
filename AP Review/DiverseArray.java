public class DiverseArray {

	public static int arraySum(int[] arr) {
		int sum = 0;
		for (int x : arr) {
			sum += x;
		}
		return sum;
	}
	
	public static int[] rowSums(int[][] arr2D) {
		int[] ans = new int[arr2D[].length];
		for (int i = 0; i < arr2D.length; i++) {
			ans[i] = arraySum(arr2D[i]);
		}
		return ans;
	}
	
	public static boolean isDiverse(int[][] arr2D) {
		int[] comparator = rowSums(arr2D);
		for (int i = 0; i < comparator.length; i++) {
			for (int j = i + 1; j < comparator.length; j++) {
				if (comparator[i] == comparator[j])
					return false;
			}
		}
		return true;
	}
}
