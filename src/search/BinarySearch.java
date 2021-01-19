package search;

/**
 * Author: yutiy
 * Date: 2020/12/13 下午4:20
 * Email: 494657028@qq.com
 */
public class BinarySearch {
    private BinarySearch() {}

    public static <T extends Comparable<T>> int search(T[] data, T target) {
        int length = data.length;
        int l = 0;
        int r = length - 1;

        // 区间为[l,r]
        while(l <= r) {
            int mid = l + (r - l) / 2;

            if (data[mid].compareTo(target) == 0) return mid;
            if (data[mid].compareTo(target) > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static <T extends Comparable<T>> void search1(T[] data, T target, int l, int r) {

    }

    public static void main(String[] args) {
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int res = BinarySearch.search(data, 10);
        System.out.println(res);
    }
}
