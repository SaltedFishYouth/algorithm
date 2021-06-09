package cn.lsx.algorithm.sort;

/**
 * @author linShengxi
 * @date 2021/6/8
 */

public class RadixSort {
    public void sort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketSize = new int[10];

        int max = arr[0];
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }
        int maxLength = (max + "").length();

        for (int i = 0, radix = 1; i < maxLength; i++, radix *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int temp = arr[j] / radix % 10;
                bucket[temp][bucketSize[temp]] = arr[j];
                bucketSize[temp]++;
            }
            int index = 0;
            for (int j = 0; j < bucket.length; j++) {
                for (int k = 0; k < bucketSize[j]; k++) {
                    arr[index++] = bucket[j][k];
                }
                bucketSize[j] = 0;
            }
        }
    }
}
