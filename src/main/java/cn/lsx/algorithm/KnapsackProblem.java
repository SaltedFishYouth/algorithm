package cn.lsx.algorithm;

/**
 * 动态规划
 * 动态规划-背包问题
 *
 * 有一个背包，容量为4磅，现有如下物体
 * 物品-------重量-------价格
 * 吉他（G）----1-------1500
 * 音响（S）----4-------3000
 * 电脑（L）----3-------2000
 *
 * 1.要求达到的目标为装入的背包总价值最大，并且重量不超出
 * 2.要求装入的物品不能重复
 *
 * @author linShengxi
 * @date 2021/7/3
 */

public class KnapsackProblem {
    public static void main(String[] args) {
        //物品名称
        String[] names = new String[]{"","吉他G","音箱S","电脑L"};
        //物品价值
        int[] v = {0,1500,3000,2000};
        //物品重量
        int[] w = {0,1,4,3};
        //背包情况
        int[][] b = new int[4][5];
        //放入情况
        int[][] path = new int[4][5];
        for (int i = 0; i < v.length; i++) {
            b[i][0] = 0;
        }

        for (int i = 0; i < b[0].length; i++) {
            b[0][i] = 0;
        }

        System.out.println("放入物品");
        for (int i = 1; i < b.length; i++) {
            for (int j = 1; j < b[0].length; j++) {
                //i是<=i的可用物品
                //j是背包可用j磅

                //新物品的重要大于背包可用重量、直接用上一个物品的策略
                if (w[i]>j) {
                    b[i][j] = b[i-1][j];
                }else {
                    //不装本次商品的最大价值和 装本次商品后的最大价值
                    if (b[i-1][j]<v[i]+b[i-1][j-w[i]]){
                        b[i][j] = v[i]+b[i-1][j-w[i]];
                        //记录放入物品
                        path[i][j] = 1;
                    }else {
                        b[i][j] = b[i-1][j];
                    }
                }
            }
        }

        //从后遍历，查出最后放入的物品，再查之前的重量放入了什么
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i>0 && j>0) {
            if (path[i][j] == 1){
                System.out.println(names[i]);
                j = j - w[i];
            }
            i--;
        }
    }
}
