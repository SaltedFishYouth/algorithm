package cn.lsx.algorithm.datastructure;

/**
 * @author linShengxi
 * @date 2021/5/24
 */

public class Queue {
    Object[] arr;
    private int front;//第一条数据下标
    private int rear;//最后一条数据的下一个位置

    public Queue(){
        this(10); //调用其它构造方法
    }
    public Queue(int size){
        arr = new Object[size];
        front = 0;
        rear = 0;
    }

    public void enQueue(Object o){

    }


    private boolean isEmpty(){
        return front == rear;
    }

    private boolean isFull(){
        return true;
    }

}
