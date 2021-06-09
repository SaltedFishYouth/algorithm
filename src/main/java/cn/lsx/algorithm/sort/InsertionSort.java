package cn.lsx.algorithm.sort;

/**
 * 插入排序
 * @author linShengxi
 * @date 2021/6/8
 */

public class InsertionSort {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int indext = i;
            while (indext > 0 && arr[indext - 1] > temp) {
                arr[indext] = arr[indext - 1];
                indext--;
            }

            if (indext != i) {
                arr[indext] = temp;
            }
        }
    }
}
