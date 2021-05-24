package cn.lsx.algorithm.datastructure;

/**
 * 稀疏数组
 *
 * @author linShengxi
 * @date 2021/5/22
 */

public class SparseArray {
    private int[][] sparseArray;
    private int defult = 0;

    public SparseArray(int[][] array) {
        int hight = array.length;
        int wide = hight == 0 ? 0 : array[0].length;
        int valueCount = 0;

        for (int[] line : array) {
            for (int column : line) {
                if (column == defult) {
                    continue;
                }
                valueCount++;
            }
        }

        sparseArray = new int[valueCount + 1][3];
        sparseArray[0][0] = hight;
        sparseArray[0][1] = wide;
        sparseArray[0][2] = valueCount;

        int index = 1;
        for (int i = 0; i < array.length; i++) {
            int[] line = array[i];
            for (int j = 0; j < line.length; j++) {
                int column = line[j];
                if (column == defult) {
                    continue;
                }
                sparseArray[index][0] = i;
                sparseArray[index][1] = j;
                sparseArray[index][2] = column;
                index++;
            }
        }
    }

    public int[][] getSparseArray(){
        return sparseArray;
    }

    public int[][] twoDimensionalArray(){
        int hight = sparseArray[0][1];
        int wide = sparseArray[0][1];
        int[][] newArr = new int[hight][wide];
        for (int i = 1; i < sparseArray.length; i++) {
            int[] ints = sparseArray[i];
            newArr[ints[0]][ints[1]] = ints[2];
        }
        return newArr;
    }
}

