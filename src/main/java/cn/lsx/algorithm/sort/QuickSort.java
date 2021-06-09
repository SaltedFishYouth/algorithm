package cn.lsx.algorithm.sort;

/**
 * @author linShengxi
 * @date 2021/6/8
 */

public class QuickSort {

    public void sort(int[] arr) {
        recursion(arr,0,arr.length-1);
    }

    private void recursion(int[] arr, int left, int right) {
        if(left>=right) {
            return;
        }
        int target = arr[left];
        int l = left;
        int r = right;

        while (l < r){

            while (arr[r]>=target && l<r){
                r--;
            }

            while (arr[l] <= target && l<r){
               l++;
           }

           if (l < r){
              int temp = arr[l];
              arr[l] = arr[r];
              arr[r] = temp;
           }
            arr[left]=arr[l];
            arr[l]=target;
            recursion(arr,left,l-1);
            recursion(arr,l+1,right);
        }
    }
}
