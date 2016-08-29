import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairsIntergerOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<List<Integer>> getSuitePairs(int[] arrays, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		
		Arrays.sort(arrays);
		
		int max = sum - arrays[0];
		
		if (max <= arrays[0] ) {
			return result;
		}
		
		int range = 0;
		for (; range<arrays.length; range++) {
			if (arrays[range] > max) {
				break;
			}
		}
		
		for (int i = 0; i<range ; i++) {
			
		}
		
		return result;
	}
}
