package sort;

import java.lang.reflect.Method;
import java.lang.Class;
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

    public static void printArray(Object[] arr) {
        for (Object o : arr) {
            System.out.print(o);
            System.out.print(' ');
        }
        System.out.println();
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

    // 生成一个近乎有序的数组
    // 首先生成一个含有[0...n-1]的完全有序数组, 之后随机交换swapTimes对数据
    // swapTimes定义了数组的无序程度:
    // swapTimes == 0 时, 数组完全有序
    // swapTimes 越大, 数组越趋向于无序
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes){
        Integer[] arr = new Integer[n];
        for( int i = 0 ; i < n ; i ++ )
            arr[i] = i;

        for( int i = 0 ; i < swapTimes ; i ++ ){
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }

    public static <T extends Comparable<T>> void sortTest(String sortName, T[] data) {
        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{data};

            long startTime = System.nanoTime();
            sortMethod.invoke(null, params);
            long endTime = System.nanoTime();

            assert isSorted(data);
            double time = endTime - startTime / 1000000000.0;
            System.out.println(sortClass.getSimpleName()+ " : " + time + "s");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
