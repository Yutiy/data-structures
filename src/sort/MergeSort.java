package sort;

import java.util.Arrays;

/**
 * Author: yutiy
 * Date: 2020/12/13 下午2:53
 * Email: 494657028@qq.com
 */
public class MergeSort {
    private MergeSort() {}

    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    public static <T extends Comparable<T>> void sort(T[] arr, int l, int r) {
        // 对于小规模数组, 使用插入排序
        // if (l >= r) return;
        if(r - l <= 15){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = (r - l) / 2 + l;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if(arr[mid].compareTo(arr[mid+1]) > 0) {
            _merge(arr, l, mid, r);
        }
    }

    private static <T extends Comparable<T>> void _merge(T[] arr, int l, int mid, int r) {
        T[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid+1;
        for(int k = l; k <= r; k++){
            if(i > mid) {           // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l]; j++;
            } else if(j > r) {      // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l]; i++;
            } else if(aux[i-l].compareTo(aux[j-l]) < 0) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l]; i++;
            } else {                // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l]; j++;
            }
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
