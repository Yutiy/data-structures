package heap;

import array.Array;

/**
 * Author: yutiy
 * Date: 2021/1/1 下午8:13
 * Email: 494657028@qq.com
 */
public class MaxHeap<T extends Comparable<T>> {
    private Array<T> heap;

    public MaxHeap() {
        heap = new Array<>();
    }

    public MaxHeap(int capacity) {
        heap = new Array<>(capacity);
    }

    // heapify: 讲任意数组整理成堆的形状 O(n)
    public MaxHeap(T[] arr) {
        heap = new Array<>(arr);
        if (arr.length != 1) {
            // 从最后一个非叶子节点开始，逐个siftDown
            for(int i = getParentIndex(arr.length - 1); i >= 0; i--) {
                siftDown(i);
            }
        }
    }

    public int size() {
        return heap.getSize();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // 向堆中添加元素
    public void add(T ele) {
        heap.addLast(ele);
        siftUp(heap.getSize() - 1);
    }

    // 看堆中最大元素
    public T findMax() {
        if(heap.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        return heap.get(0);
    }

    // 取出元素，只能取出最大的那个元素
    public T extractMax() {
        T ret = findMax();

        heap.swap(0,  heap.getSize() - 1);
        heap.removeLast();
        siftDown(0);

        return ret;
    }

    // 取出堆中最大的元素，并且替换成元素ele
    public T replace(T ele) {
        T ret = findMax();
        heap.set(0, ele);
        siftDown(0);
        return ret;
    }

    private void siftUp(int k) {
        while(k > 0 && heap.get(k).compareTo(heap.get(getParentIndex(k))) > 0) {
            heap.swap(k, getParentIndex(k));
            k = getParentIndex(k);
        }
    }

    private void siftDown(int k) {
        while(getLeftIndex(k) < heap.getSize()) {
            int j = getLeftIndex(k);
            if (j + 1 < heap.getSize() && heap.get(j + 1).compareTo(heap.get(j)) > 0) j++;

            if (heap.get(k).compareTo(heap.get(j)) > 0) break;
            heap.swap(k, j);
            k = j;
        }
    }

    private int getParentIndex(int k) {
        return (k - 1) / 2;
    }

    private int getLeftIndex(int k) {
        return 2 * k + 1;
    }

    private int getRightIndex(int k) {
        return 2 * k + 2;
    }

    // 测试 MaxHeap
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0; i < N; i++)
            maxHeap.add( new Integer((int)(Math.random() * M)) );

        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for( int i = 0; i < N; i++){
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for( int i = 1; i < N; i++)
            assert arr[i-1] >= arr[i];
    }
}
