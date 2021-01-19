package sort;

import java.util.Random;

/**
 * Author: yutiy
 * Date: 2020/12/13 上午12:46
 * Email: 494657028@qq.com
 */
public class SortingHelper {
    private SortingHelper() {}

    public static <T> void swap(T[] data, int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] data) {
        for(int i = 1; i < data.length; i++) {
            if (data[i - 1].compareTo(data[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    public static <T extends Comparable<T>> void sortTest(String sortName, T[] data) throws Throwable {
        long startTime = System.nanoTime();
        Integer[] a = {1, 2, 4, 6, 5, 3};
        Class.forName(sortName).getDeclaredMethod("test1", Object[].class).invoke(null, (Object) a);

        long endTime = System.nanoTime();
        double time = endTime - startTime / 1000000000.0;

        if (!SortingHelper.isSorted(data)) {
            throw new RuntimeException("sort failed");
        }
        System.out.println(time + "s");
    }
}
