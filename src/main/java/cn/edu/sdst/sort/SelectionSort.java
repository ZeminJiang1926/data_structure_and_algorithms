package cn.edu.sdst.sort;

/**
 * 选择排序
 *
 * @author ZhangYu
 * @date 2019/4/9
 */
public class SelectionSort implements ISortAlgorithm {

    public void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        SortUtils.methodTest("选择排序", 1000, new SelectionSort());
    }

}
