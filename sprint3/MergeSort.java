package sprint3;

import java.util.Arrays;

public class MergeSort { //the perverted version
	public static int[] merge(int[] arr, int left, int mid, int right) {
		var resArr = new int[right - left];
		int i = 0, aI = left, bI = mid;
		for (; aI < mid && bI < right; i++) {
			if (arr[aI] <= arr[bI]) {
				resArr[i] = arr[aI++];
			} else {
				resArr[i] = arr[bI++];
			}
		}
		while (aI < mid) {
			resArr[i++] = arr[aI++];
		}
		while (bI < right) {
			resArr[i++] = arr[bI++];
		}
		return resArr;
	}

	public static void merge_sort(int[] array, int left) {
		if (array.length == 1) {
			return;
		}

		var l = Arrays.copyOfRange(array, left, array.length/2);
		merge_sort(l, 0);

		var r = Arrays.copyOfRange(array, array.length/2, array.length);
		merge_sort(r,0);

		var t = new int[array.length];
		System.arraycopy(l,0,t,0,l.length);
		System.arraycopy(r,0,t,l.length,r.length);
		var tt = merge(t,0,t.length/2,t.length);
		System.arraycopy(tt,0,array,0,tt.length);
	}

	public static void main(String[] args) {
		int[] a = {1, 4, 9, 2, 10, 11};
		int[] b = merge(a, 0, 3, 6);
		int[] expected = {1, 2, 4, 9, 10, 11};
		System.out.println(Arrays.equals(b, expected));
		System.out.println(Arrays.toString(b));
		int[] c = {1, 4, 2, 10, 1, 2};
		merge_sort(c, 0);
		int[] expected2 = {1, 1, 2, 2, 4, 10};
		System.out.println(Arrays.equals(c, expected2));
		System.out.println(Arrays.toString(c));
	}
}