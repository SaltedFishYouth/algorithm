package cn.lsx.algorithm.datastructure.stack;

/**
 * 栈
 * @author Administrator
 */
public interface Stack {
    /**
     * description: 入栈
     *
     * @param data
     * @return void
     */
    void push(int data);

    /**
     * description: 出栈
     *
     * @param
     * @return int
     */
    int pop();

    /**
     * description: 打印
     *
     * @param
     * @return void
     */
    void show();
}
