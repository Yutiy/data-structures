package queue;

/**
 * Author: yutiy
 * Date: 2020/12/15 下午3:41
 * Email: 494657028@qq.com
 */
public class LoopQueue<T> implements Queue<T> {
    private T[] array;
    private int front;
    private int tail;
    private int size;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        array = (T[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public void enqueue(T ele) {
        if ((tail + 1) % array.length == front) {
            resize(getCapacity() * 2);
        }
        array[tail] = ele;
        tail = (tail + 1) % array.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        T ret = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is Empty");
        }
        return array[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return array.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("queue.Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");

        for(int i = front; i != tail; i = (i + 1) % array.length){
            res.append(array[i]);
            if((i + 1) % array.length != tail)
                res.append(", ");
        }

        res.append("] tail");
        return res.toString();
    }

    private void resize(int newCapacity) {
        T[] newArray = (T[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(i + front) % array.length];
        }
        array = newArray;
        front = 0;
        tail = size;
    }

    public static void main(String[] args){
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 12; i++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
