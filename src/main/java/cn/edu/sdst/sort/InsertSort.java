package cn.edu.sdst.sort;

/**
 * 插入排序
 * <p>
 * 把数组分成已排序和未排序的两部分，逐个将未排序的插入到已排序的序列中
 *
 * @author ZhangYu
 * @date 2019/4/9
 */
public class InsertSort implements ISortAlgorithm {

    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            // 选择合适的插入位置， 大数依次后移
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = value;
        }
    }

    public static void main(String[] args) {
        SortUtils.methodTest("插入排序", 2, new InsertSort());
    }

}
