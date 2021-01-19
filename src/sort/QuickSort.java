package sort;

/**
 * Author: yutiy
 * Date: 2020/12/13 下午3:21
 * Email: 494657028@qq.com
 */
public class QuickSort {
    private QuickSort() {}

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p]; arr[p+1...r] > arr[p]
    private static <T extends Comparable<T>> int partition(T[] arr, int l, int r){
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        SortingHelper.swap(arr, l, (int)(Math.random()*(r - l + 1)) + l);

        int j = l;
        T pivot = arr[l];

        for(int i = j + 1; i <= r; i++) {
            if(arr[i].compareTo(pivot) < 0){
                j++;
                SortingHelper.swap(arr, j, i);
            }
        }

        SortingHelper.swap(arr, l, j);
        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static <T extends Comparable<T>> void sort(T[] arr, int l, int r){
        // 对于小规模数组, 使用插入排序
        if(r - l <= 15){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static <T extends Comparable<T>> void sort(T[] data) {
        int n = data.length;
        sort(data, 0, n - 1);
    }

    public static void main(String[] args) {
        Integer[] data = {1, 3, 2, 5, 6, 4};
        QuickSort.sort(data);

        for (int ele : data) {
            System.out.print(ele + "");
        }
        System.out.println();
    }
}
