package graph;

/**
 * Author: yutiy
 * Date: 2020/12/17 下午3:27
 * Email: 494657028@qq.com
 */
public class Edge {
    private int start;
    private int end;
    private int weight;

    private int other(int x) {
        return x == this.v() ? this.w() : this.v();
    }

    public int v() {
        return this.start;
    }

    private int w() {
        return this.end;
    }

    private int wt() {
        return this.weight;
    }
}
