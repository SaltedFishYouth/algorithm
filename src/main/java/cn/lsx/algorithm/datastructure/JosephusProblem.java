package cn.lsx.algorithm.datastructure;

/**
 * 约瑟夫问题:
 * @author linShengxi
 * @date 2021/5/31
 */

public class JosephusProblem {
    private Boy first;

    public void buildBoys(int boys){
        if (boys < 2){
            System.out.println("最少创建2个男孩");
        }
        int num = 1;
        first = new Boy(num);

        Boy temp = first;
        while (num < boys){
            num++;
            temp.setNextBoy(new Boy(num));
        }
        temp.setNextBoy(first);
    }

    public void run(int start ,int target){

    }


}

class Boy{
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
