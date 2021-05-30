package cn.lsx.algorithm.datastructure.queue;

import java.util.StringJoiner;

/**
 * 数组队列
 *
 * @author linShengxi
 * @date 2021/5/24
 */

public class ArrayQueue implements Queue {
    Object[] arr;
    private int front;//第一条数据下标
    private int rear;//最后一条数据下标

    public ArrayQueue() {
        this(3); //调用其它构造方法
    }

    public ArrayQueue(int size) {
        arr = new Object[size];
        front = 0;
        rear = -1;
    }

    @Override
    public void enQueue(Object o) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear++;

        arr[rear] = o;
    }

    @Override
    public Object deQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return null;
        }
        Object o = arr[front];
        front++;
        return o;
    }

    @Override
    public void showAll() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        for (int i = front; i <= rear; i++) {
            Object o = arr[i];
            joiner.add(o.toString());
        }
        System.out.println(joiner.toString());
    }

    @Override
    public void showQueue() {

        for (int i = 0; i < arr.length; i++) {
            Object o = arr[i];
            System.out.println(i + ":" + o);
        }
    }

    @Override
    public void showFront() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        System.out.println("数组首个元素为:" + arr[front]);
    }

    private boolean isEmpty() {
        return front > rear;
    }

    private boolean isFull() {
        return rear == arr.length - 1;
    }
}
