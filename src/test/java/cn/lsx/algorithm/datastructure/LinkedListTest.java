package cn.lsx.algorithm.datastructure;

import cn.lsx.algorithm.datastructure.linkedlist.DoubleLinkedList;
import cn.lsx.algorithm.datastructure.linkedlist.LinkedList;
import cn.lsx.algorithm.datastructure.linkedlist.SingleLinkedList;

import java.util.Scanner;

public class LinkedListTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请选择队列类型 1:单链表 2:双链表 0:退出");
        int index = scan.nextInt();

        LinkedList<String> list = null;
        switch (index) {
            case 0:
                return;
            case 1:
                list = new SingleLinkedList();
                break;
            case 2:
                list = new DoubleLinkedList();
                break;
        }
        while (true) {
            System.out.println("1:插入 2:取出 3:根据坐标删除 4:根据坐标删除 5:翻转 6:展示全部 0:退出");

            index = scan.nextInt();

            switch (index) {
                case 1:
                    System.out.println("输入插入数据");
                    list.add(scan.next());
                    break;
                case 2:
                    System.out.println("输入获取第几个数据");
                    String s = list.get(scan.nextInt()-1);
                    System.out.println("取出数据:" + s);
                    break;
                case 3:
                    System.out.println("输入删除第几个数据");
                    list.remove(scan.nextInt()-1);
                    break;
                case 4:
                    System.out.println("输入删除第几个数据");
                    list.remove(list.get(scan.nextInt()-1));
                    break;
                case 5:
                   list.reverse();
                    break;
                case 6:
                    for (int i = 0; i < list.getSize(); i++) {
                        String str = list.get(i);
                        System.out.println(String.format("第 %d 个数据为 %s", i+1, str));
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("输入错误");
            }
        }
    }
}
