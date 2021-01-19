package sort;

/**
 * Author: yutiy
 * Date: 2020/12/13 下午3:22
 * Email: 494657028@qq.com
 */
public class ShellSort {
    private ShellSort() {}

    public static <T extends Comparable<T>> void sort(T[] data) {

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
