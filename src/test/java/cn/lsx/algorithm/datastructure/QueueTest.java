package cn.lsx.algorithm.datastructure;

import cn.lsx.algorithm.datastructure.queue.ArrayQueue;
import cn.lsx.algorithm.datastructure.queue.CircleArrayQueue;
import cn.lsx.algorithm.datastructure.queue.Queue;

import java.util.Scanner;

/**
 * @author linShengxi
 * @date 2021/5/26
 */

public class QueueTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请选择队列类型 1:数组队列 2:环形数组队列 3:链型队列 4:环形链型队列 0:退出");
        int index = scan.nextInt();

        Queue queue = null;
        switch (index) {
            case 0:
                return;
            case 1:
                queue = new ArrayQueue();
                break;
            case 2:
                queue = new CircleArrayQueue();
                break;
        }

        while (true) {
            System.out.println("1:插入 2:取出 3:展示全部 4:展示头 5:展示队列 0:退出");

            index = scan.nextInt();

            switch (index) {
                case 1:
                    System.out.println("输入插入数据");
                    queue.enQueue(scan.next());
                    break;
                case 2:
                    Object o = queue.deQueue();
                    System.out.println("取出数据:"+o);
                    break;
                case 3:
                    queue.showAll();
                    break;
                case 4:
                    queue.showFront();
                    break;
                case 5:
                    queue.showQueue();
                    break;
                case 0:
                    return;
            }
        }
    }

}
