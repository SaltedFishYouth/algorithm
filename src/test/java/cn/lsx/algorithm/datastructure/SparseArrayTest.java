package cn.lsx.algorithm.datastructure;

import org.junit.Test;

/**
 * 稀疏数组 测试
 * @author linShengxi
 * @date 2021/5/24
 */

public class SparseArrayTest {

    @Test
    public void buildSparseArrayTest(){
        SparseArray sparseArray = buildSparseArray();
        System.out.println("-------------- 打印 稀疏数组--------------");
        print(sparseArray.getSparseArray());

        System.out.println("-------------- 打印 转回来的二维数组--------------");
        print(sparseArray.twoDimensionalArray());
    }

    private SparseArray buildSparseArray(){
        int[][] newArr = new int[5][5];
        newArr[1][3] = 4;
        newArr[4][3] = 5;
        System.out.println("-------------- 打印 二维数组--------------");
        print(newArr);

        return new SparseArray(newArr);
    }

    private void print(int[][] arr){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println("");
        }
    }
}
