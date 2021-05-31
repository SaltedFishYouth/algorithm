package cn.lsx.algorithm.datastructure.linkedlist;

/**
 * @author linShengxi
 * @date 2021/5/31
 */

public class DoubleLinkedList<T> implements LinkedList<T> {
    private int size;
    /**
     * 头结点不可变动
     */
    private DoubleNode<T> head;

    /**
     * 插入
     */
    @Override
    public void add(T data) {
        if (head == null) {
            head = new DoubleNode<>(data);
            size++;
            return;
        }
        DoubleNode node = head;
        while (node.getNextNode() != null) {
            node = node.getNextNode();
        }
        DoubleNode<T> newNode = new DoubleNode<>(data);

        node.setNextNode(newNode);
        newNode.setPreNode(node);
        size++;
    }

    /**
     * 获取
     */
    @Override
    public T get(int targetIndex) {
        if (size <= targetIndex) {
            throw new RuntimeException("目标位置 超出链表长度");
        }

        DoubleNode<T> node = head;
        int index = 0;
        while (node != null) {
            if (index == targetIndex) {
                return node.getData();
            }
            node = node.getNextNode();
            index++;
        }

        throw new RuntimeException("目标位置 超出链表长度");
    }

    /**
     * 删除某对象节点
     */
    @Override
    public void remove(T data) {
        DoubleNode<T> node = head;
        if (node == null) {
            return;
        }
        while (node != null) {
            if (node.getData() == data) {
                node.getPreNode().setNextNode(node.getNextNode());
                if (node.getNextNode() != null) {
                    node.getNextNode().setPreNode(node.getPreNode());
                }
                size--;
                return;
            }
            node = node.getNextNode();
        }
    }

    /**
     * 删除某对象节点
     */
    @Override
    public void remove(int target) {
        DoubleNode<T> node = head;
        if (target >= size) {
            return;
        }
        int index = 0;
        while (index < target && node != null) {
            node = node.getNextNode();
        }
        if (target == 0) {
            head = head.getNextNode();
            if (head.getNextNode() != null) {
                head.getNextNode().setPreNode(null);
            }
            size--;
        } else if (index == target && node != null) {
            node.getPreNode().setNextNode(node.getNextNode());
            if (node.getNextNode() != null) {
                node.getNextNode().setPreNode(node.getPreNode());
            }
            size--;
        }
    }

    /**
     * 获取长度
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 翻转
     */
    @Override
    public void reverse() {
        DoubleNode<T> node = head;
        DoubleNode<T> newHead = null;
        while (node != null) {
            DoubleNode<T> nextNode = node.getNextNode();
            node.setNextNode(newHead);
            newHead = node;
            newHead.setPreNode(nextNode);
            node = nextNode;
        }
        head = newHead;
    }

}

/**
 * 双链表节点
 */
class DoubleNode<T> {
    T data;

    public DoubleNode(T data) {
        this.data = data;
    }

    private DoubleNode<T> nextNode;
    private DoubleNode<T> preNode;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoubleNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public DoubleNode<T> getPreNode() {
        return preNode;
    }

    public void setPreNode(DoubleNode<T> preNode) {
        this.preNode = preNode;
    }
}
