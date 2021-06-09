package cn.lsx.algorithm.sort;

/**
 * @author linShengxi
 * @date 2021/6/8
 */

public class MergeSort {

    public void sort(int[] arr) {
        mergeSort(arr,0,arr.length-1);
    }

    private void mergeSort(int[] arr ,int left ,int right){
        if (left==right){
            return;
        }
        int mid = (left+right)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,mid+1,right);
    }

    private void merge(int[] arr,int l,int r,int l2,int r2){
        int[] temp = new int [r2-l+1];
        int left = l;
        int index = 0;
        while (l<=r && l2<=r2) {
            if (arr[l]<arr[l2]){
                temp[index] = arr[l];
                l++;
            }else {
                temp[index] = arr[l2];
                l2++;
            }
            index++;
        }
        while (l<=r) {
            temp[index++] = arr[l++];
        }
        while (l2<=r2) {
            temp[index++] = arr[l2++];
        }


        for (int i = 0; i < temp.length; i++) {
            arr[left+i] = temp[i];
        }
    }
}
