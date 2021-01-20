package sort;

/**
 * Author: yutiy
 * Date: 2020/12/13 下午3:22
 * Email: 494657028@qq.com
 */
public class ShellSort {
    private ShellSort() {}

    public static <T extends Comparable<T>> void sort(T[] data) {
        int n = data.length;

        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n/3) h = 3*h + 1;

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                T e = data[i];
                int j = i;
                for ( ; j >= h && e.compareTo(data[j-h]) < 0 ; j -= h)
                    data[j] = data[j-h];
                data[j] = e;
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        Integer[] data = {1, 3, 2, 5, 6, 4};
        ShellSort.sort(data);

        for (int ele : data) {
            System.out.print(ele + "");
        }
        System.out.println();
    }
}
