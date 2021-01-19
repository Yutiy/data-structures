package search;

/**
 * Author: yutiy
 * Date: 2020/12/12 下午7:58
 * Email: 494657028@qq.com
 */
public class LinearSearch {
    private LinearSearch() {}

    public static <T> int search(T[] data, T target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static void main(String[] args) {
        Integer[] data = generateOrderedArray(100000);

        int res1 = LinearSearch.search(data, 99999);
        System.out.println(res1);

        Student[] students = {new Student("Alice"), new Student("Bob")};
        Student Bob = new Student("Bob");
        int res2 = LinearSearch.search(students, Bob);
        System.out.println(res2);
    }
}
