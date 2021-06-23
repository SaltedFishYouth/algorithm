package cn.lsx.algorithm.sort;

import org.junit.Test;

/**
 * @author linShengxi
 * @date 2021/6/8
 */

public class Sort {
    private int[] build(int size,int numSize){
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            int v =  (int) (Math.random() * numSize);
            arr[i] = v;
        }
        return arr;
    }

    private void show(int[] arr){
        for (int i : arr) {
            System.out.print(i+",");
        }
        System.out.println();
    }

    @Test
    public void bubbleSort(){
        int[] arr = build(10, 10);
        System.out.println("数组排序前");
        show(arr);
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        System.out.println("数组排序后");
        show(arr);
    }

    @Test
    public void insertionSort(){
        int[] arr = build(10, 10);
        System.out.println("数组插入排序前");
        show(arr);
        InsertionSort sort = new InsertionSort();
        sort.sort(arr);
        System.out.println("数组插入排序后");
        show(arr);
    }

    @Test
    public void selectionSort(){
        int[] arr = build(10, 10);
        System.out.println("数组选择排序前");
        show(arr);
        SelectionSort sort = new SelectionSort();
        sort.sort(arr);
        System.out.println("数组选择排序后");
        show(arr);
    }

    @Test
    public void shellSort(){
        int[] arr = build(10, 10);
        System.out.println("数组希尔排序前");
        show(arr);
        ShellSort sort = new ShellSort();
        sort.sort(arr);
        System.out.println("数组希尔排序后");
        show(arr);
    }
    @Test
    public void quickSort(){
        //int[] arr = build(10, 10);
        int[] arr = new int[]{3,1,4};

        System.out.println("数组快速排序前");
        show(arr);
        QuickSort sort = new QuickSort();
        sort.sort(arr);
        System.out.println("数组快速排序后");
        show(arr);
    }
    @Test
    public void mergeSort(){
        int[] arr = build(10, 10);
        //int[] arr = new int[]{3,1,4};

        System.out.println("数组归并排序前");
        show(arr);
        MergeSort sort = new MergeSort();
        sort.sort(arr);
        System.out.println("数组归并排序后");
        show(arr);
    }

    @Test
    public void radixSort(){
        int[] arr = build(10, 20);
        //int[] arr = new int[]{3,1,4};

        System.out.println("数组基数排序前");
        show(arr);
        RadixSort sort = new RadixSort();
        sort.sort(arr);
        System.out.println("数组基数排序后");
        show(arr);
    }

    @Test
    public void heapSort(){
        //int[] arr = build(10, 20);
        int[] arr = new int[]{1,3,4,5,2,6,9,7,8,0};

        System.out.println("数组堆排序前");
        show(arr);
        HeapSort sort = new HeapSort();
        sort.sort(arr);
        System.out.println("数组堆排序后");
        show(arr);
    }
}
