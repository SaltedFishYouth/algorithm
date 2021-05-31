package cn.lsx.algorithm.datastructure.linkedlist;

/**
 * @author linShengxi
 * @date 2021/5/31
 */

public interface LinkedList<T> {
    /**
     * 插入
     */
    public void add(T data);

    /**
     * 获取
     */
    public T get(int targetIndex);

    /**
     * 删除某对象节点
     */
    public void remove(T data);

    /**
     * 删除某对象节点
     */
    public void remove(int target);

    /**
     * 获取长度
     */
    public int getSize();

    /**
     * 翻转
     */
    public void reverse();
}
