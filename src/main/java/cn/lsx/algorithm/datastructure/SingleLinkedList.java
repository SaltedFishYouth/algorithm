package cn.lsx.algorithm.datastructure;

/**
 * 单链表
 *
 * @author 25527
 */
public class SingleLinkedList<T> {
    private int size;
    /**
     * 头结点不可变动
     */
    private Node<T> head;

    /**
     * 插入
     */
    public void add(T data) {
        if (head == null) {
            head = new Node<>(data);
            size++;
            return;
        }
        Node node = head;
        while (node.getNextNode()!=null){
            node = node.getNextNode();
        }
        node.setNextNode(new Node<>(data));
        size++;
    }

    /**
     * 获取
     */
    public T get(int targetIndex) {
        if (size <= targetIndex) {
            throw new RuntimeException("目标位置 超出链表长度");
        }

        Node<T> node = head;
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
    public void remove(T data) {
        Node<T> node = head;
        if (node == null) {
            return;
        }
        while (node.getNextNode() != null) {
            if (node.getNextNode().getData() == data) {
                node.setNextNode(node.getNextNode().getNextNode());
                size--;
                return;
            }
            node = node.getNextNode();
        }
    }

    /**
     * 删除某对象节点
     */
    public void remove(int target) {
        Node<T> node = head;
        if (target >= size) {
            return;
        }
        int index = 0;
        while (index + 1 < target && node != null) {
            node = node.getNextNode();
        }
        if (target == 0){
            head = head.getNextNode();
            size--;
        } else if (index + 1 == target && node != null && node.getNextNode() != null) {
            node.setNextNode(node.getNextNode().getNextNode());
            size--;
        }
    }

    /**
     * 获取长度
     */
    public int getSize() {
        return size;
    }

    /**
     * 翻转
     */
    public void reverse() {
        Node<T> node = head;
        Node<T> newHead = null;
        while (node != null) {
            Node<T> nextNode = node.getNextNode();
            node.setNextNode(newHead);
            newHead = node;
            node = nextNode;
        }
        head = newHead;
    }


    /**
     * 单链表节点
     */
    class Node<T> {
        T data;

        public Node(T data) {
            this.data = data;
        }

        private Node<T> nextNode;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }
    }
}
