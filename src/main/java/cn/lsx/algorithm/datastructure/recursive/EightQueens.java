package cn.lsx.algorithm.datastructure.recursive;

/**
 * 8*8的棋盘 任意两皇后不能处于同一行、同一列、同一斜线，有多少种摆法
 *
 * @author linShengxi
 * @date 2021/6/4
 */

public class EightQueens {

    private int[] arr = new int[8];

    private int successTimes = 0;

    public void run() {
        playing(0);
        System.out.println("成功次数:" + successTimes);
    }

    private void playing(int line) {

        //最后的棋子已经下了输出
        if (line == 8) {
            successTimes++;
            for (int i : arr) {
                System.out.print(" " + i);
            }
            System.out.println();

            return;
        }

        //本次下的是否符合要求 符合下下一个棋子 不符合本次换位置
        for (int i = 0; i < 8; i++) {
            arr[line] = i;
            if (check(line)) {
                playing(line + 1);
            }
        }
        return;
    }

    /**
     * description:检查第 line 行摆放的皇后符不符合要求
     *
     * @param line
     * @return boolean true 符合要求 false 不符合
     */
    private boolean check(int line) {
        for (int i = 0; i < line; i++) {
            //arr[i] == arr[line] 是否同一列
            //(同斜线在坐标轴是等腰直角三角形) x差值的绝对值=y差值的绝对值 Math.abs:取绝对值 line 一定大于i
            if (arr[i] == arr[line] || line - i == Math.abs(arr[line] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
