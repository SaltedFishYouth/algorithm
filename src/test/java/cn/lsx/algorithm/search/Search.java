package cn.lsx.algorithm.search;

import org.junit.Test;

import java.util.List;

/**
 * @author linShengxi
 * @date 2021/6/9
 */

public class Search {
    private int[] build() {
        return new int[]{1,2,2,2,3,4,5,5,6,7,8,9,10};
    }
    private void show(List list) {
        if (list.isEmpty()) {
            System.out.println("没有查找到");
            return;
        }
        for (Object o : list) {
            System.out.print(o+",");
        }
    }

    @Test
    public void binarySearch() {
        int[] arr = build();

        BinarySearch search = new BinarySearch();

        List list = search.search(arr, 5);
        show(list);
    }

    @Test
    public void interpolationSearch() {
        int[] arr = build();

        InterpolationSearch search = new InterpolationSearch();

        List list = search.search(arr, 5);
        show(list);
    }

    @Test
    public void fibonacciSearch() {
        int[] arr = build();

        FibonacciSearch search = new FibonacciSearch();

        List list = search.search(arr, 5);
        show(list);
    }
}
