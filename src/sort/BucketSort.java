package sort;

/**
 * Author: yutiy
 * Date: 2020/12/13 下午3:22
 * Email: 494657028@qq.com
 */
public class BucketSort {
    private static int bucketSize = 5;
    private BucketSort() {}

    public static <T extends Comparable<T>> void sort(T[] data) {
        int len = data.length;
        T minVal = data[0];
        T maxVal = data[0];

        for (int i = 1; i < len; i++) {
            if (data[i].compareTo(maxVal) > 0) {
                maxVal = data[i];
            }
            if (data[i].compareTo(minVal) < 0) {
                minVal = data[i];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] data = {1, 3, 2, 5, 6, 4};
        BucketSort.sort(data);

        for (int ele : data) {
            System.out.print(ele + "");
        }
        System.out.println();
    }
}
