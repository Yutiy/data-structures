package other;

import java.util.BitSet;

/**
 * Author: yutiy
 * Date: 2020/12/16 下午3:54
 * Email: 494657028@qq.com
 *
 * 将任意大小的数据转换成特定大小的数据的函数，转换后的数据称为哈希值或哈希编码
 */
public class BloomFilter {
    private static final int DEFAULT_SIZE = 2 << 24;
    private static final int[] seeds = new int[]{3, 5, 7, 11, 13, 19, 23, 37};
    private BitSet bits = new BitSet(DEFAULT_SIZE);
    private SimpleHash[] func = new SimpleHash[seeds.length];

    public BloomFilter() {
        for (int i = 0; i < seeds.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
        }
    }

    public void add(String value) {
        for (SimpleHash f: func) {
            bits.set(f.hash(value), true);
        }
    }

    public boolean contains(String value) {
        if (value == null) return false;
        boolean ret = true;
        for (SimpleHash f: func) {
            ret = ret && bits.get(f.hash(value));
        }
        return ret;
    }

    private static class SimpleHash {
        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(String value) {
            int result = 0;
            int len = value.length();
            for (int i = 0; i < len; i++) {
                result = seed * result + value.charAt(i);
            }
            return (cap - 1) & result;
        }
    }

    public static void main(String[] args) {
        String value = "https://www.ytxcloud.com";
        BloomFilter filter = new BloomFilter();
        System.out.println(filter.contains(value));
        filter.add(value);
        System.out.println(filter.contains(value));
    }
}
