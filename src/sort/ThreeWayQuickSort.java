package sort;

public class ThreeWayQuickSort {
    private ThreeWayQuickSort() {}

    public static <T extends Comparable<T>> int partition(T[] data, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        SortingHelper.swap(data, l, (int)(Math.random()*(r - l + 1)) + l);

        int i = l + 1;
        int j = r;
        T pivot = data[l];

        while(true) {
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            while(i <= r && data[i].compareTo(pivot) < 0) {
                i++;
            }

            // 注意这里的边界, arr[j].compareTo(v) > 0, 不能是arr[j].compareTo(v) >= 0
            while(j >= l+1 && data[j].compareTo(pivot) > 0) {
                j--;
            }

            if (i > j) break;

            SortingHelper.swap(data, i, j);
            i++;
            j--;
        }

        return j;
    }

    public static <T extends Comparable<T>> void sort(T[] data, int l, int r) {
        if (r - l <= 10) {
            InsertionSort.sort(data, l, r);
            return;
        }

        int pivot = partition(data, l, r);
        sort(data, l, pivot - 1);
        sort(data, pivot + 1, r);
    }

    public static <T extends Comparable<T>> void sort(T[] data) {
        int n = data.length;
        sort(data, 0, n - 1);
    }

    public static void main(String[] args) {
        Integer[] data = {1, 3, 2, 5, 6, 4};
        ThreeWayQuickSort.sort(data);

        for (int ele : data) {
            System.out.print(ele + "");
        }
        System.out.println();
    }
}
