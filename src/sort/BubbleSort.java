package sort;

/**
 * Author: yutiy
 * Date: 2020/12/13 下午3:23
 * Email: 494657028@qq.com
 */
public class BubbleSort {
    private BubbleSort() {}

    public static <T extends Comparable<T>> void sort(T[] data) {
        // 外层表示循环次数，内层表示比较次数
        for(int i = 0; i < data.length - 1;) {
            int swapIndex = 0;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swapIndex = j + 1;
                    SortingHelper.swap(data, j, j + 1);
                }
            }
            i = data.length - swapIndex;
        }
    }

    public static void main(String[] args) {
        Integer[] data = {1, 3, 2, 5, 6, 4};
        BubbleSort.sort(data);

        for (int ele : data) {
            System.out.print(ele + "");
        }
        System.out.println();
    }
}
