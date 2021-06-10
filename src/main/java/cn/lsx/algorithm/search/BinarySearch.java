package cn.lsx.algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分法查找
 * @author linShengxi
 * @date 2021/6/9
 */

public class BinarySearch {

    public List search(int[] arr, int target) {
        List targetIndexs = new ArrayList();
        int left=0;
        int right = arr.length-1;
        while (left<right) {
            int mid = (left+right)/2;
            if (arr[mid] < target) {
                 left = mid+1;
            }else if (arr[mid] > target) {
                right = mid-1;
            } else {
                targetIndexs.add(mid);
                right = mid;
                left = mid;

                while (arr[--left] == target) {
                    targetIndexs.add(left);
                }
                while (arr[++right] == target) {
                    targetIndexs.add(right);
                }
                break;
            }
        }
       // 递归 binarySearch(arr,0,arr.length,target,targetIndexs);
        return targetIndexs;
    }

    private void binarySearch(int[] arr,int left ,int right,int target,List targetIndexs) {
        if (left>=right) {
            return;
        }
        int mid = (left + right) / 2;
        if (arr[mid] < target) {
            binarySearch(arr,mid+1,right,target,targetIndexs);
        }else if (arr[mid] > target) {
            binarySearch(arr,left,mid-1,target,targetIndexs);
        } else {
            targetIndexs.add(mid);
            while (arr[--mid] == target) {
                targetIndexs.add(mid);
            }
            while (arr[++mid] == target) {
                targetIndexs.add(mid);
            }
        }
    }
}
