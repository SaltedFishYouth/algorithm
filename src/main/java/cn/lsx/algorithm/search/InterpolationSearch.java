package cn.lsx.algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linShengxi
 * @date 2021/6/10
 */

public class InterpolationSearch {

    public List search(int[] arr, int target) {
        List list = new ArrayList();
        if (arr.length == 0) {
            return list;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (target - arr[left]) * (right - left) / (arr[right] - arr[left]);
            if (arr[mid] < target) {
                right = mid;
            } else if (arr[mid] > target) {
                left = mid;
            } else {
                list.add(mid);
                right = mid;
                left = mid;

                while (arr[--left] == target) {
                    list.add(left);
                }
                while (arr[++right] == target) {
                    list.add(right);
                }
                break;
            }
        }
        return list;
    }
}
