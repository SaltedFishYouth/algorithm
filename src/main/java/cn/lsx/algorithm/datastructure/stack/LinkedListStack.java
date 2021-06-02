package cn.lsx.algorithm.datastructure.stack;

/**
 * 链表栈
 * @author Administrator
 */
public class LinkedListStack implements Stack{
    private Node headNode;
    @Override
    public void push(int data) {
        if (headNode == null){
            headNode = new Node(data);
            return;
        }
        while (headNode.getNextNode() != null) {
            headNode = headNode.getNextNode();
        }
        headNode.setNextNode(new Node(data));
    }

    @Override
    public int pop() {
        while (headNode.getNextNode().getNextNode() != null){
            headNode = headNode.getNextNode();
        }
        int data = headNode.getNextNode().getData();
        headNode.setNextNode(null);
        return data;
    }

    @Override
    public void show() {
        if (headNode == null){
            System.out.println("队列为空");
        }
        Node reverse = reverse();
        int i = 0;
        while (reverse != null){
            System.out.println("["+i+"]:"+reverse.getData());
            i++;
        }
    }

    private Node reverse(){
        Node newHead = null;
        Node temp = headNode;
        while (temp != null) {
            Node nextNode = temp.getNextNode();
            newHead = nextNode;
            newHead.setNextNode(temp);
            temp = temp.getNextNode();
        }
        return newHead;
    }
}

class Node{
    private int data;
    private Node nextNode;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
