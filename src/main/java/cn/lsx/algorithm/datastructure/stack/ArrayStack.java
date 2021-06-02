package cn.lsx.algorithm.datastructure.stack;


/**
 * 数组栈
 *
 * @author Administrator
 */
public class ArrayStack implements Stack {
    private int[] arr;
    private int stackTop;

    public ArrayStack(int max) {
        arr = new int[max];
        stackTop = -1;
    }

    @Override
    public void push(int data) {
        if (isPull()) {
            System.out.println("栈已满！");
            return;
        }
        stackTop++;
        arr[stackTop] = data;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈是空的！");
        }

        int data = arr[stackTop];
        stackTop--;
        return data;
    }

    @Override
    public void show() {
        System.out.println("-----  打印栈  -----");

        if (isEmpty()) {
            System.out.println("栈是空的！");
            return;
        }

        for (int i = 0; i <= stackTop; i++) {
            System.out.println("[" + i + "]" + arr[i]);
        }
    }

    private boolean isEmpty() {
        if (stackTop == -1) {
            return true;
        }
        return false;
    }

    private boolean isPull() {
        if (stackTop == arr.length - 1) {
            return true;
        }
        return false;
    }
}
