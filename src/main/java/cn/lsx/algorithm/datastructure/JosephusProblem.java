package cn.lsx.algorithm.datastructure;

import java.util.StringJoiner;

/**
 * 约瑟夫问题:约瑟夫问题是个有名的问题：N个人围成一圈，从第一个开始报数，第M个将被杀掉，最后剩下一个，其余人都将被杀掉。例如N=6，M=5，被杀掉的顺序是：5，4，6，2，3。
 *
 * @author linShengxi
 * @date 2021/5/31
 */

public class JosephusProblem {
    private Boy first;

    /**
     * description:创建男孩的围圈
     *
     * @param boys 创建boys个男孩的围圈
     * @return void
     */
    public void buildBoys(int boys) {
        if (boys < 2) {
            System.out.println("最少创建2个男孩");
        }
        int num = 1;
        first = new Boy(num);

        Boy temp = first;
        while (num < boys) {
            num++;
            temp.setNextBoy(new Boy(num));
            temp = temp.getNextBoy();
        }
        temp.setNextBoy(first);
    }

    /**
     * description:开始报数出列
     *
     * @param start  第start个开始报数
     * @param target 第target个出列
     * @return void
     */
    public void run(int start, int target) {

        Boy temp = first;
        while (temp.getNextBoy() != first) {
            temp = temp.getNextBoy();
        }
        //1.第start个准备
        for (int i = 1; i < start; i++) {
            first = first.getNextBoy();
            temp = temp.getNextBoy();
        }

        //2.开始报数
        StringJoiner joiner = new StringJoiner(",", "", "");
        int i = 1;
        while (first != temp) {
            if (i == target) {
                joiner.add(String.valueOf(first.getNum()));
                first = first.getNextBoy();
                temp.setNextBoy(first);
                i = 1;
            }
            first = first.getNextBoy();
            temp = temp.getNextBoy();
            i++;
        }
        joiner.add(String.valueOf(first.getNum()));
        System.out.println("报数:" + joiner.toString());
    }


}

class Boy {
    private int num;
    private Boy nextBoy;

    public Boy(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Boy getNextBoy() {
        return nextBoy;
    }

    public void setNextBoy(Boy nextBoy) {
        this.nextBoy = nextBoy;
    }
}
