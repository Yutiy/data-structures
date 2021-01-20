package sort;

/**
 * Author: yutiy
 * Date: 2020/12/13 下午2:53
 * Email: 494657028@qq.com
 */
public class MergeSort {
    private MergeSort() {}

    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <T extends Comparable<T>> void sort(T[] arr, int l, int r) {
        if (l < r) return;

        int pivot = (r - l) / 2 + l;
        sort(arr, l, pivot);
        sort(arr, pivot, r);

    }

    private static <T extends Comparable<T>> void _merge(T[] left, T[] right) {

    }

    public static void main(String[] args) {
        Integer[] data = {1, 3, 2, 5, 6, 4};
        MergeSort.sort(data);

        for (int ele : data) {
            System.out.print(ele + "");
        }
        System.out.println();
    }
}
