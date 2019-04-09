package cn.edu.sdst.sort;


/**
 * 归并排序
 *
 * @author ZhangYu
 * @date 2019/2/17
 */
public class MergeSort implements ISortAlgorithm {
    /**
     * 对指定数组进行归并排序
     *
     * @param arr 待排序数组
     */
    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 对指定数组 [l,r] 索引区间进行归并排序
     *
     * @param arr 待排序数据
     * @param l   左索引
     * @param r   右索引
     */
    private void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        // 对[1, mid]进行归并排序
        mergeSort(arr, l, mid);
        // 对[mid+1,r]进行归并排序
        mergeSort(arr, mid + 1, r);
        // 合并
        merge(arr, l, mid, r);
    }

    /**
     * 将arr[l, mid] 与arr[mid+1, r]进行合并
     *
     * @param arr 带合并数组
     * @param l   左索引
     * @param mid 中间索引
     * @param r   右索引
     */
    private static void merge(int[] arr, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }
        // i左侧当前指向  j右侧当前指向 k待插入位置
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }

    }

    private static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }


    /*
        归并排序的思想
        1. 将序列分为两段，并分别进行归并排序
        2，将排序后的两部分合并
     */

    public static void main(String[] args) {
        SortUtils.methodTest("Merge Sort", 50000, new MergeSort());
    }

}
