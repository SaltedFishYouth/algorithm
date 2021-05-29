package cn.lsx.algorithm.datastructure;

import java.util.StringJoiner;

/**
 * 环形队列
 * @author linShengxi
 * @date 2021/5/26
 */

public class CircleArrayQueue implements Queue {
    Object[] arr;
    private int front;//第一条数据下标
    private int rear;//最后一条数据后一个的下标

    public CircleArrayQueue(int size) {
        this.arr = new Object[size];
        this.front = 0;
        this.rear = 0;
    }
    public CircleArrayQueue() {
        this.arr = new Object[3];
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public void enQueue(Object o) {
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        int nextIndex = (rear + arr.length) %  arr.length;
        arr[nextIndex] = o;
        rear++;
    }

    @Override
    public Object deQueue() {
        if (isEmpty()){
            System.out.println("队列已空");
            return null;
        }
        Object o = arr[front];
        front = (front +1 + arr.length) %  arr.length;

        return o;
    }

    @Override
    public void showAll() {
        if (isEmpty()){
            System.out.println("队列已空");
            return;
        }
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        int size = (rear + arr.length - front)%arr.length;
        for (int i = 0; i < size; i++) {
            int index = (front+i+arr.length)%arr.length;
            Object o = arr[index];
            joiner.add(o.toString());
        }
        System.out.println(joiner.toString());
    }

    @Override
    public void showFront() {
        if (isEmpty()){
            System.out.println("队列已空");
            return;
        }
        System.out.println(arr[front]);
    }

    @Override
    public void showQueue() {
        for (int i = 0; i < arr.length; i++) {
            Object o = arr[i];
            System.out.println(i + ":" + o);
        }
    }

    private boolean isEmpty() {
        return front == rear;
    }

    private boolean isFull() {
        return (rear+1)%arr.length == front;
    }

    public static void main(String[] args) {
        System.out.println(5%5);
    }
}
