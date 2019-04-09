package cn.edu.sdst.sort;

/**
 * 冒泡排序
 * <p>
 * 从头到尾，依次交换，选一个最大的至末尾
 *
 * @author ZhangYu
 * @date 2019/4/9
 */
public class BubbleSort implements ISortAlgorithm {

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean exchange = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    exchange = true;
                }
            }
            if (!exchange) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        SortUtils.methodTest("冒泡排序", 10000, new BubbleSort());
    }

}
