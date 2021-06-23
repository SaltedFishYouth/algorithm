package cn.lsx.algorithm.sort;

import java.util.Arrays;

/**
 * @author linShengxi
 * @date 2021/6/19
 */

public class HeapSort {
    public void sort(int[] arr){
        //大顶堆
        buildTop(arr,arr.length);

        for (int i = arr.length-1; i >0; i--) {
            int temp = arr[i];
            arr[i]=arr[0];
            arr[0] = temp;
            buildTop(arr,i);
        }
    }

    private void buildTop(int[] arr,int size){
        int k = size/2 -1;
        for (int i = k; i >= 0 ; i--) {

            int index = i*2+1;
            int num = arr[i];
            if (size>index+1 && arr[index]<arr[index+1]){
                index++;
            }

            if (index<size && num<arr[index]) {
                arr[i] = arr[index];
                arr[index] = num;
                i = index+1;
            } else {
                continue;
            }
        }
    }



}
