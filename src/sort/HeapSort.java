package sort;

import heap.MaxHeap;

/**
 * Author: yutiy
 * Date: 2020/12/13 下午3:22
 * Email: 494657028@qq.com
 */
public class HeapSort {
    private HeapSort() {}

    public static <T extends Comparable<T>> void sortByMaxHeap(T[] data) {
        MaxHeap<T> maxHeap = new MaxHeap<>();
        for(T e: data) {
            maxHeap.add(e);
        }

        for (int i = data.length - 1; i >= 0; i--) {
            data[i] = maxHeap.extractMax();
        }
    }

    public static <T extends Comparable<T>> void sort(T[] data) {
        if (data.length <= 1) return;

        // 构建大顶堆
        for(int i = (data.length - 2) / 2; i >= 0; i--) {
            siftDown(data, i, data.length);
        }

        // 执行交换
        for (int i = data.length - 1; i >= 0; i--) {
            swap(data, 0, i);
            siftDown(data, 0, i);
        }
    }

    // 对data[0, n) 所形成的最大堆中，索引为 k 的元素执行 siftDown
    private static <T extends Comparable<T>> void siftDown(T[] data, int k, int n) {
        while(2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && data[j + 1].compareTo(data[j]) > 0) j++;
            if (data[k].compareTo(data[j]) > 0) break;

            // swap
            swap(data, k, j);
            k = j;
        }
    }

    public static <T> void swap(T[] data, int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] data = {1, 3, 2, 5, 6, 4};
        HeapSort.sort(data);

        for (int ele : data) {
            System.out.print(ele + "");
        }
        System.out.println();
    }
}
