package relab;

public class ArraySum {
	public int sumOfArray(Integer[] a, int index) {
		
		if (0 > index) {
			return 0;
		}
		
		return a[index] + sumOfArray(a, index - 1);
}
}