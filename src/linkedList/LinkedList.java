package linkedList;

/**
 * Author: yutiy
 * Date: 2020/12/17 上午11:20
 * Email: 494657028@qq.com
 */
class Node<T> {
    public T ele;
    public Node<T> next;

    public Node(T ele, Node<T> next){
        this.ele = ele;
        this.next = next;
    }

    public Node(T ele){
        this(ele, null);
    }

    public Node(){
        this(null, null);
    }

    @Override
    public String toString(){
        return ele.toString();
    }
}

public class LinkedList<T> {
    private Node<T> dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node<T>();
        size = 0;
    }

    public void add(int index, T ele) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node<T> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node<T>(ele, prev.next);
        size++;
    }

    public T get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node<T> curr = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.ele;
    }

    // 获得链表的第一个元素
    public T getFirst(){
        return get(0);
    }

    // 获得链表的最后一个元素
    public T getLast(){
        return get(size - 1);
    }

    public void set(int index, T ele) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }

        Node<T> curr = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        curr.ele = ele;
    }

    public boolean contains(T ele) {
        Node<T> curr = dummyHead.next;

        while(curr != null) {
            if (curr.ele == ele) {
                return true;
            } else {
                curr = curr.next;
            }
        }
        return false;
    }

    public T remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        Node<T> prev = dummyHead;
        for(int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node<T> retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.ele;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public T removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public T removeLast(){
        return remove(size - 1);
    }

    public void removeElement(T ele) {
        Node<T> prev = dummyHead;
        while(prev.next != null) {
            if (prev.next.ele.equals(ele)) {
                break;
            } else {
                prev = prev.next;
            }
        }

        if (prev.next != null) {
            Node<T> delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    // 获取链表中的元素个数
    public int getSize(){
        return size;
    }

    // 判断链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node<T> curr = dummyHead.next;

        while(curr != null){
            res.append(curr).append("->");
            curr = curr.next;
        }

        res.append("NULL");
        return res.toString();
    }
}
