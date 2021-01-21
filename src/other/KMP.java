package other;

/**
 * Author: yutiy
 * Date: 2020/12/16 下午5:38
 * Email: 494657028@qq.com
 *
 * 关键点：如果发现不匹配，只能不用回溯到下一个位置，利用已经匹配到元素判断移动位置
 *   移动位数 = 已匹配的字符数 - 最后一个匹配字符对应的部分匹配值
 */
public class KMP {
    public static int[] calcNext(String str) {
        int len = str.length();
        int[] next = new int[len];
        next[0] = -1;

        int j = -1;
        for(int i = 1; i < len; i++) {
            while(j > -1 && str.charAt(i) != str.charAt(j + 1)) {
                j = next[j];
            }
            if (str.charAt(i) == str.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int match(String str, String pStr) {
        int[] next = calcNext(pStr);

        int i = 0;
        int j = 0;
        while (i < str.length() && j < pStr.length()) {
            if (j == -1 || str.charAt(i) == pStr.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        return j == pStr.length() ? i - j : -1;
    }

    public static void main(String[] args) {
        // ababac -> [0, 0, 1, 2, 3, 0]
        // a -> 0
        // ab [a] [b] -> 0
        // aba [a, ab] [ba, a] -> 1
        // abab [a, ab, aba] [bab, ab, b] -> 2
        // ababa [a, ab, aba, abab] [baba, aba, ba, a] -> 3
        // ababac [a, ab, aba, abab, ababa] [babac, abac, bac, ac, c] -> 0
        int pos = KMP.match("bbc abcdab abcdababacde", "ababac");
        System.out.println(pos);
    }
}
