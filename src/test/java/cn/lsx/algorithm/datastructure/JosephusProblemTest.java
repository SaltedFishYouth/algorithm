package cn.lsx.algorithm.datastructure;

import org.junit.Test;

/**
 * @author linShengxi
 * @date 2021/6/1
 */

public class JosephusProblemTest {
    @Test
    public void test(){
         // 约瑟夫问题:约瑟夫问题是个有名的问题：N个人围成一圈，从第一个开始报数，第M个将被杀掉，最后剩下一个，其余人都将被杀掉。例如N=6，M=5，被杀掉的顺序是：5，4，6，2，3。
        JosephusProblem josephusProblem = new JosephusProblem();
        //
        josephusProblem.buildBoys(6);
        josephusProblem.run(1,5);
    }
}
