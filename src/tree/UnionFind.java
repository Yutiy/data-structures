package tree;

/**
 * Author: yutiy
 * Date: 2020/12/13 下午4:01
 * Email: 494657028@qq.com
 */
interface UF {
    int getSize();
    int find(int p);
    boolean isConnected(int p, int q);
    void union(int p, int q);
}

public class UnionFind implements UF {
    private int[] rank;
    private int[] parent;

    public UnionFind(int size) {
        rank = new int[size];
        parent = new int[size];

        // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for( int i = 0; i < size; i ++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize(){
        return parent.length;
    }

    public int find(int p) {
        if(p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        if (p != parent[p]) {
            parent[p] = find(parent[p]);    // path compressed
        }
        return parent[p];
    }

    // 查看元素 p 和元素 q 是否所属一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (isConnected(p, q)) return;

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if(rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;       // 维护rank的值
        }
    }
}
