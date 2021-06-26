package cn.lsx.algorithm.datastructure;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 哈夫曼树
 * @author linShengxi
 * @date 2021/6/24
 */

public class HuffmanTree {
    private HuffmanTreeNode head;

    public void buildHuffmanTree(int arr[]) {
        if (arr == null || arr.length == 0){
            return;
        }
        List<HuffmanTreeNode > nodeList = new LinkedList<>();
        for (int data : arr) {
            nodeList.add(new HuffmanTreeNode(data));
        }
        while (nodeList.size()>1){
            //从小到大排序
            nodeList.sort(Comparator.comparingInt(HuffmanTreeNode::getData));

            //取出最小的两个
            HuffmanTreeNode leftNode = nodeList.get(0);
            HuffmanTreeNode rightNode = nodeList.get(1);

            //相加作为父节点
            HuffmanTreeNode parent = new HuffmanTreeNode(leftNode.getData() + rightNode.getData());
            parent.setLeftNode(leftNode);
            parent.setRightNode(rightNode);

            nodeList.remove(leftNode);
            nodeList.remove(rightNode);
            nodeList.add(parent);
        }

        head = nodeList.get(0);
    }

    //前序遍历
    public void DLR() {
        Stack<HuffmanTreeNode> stack = new Stack();
        stack.push(head);
        HuffmanTreeNode root = head;
        while (!stack.isEmpty() || root !=null) {
            //root 节点先打印 然后入栈，并获取左节点，在左子树执行打印root 获取左节点
            while (root !=null){
                System.out.print(root.getData()+"->");
                stack.push(root);
                root = root.getLeftNode();
            }
            //栈取的是每个子树的root节点
            root = stack.pop();
            //通过获取root节点的又节点，迭代到右子树去做相同的操作
            root = root.getRightNode();
        }
    }

    //中序遍历
    public void LDR() {
        Stack<HuffmanTreeNode> stack = new Stack();
        HuffmanTreeNode temp = head;
        while (!stack.isEmpty() || temp!=null) {
            //temp是用于按中序入栈 栈中的数据用于打印
            while (temp != null){
                stack.push(temp);
                temp = temp.getLeftNode();
            }
            temp = stack.pop();
            System.out.print(temp.getData()+"->");
            temp = temp.getRightNode();
        }
    }

    //后序遍历
    public void LRD() {
        Stack<HuffmanTreeNode> stack = new Stack();
        HuffmanTreeNode temp = head;
        HuffmanTreeNode last = null;
        while (!stack.isEmpty() || temp!=null) {
            //temp是用于按中序入栈 栈中的数据用于打印
            while (temp != null){
                stack.push(temp);
                temp = temp.getLeftNode();
            }
            temp = stack.pop();
            if (temp.getRightNode() == null || temp.getRightNode() == last){
                System.out.print(temp.getData()+"->");
                last = temp;
                temp = null;
                continue;
            }
            stack.push(temp);
            temp = temp.getRightNode();
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{13,7,8,3,29,6,1};
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.buildHuffmanTree(arr);
        huffmanTree.LRD();
    }
}

class HuffmanTreeNode{
    public HuffmanTreeNode(int data) {
        this.data = data;
    }

    private int data;
    private HuffmanTreeNode leftNode;
    private HuffmanTreeNode rightNode;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public HuffmanTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(HuffmanTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public HuffmanTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(HuffmanTreeNode rightNode) {
        this.rightNode = rightNode;
    }
}