package cn.lsx.algorithm.datastructure;

import cn.lsx.algorithm.datastructure.stack.ArrayStack;
import cn.lsx.algorithm.datastructure.stack.LinkedListStack;
import cn.lsx.algorithm.datastructure.stack.Stack;

import java.util.Scanner;

/**
 * @author linShengxi
 * @date 2021/6/2
 */

public class StackTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请选择队列类型 1:数组栈 2:链表栈 0:退出");
        int index = scan.nextInt();

        Stack stack = null;
        switch (index) {
            case 0:
                return;
            case 1:
                stack = new ArrayStack(5);
                break;
            case 2:
                stack = new LinkedListStack();
                break;
        }

        while (true) {
            System.out.println("1:插入 2:取出 3:展示全部 0:退出");

            index = scan.nextInt();

            switch (index) {
                case 1:
                    System.out.println("输入插入数据");
                    stack.push(scan.nextInt());
                    break;
                case 2:
                    int data = stack.pop();
                    System.out.println("取出数据:" + data);
                    break;
                case 3:
                    stack.show();
                    break;
                case 0:
                    return;
            }
        }
    }

}
