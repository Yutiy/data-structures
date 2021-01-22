package sort;

/**
 * Author: yutiy
 * Date: 2020/12/13 下午3:22
 * Email: 494657028@qq.com
 */
public class RadixSort {
    private RadixSort() {}

    public static <T extends Comparable<T>> void sort(T[] data, int maxDigit) {
        int mod = 10;
        int dev = 1;

        int[] result = new int[10];
        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            for(int j = 0; j < data.length; j++) {
                int bucket = ((int)data[j] % mod) / dev;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] data = {1, 3, 2, 5, 6, 4};
        RadixSort.sort(data, 1);

        for (int ele : data) {
            System.out.print(ele + "");
        }
        System.out.println();
    }
}
