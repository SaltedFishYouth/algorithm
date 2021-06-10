package cn.lsx.algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author linShengxi
 * @date 2021/6/10
 */

public class FibonacciSearch {

    public List search(int[] arr, int target) {
        int[] fibonacci = fibonacci();
        List list = new ArrayList();
        int left = 0;
        int right = arr.length - 1;
        int k = 0;
        while (arr.length > fibonacci[k]) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr, fibonacci[k]);

        for (int i = 0; i < arr.length; i++) {
           temp[i] = arr[i];
        }

        while (left <= right) {
            int mid = left + fibonacci[k - 1];
            if (temp[mid] > target) {
                right = mid;
                k--;
            } else if (temp[mid] < target) {
                left = mid;
                k -= 2;
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

    private int[] fibonacci() {
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }
}
