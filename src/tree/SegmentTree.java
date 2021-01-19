package tree;

/**
 * Author: yutiy
 * Date: 2020/12/16 下午5:06
 * Email: 494657028@qq.com
 */
public class SegmentTree<T> {
    private T[] tree;
    private T[] data;
    private Merger<T> merger;

    public interface Merger<T> {
        // 将两个元素融合成一个元素
        T merge(T a, T b);
    }

    public SegmentTree(T[] arr, Merger<T> merger){
        this.merger = merger;

        data = (T[])new Object[arr.length];
        for(int i = 0 ; i < arr.length ; i ++) {
            data[i] = arr[i];
        }

        // 树空间需要差不多四倍大小
        tree = (T[])new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    // 返回区间[queryL, queryR]的值
    public T query(int queryL, int queryR){
        if(queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("Index is illegal.");
        }

        // 在 treeIndex 为根的线段树 [l...r] 范围内，搜索区间 [queryL, queryR] 的值
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    // 将index位置的值，更新为ele
    public void update(int index, T ele) {
        if(index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }

        data[index] = ele;
        update(0, 0, data.length - 1, index, ele);
    }

    public T get(int index) {
        if(index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }

        return data[index];
    }

    public int size() {
        return data.length;
    }

    // 在treeIndex的位置创建表示区间[l...r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r){
        // 存储元素本身
        if(l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = getLeftIndex(treeIndex);
        int rightTreeIndex = getRightIndex(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        // 当前节点存放的值
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int getLeftIndex(int index){
        return 2 * index + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int getRightIndex(int index){
        return 2 * index + 2;
    }

    // 在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
    private T query(int treeIndex, int l, int r, int queryL, int queryR){
        if(l == queryL && r == queryR)
            return tree[treeIndex];

        // treeIndex的节点分为[l...mid]和[mid+1...r]两部分
        int mid = l + (r - l) / 2;
        int leftTreeIndex = getLeftIndex(treeIndex);
        int rightTreeIndex = getRightIndex(treeIndex);

        if(queryL >= mid + 1)
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        else if(queryR <= mid)
            return query(leftTreeIndex, l, mid, queryL, queryR);

        T leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        T rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    // 在以treeIndex为根的线段树中更新index的值为e
    private void update(int treeIndex, int treeLeft, int treeRight, int index, T ele) {
        if (treeLeft == treeRight) {
            tree[treeIndex] = ele;
            return;
        }

        int mid = treeLeft + (treeRight - treeLeft) / 2;
        int leftChildIndex = getLeftIndex(treeIndex);
        int rightChildIndex = getRightIndex(treeIndex);

        if (index <= mid) {
            update(leftChildIndex, treeLeft, mid, index, ele);
        } else if (index >= mid + 1) {
            update(rightChildIndex, mid + 1, treeRight, index, ele);
        }

        //更改完叶子节点后，还需要对他的所有祖辈节点更新
        tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == null) {
                continue;
            }
            builder.append(tree[i]).append(',');
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append(']');
        return builder.toString();
    }

    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};

        SegmentTree<Integer> segTree = new SegmentTree<>(nums, Integer::sum);
        System.out.println(segTree);

        System.out.println(segTree.query(0, 2));
        System.out.println(segTree.query(2, 5));
        System.out.println(segTree.query(0, 5));
    }
}
