package cn.lsx.algorithm;

/**
 * 普利姆算法
 * 求最短路径（最小生成树）
 * A - - - 5 - - - B
 * -   -           -   -
 * 7       2       3       9
 * -           -    -           -
 * C               G                D
 * -           -    -           -
 * 8       4       6       4
 * -   -           -   -
 * E - - - 5 - - - F
 * 有7个村庄(ABCDEFG),把7个村庄联通，各个村庄距离用线标识，A-B距离为5公里
 * 如何修路能保证各个村庄联通，并且总修路公里数最短
 *
 * @author linShengxi
 * @date 2021/7/23
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        //先创建一个村庄的图
        int[][] draw = new int[][]{
                {1000, 5, 7, 1000, 1000, 1000, 2},
                {5, 1000, 1000, 9, 1000, 1000, 3},
                {7, 1000, 1000, 1000, 8, 1000, 1000},
                {1000, 9, 1000, 1000, 1000, 4, 1000},
                {1000, 1000, 8, 1000, 1000, 5, 4},
                {1000, 1000, 1000, 4, 5, 1000, 6},
                {2, 3, 1000, 1000, 4, 6, 1000}
        };
        String[] drawName = new String[]{"A", "B", "C", "D", "E", "F", "G"};
        boolean[] exsitarr = new boolean[7];
        //从A出发
        exsitarr[0] = true;

        for (int d = 1; d < drawName.length; d++) {
            Integer minX = 0;
            Integer minY = 0;
            //i是已经走过的，从已经走过的路看还有哪些没有去过的里面找最短的
            for (int i = 0; i < draw.length; i++) {
                if (exsitarr[i]) {
                    for (int j = 0; j < draw[i].length; j++) {
                        if (!exsitarr[j] && draw[i][j] < draw[minX][minY]) {
                            minX = i;
                            minY = j;
                        }

                    }
                }
            }
            exsitarr[minY] = true;
            System.out.println(drawName[minX] + "->" + drawName[minY]);
        }
    }
}
