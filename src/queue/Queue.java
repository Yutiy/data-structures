package queue;

/**
 * Author: yutiy
 * Date: 2020/12/15 上午12:51
 * Email: 494657028@qq.com
 */
public interface Queue<T> {
    void enqueue(T ele);
    T dequeue();
    T getFront();
    int getSize();
    boolean isEmpty();
}
