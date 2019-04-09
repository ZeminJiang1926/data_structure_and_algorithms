package cn.edu.sdst.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/2/17
 */
public class SortUtils {

    public static int[] getRandomArray(int size) {
        Random random = new Random();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = random.nextInt(size * 10);
        }
        return ints;
    }

    public static void checkOrder(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                throw new RuntimeException(String.format("排序结果错误 arr[%d]=%d, arr[%d]=%d", i, arr[i], i + 1, arr[i + 1]));
            }
        }
    }

    public static void methodTest(String name, int size, ISortAlgorithm algorithm) {
        int[] randomArray = SortUtils.getRandomArray(size);
        System.out.println("Before: " + Arrays.toString(randomArray));
        long startTime = System.currentTimeMillis();
        algorithm.sort(randomArray);
        long endTime = System.currentTimeMillis();
        System.out.println("After: " + Arrays.toString(randomArray));
        checkOrder(randomArray);
        System.out.println(name + " time: " + ((endTime - startTime) / 1000.0) + "s  status: success.");
    }

}
