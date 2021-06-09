package cn.lsx.algorithm.sort;

/**
 * @author linShengxi
 * @date 2021/6/8
 */

public class ShellSort {
    public void sort(int[] arr) {
        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {
            for (int i = 0; i < arr.length; i++) {
                int index = i;
                int temp = arr[i];
                while (index >= gap && arr[index - gap] > temp) {
                    arr[i] = arr[index - gap];
                    index -= gap;
                }

                if (index != i) {
                    arr[index] = temp;
                }
            }
        }
    }
}
