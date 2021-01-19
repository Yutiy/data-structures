package array;

/**
 * Author: yutiy
 * Date: 2020/12/14 上午12:34
 * Email: 494657028@qq.com
 */
public class Array<T> {
    private T[] data;
    private int size;

    public Array() {
        this(10);
    }

    /**
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public Array(T[] arr) {
        int length = arr.length;
        size = length;
        data = (T[])new Object[length];

        System.arraycopy(arr, 0, data, 0, length);
    }

    // 获取数组中元素个数
    public int getSize() {
        return size;
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 判断数组元素是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向数组末尾添加元素
    public void addLast(T ele) {
        add(size, ele);
    }

    // 向数组前部添加元素
    public void addFirst(T ele) {
        add(0, ele);
    }

    // 获取 index 索引处的元素
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, Index is illegal");
        }
        return data[index];
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    // 修改 index 索引处的元素
    public void set(int index, T ele) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, Index is illegal");
        }
        data[index] = ele;
    }

    // 向数组中 index 处添加元素
    public void add(int index, T ele) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Index is illegal");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = ele;
        size++;
    }

    // 查找数组中是否含有元素 ele
    public boolean contains(T ele) {
        for(int i = 0; i < size; i++) {
            if(ele.equals(data[i])) return true;
        }
        return false;
    }

    // 查找数组中元素 ele 所在元素，如果不存在则返回-1
    public int find(T ele) {
        for(int i = 0; i < size; i++) {
            if(ele.equals(data[i])) return i;
        }
        return -1;
    }

    // 从数组中删除 index 位置处的元素，返回删除的元素
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed, Index is illegal");
        }

        T ret = data[index];
        for(int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;  // loitering objects

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    // 删除数组中第一个元素，并返回删除的元素
    public T removeFirst() {
        return remove(0);
    }

    // 删除数组中最后一个元素，并返回删除的元素
    public T removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素 ele
    public void removeElement(T ele) {
        int index = find(ele);
        if (index != -1) remove(index);
    }

    // 交换数组中两个元素
    public void swap(int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // 动态增减容量
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        if (size >= 0) System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("array.Array: size = %d, capacity = %d\n", data.length, size));
        res.append('[');

        for(int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }

        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }

        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);    // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.remove(2);
        System.out.println(arr);

        int res = arr.removeFirst();
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);
    }
}
