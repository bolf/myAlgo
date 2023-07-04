package sprint3;

public class BrokenArray {
    public static int brokenSearch(int[] arr, int k) {
        int left = 0;
        int lastInd = arr.length-1;
        int right = lastInd;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[lastInd]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return binSearchWithOffset(arr,k,0, lastInd, left);
    }

    private static int binSearchWithOffset(int[] arr, int k, int start, int end, int off) {
        int m = addOff((start + end) / 2, off, arr.length);
        int mItem = arr[m];
        int mPrev = Integer.MIN_VALUE;
        while (m != mPrev) {
            mPrev = m;
            if (mItem < k)
                start = extractOff(m,off,arr.length) + 1;
            else if (mItem > k)
                end = extractOff(m,off,arr.length) - 1;
            else
                return m;
            m = addOff((start + end) / 2, off, arr.length);
            mItem = arr[m];
        }
        return -1;
    }

    private static int addOff(int ind, int off, int arrLength) {
        return (ind + off) % arrLength;
    }

    private static int extractOff(int ind, int off, int arrLength) {
        int t = ind - off;
        if (t < 0)
            return arrLength + t;
        return t;
    }

    public static void main(String[] args) {
        int[] arr = {5,1};
        System.out.println(brokenSearch(arr, 1));
    }
}