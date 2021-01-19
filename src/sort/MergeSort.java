package sort;

/**
 * Author: yutiy
 * Date: 2020/12/13 下午2:53
 * Email: 494657028@qq.com
 */
public class MergeSort {
    private MergeSort() {}

    public static <T extends Comparable<T>> void sort(T[] data) {
        int len = data.length;
    }

    private static <T extends Comparable<T>> void _merge(T[] data, int start, int end) {
        if (data.length > 2) {

        }
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
