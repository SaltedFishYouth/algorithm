package cn.lsx.algorithm.datastructure.queue;

/**
 * 队列
 * @author linShengxi
 * @date 2021/5/27
 */

public interface Queue {
    public void enQueue(Object o);

    public Object deQueue();

    public void showAll();

    public void showFront();

    public void showQueue();
}
