package cn.lsx.algorithm.sort;

/**
 * 冒泡排序
 * @author linShengxi
 * @date 2021/6/7
 */
public class BubbleSort {

    public void sort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }

            if (!flag) {
                return;
            }
        }
    }

}
