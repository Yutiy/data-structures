package stack;

/**
 * Author: yutiy
 * Date: 2020/12/14 下午10:57
 * Email: 494657028@qq.com
 */
public interface Stack<T> {
    void push(T ele);
    T pop();
    T peek();
    int getSize();
    boolean isEmpty();
}
