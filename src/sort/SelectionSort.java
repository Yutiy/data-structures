package sort;

/**
 * Author: yutiy
 * Date: 2020/12/12 下午9:27
 * Email: 494657028@qq.com
 */
public class SelectionSort {
    private SelectionSort() {}

    static <T> void test1(T[] data){
        for(T ele: data) {
            System.out.print(ele + " ");
        }
    }

    public static <T extends Comparable<T>> void sort(T[] data) {
        for (int i = 0; i < data.length; i++) {
            // 选择 data[i,n) 中最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[minIndex].compareTo(data[j]) > 0) {
                    minIndex = j;
                }
            }
            SortingHelper.swap(data, i, minIndex);
        }
    }

    public static <T extends Comparable<T>> void sort1(T[] data) {
        for (int i = data.length - 1; i >= 0; i--) {
            // 选择 data[i,n) 中最大值的索引
            int maxIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (data[j].compareTo(data[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            SortingHelper.swap(data, i, maxIndex);
        }
    }

    public static void main(String[] args) throws Throwable {
        Integer[] data = {1, 3, 2, 5, 6, 4};
        SelectionSort.sort1(data);

        for (int ele : data) {
            System.out.print(ele + "");
        }
        System.out.println();

        SortingHelper.sortTest("sort.SelectionSort", data);

        Student[] students = {new Student("Alice", 90), new Student("Bob", 96), new Student("Charles", 80)};
        SelectionSort.sort(students);

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
