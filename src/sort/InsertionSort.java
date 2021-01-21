package sort;

/**
 * Author: yutiy
 * Date: 2020/12/13 上午12:39
 * Email: 494657028@qq.com
 */
public class InsertionSort {
    private InsertionSort() {}

    public static <T extends Comparable<T>> void sort(T[] data) {
        int len = data.length;
        sort(data, 0, len - 1);
    }

    public static <T extends Comparable<T>> void sort(T[] data, int l, int r) {
        for(int i = l + 1; i <= r; i++) {
            T ele = data[i];
            int j = i;

            while(data[j - 1].compareTo(ele) > 0) {
                SortingHelper.swap(data, j - 1, j);
                j--;
            }

            data[j] = ele;
        }
    }

    public static void main(String[] args) throws Throwable {
        int[] dataSize = {10000, 1000000};
        for(int n: dataSize) {
            Integer[] data = SortingHelper.generateRandomArray(n, n);
            SortingHelper.sortTest("sort.InsertionSort", data);
        }
    }
}
