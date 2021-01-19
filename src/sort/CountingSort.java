package sort;

import java.util.Arrays;

/**
 * Author: yutiy
 * Date: 2020/12/13 下午3:46
 * Email: 494657028@qq.com
 */
public class CountingSort {
    private CountingSort() {}

    public static void sort(int[] data) {
        int bucketLen = Arrays.stream(data).max().getAsInt() + 1;
        int[] bucket = new int[bucketLen];

        for (int datum: data) {
            bucket[datum]++;
        }

        int pos = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                data[pos++] = j;
                bucket[j]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {1, 3, 2, 5, 6, 4};
        CountingSort.sort(data);

        for (int ele: data) {
            System.out.print(ele + "");
        }
        System.out.println();
    }
}
