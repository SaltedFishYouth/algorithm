package cn.lsx.algorithm;

/**
 * 分治算法典型(二分搜索、大整数乘法、棋盘覆盖、合并排序、快速排序、线性时间选择、最接近点对问题、循环赛日程表、汉诺塔)
 * 汉诺塔 ABC 3个位置 将高塔从A 移动到C，要求移动的时候必须保证，小的在大的上面才能让塔稳定
 * @author linShengxi
 * @date 2021/7/3
 */

public class TowerOfHanoi {


    /**
     * description:
     *
     * @param layer 塔层
     * @param towerLocation 塔位置
     * @param tempLocation 临时位置
     * @param targetLocation 目标位置
     * @return void
     */
    public void move(int layer,String towerLocation ,String tempLocation,String targetLocation){
        //将过程分解成，先将上面的塔移动到临时位置，再最底下的一层移动到目标位置，最后将上面的塔移动到目标位置
        if (layer == 1){
            System.out.println("将1层塔移动"+towerLocation+"->"+targetLocation);
        } else {
            //1.先将上面的塔移动到临时位置
            move(layer-1,towerLocation,targetLocation,tempLocation);
            //2.最底下的一层移动到目标位置
            System.out.println("将"+layer+"层塔移动"+towerLocation+"->"+targetLocation);
            //3.最后将上面的塔移动到目标位置
            move(layer-1,tempLocation,towerLocation,targetLocation);
        }
    }

    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.move(5,"A","B","C");
    }
}
