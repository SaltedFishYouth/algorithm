package cn.lsx.algorithm.datastructure;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 平衡二叉树(AVL树)
 *
 * @author linShengxi
 * @date 2021/6/26
 */

public class BalancedBinaryTree {
    private Node root;

    public void add(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node temp = root;
        while (true) {
            if (temp.getData() < data && temp.getRight() != null) {
                temp = temp.getRight();
                continue;
            }
            if (temp.getData() > data && temp.getLeft() != null) {
                temp = temp.getLeft();
                continue;
            }
            break;
        }
        if (temp.getData() < data) {
            temp.setRight(new Node(data));
        } else {
            temp.setLeft(new Node(data));
        }
        balanceTree();
    }

    public void delete(int data) {
        System.out.println();
        System.out.println("删除节点"+data);

        //分三种，叶子节点、只有一颗子树、有两颗子树
        Node p = null;
        Node temp = root;
        if (temp == null) {
            System.out.println("树为空");
            return;
        }

        while (temp != null && temp.getData() != data) {

            if (temp.getData() > data) {
                p = temp;
                temp = temp.getLeft();
            }
            if (temp.getData() < data) {
                p = temp;
                temp = temp.getRight();
            }
        }
        if (temp == null) {
            System.out.println("无此记录");
            return;
        }

        //删除节点是叶子,直接删除
        if (temp.getLeft() == null && temp.getRight() == null) {
            if (p == null) {
                //删除的是root节点
                temp = null;
            } else if (p.getRight().getData() == temp.getData()) {
                p.setRight(null);
            } else {
                p.setLeft(null);
            }
        } else if (temp.getLeft() != null && temp.getRight() != null) {
            //删除的有两颗子树,将右子树最小的节点放到删除的节点上
            Node node = delRightMinNode(temp);
            temp.setData(node.getData());
        } else {
            //删除只有一颗子树的节点
            if (p == null) {
                //删除的是root节点
                if (temp.getRight() != null) {
                    root = temp.getRight();
                } else {
                    root = temp.getLeft();
                }
                return;
            } else if (temp.getRight() != null) {
                p.setRight(temp.getRight());
            } else {
                p.setLeft(temp.getLeft());
            }
        }
        balanceTree();
    }

    public void DLR() {
        System.out.println("");
        System.out.println("前序遍历");
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        while (!stack.isEmpty() || temp!=null) {
            while (temp!=null){
                System.out.print(temp.getData()+"->");
                stack.push(temp);
                temp = temp.getLeft();
            }
            temp = stack.pop();
            temp = temp.getRight();
        }
    }

    public void LDR() {
        System.out.println("");
        System.out.println("中序遍历");
        Stack<Node> stack = new Stack();
        Node temp = root;
        while (!stack.isEmpty() || temp != null) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.getLeft();
            }
            temp = stack.pop();
            System.out.print(temp.getData()+"->");
            temp = temp.getRight();
        }
    }

    public void LRD() {
        System.out.println("");
        System.out.println("后序遍历");
        Stack<Node> stack = new Stack();
        Node temp = root;
        Node pre = null;
        while (!stack.isEmpty() || temp != null) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.getLeft();
            }
            temp = stack.pop();
            //和中序相比，不能直接打印节点，得判断是否去过右边才能打印
            if (temp.getRight() == null || pre == temp.getRight()) {
                System.out.print(temp.getData()+"->");
                pre = temp;
                temp = null;
                continue;
            }
            stack.push(temp);
            temp = temp.getRight();
        }
    }
    private void balanceTree(){
        //进行高度验证
        int leftHight = getLeftHight();
        int rightHight = getRightHight();

        //双旋转如{10,11,7,6,8,9}
        //左子树高度比右子树高度高于1差值，进行右旋转
        if (leftHight - rightHight > 1) {
            //右旋转时 判断该节点的左子树A，A的右子树高度是否大于A的左子树高度，是的话对A左旋转
            if (root.getLeft() !=null && getHight(root.getLeft().getRight())>getHight(root.getLeft().getLeft())) {
                leftRotate(root.getLeft());
            }
            rightRotate(root);
        }

        //右子树高度比左子树高度高于1差值，进行左旋转
        if (rightHight - leftHight > 1) {
            //左旋转时 判断该节点的右子树A，A的左子树高度是否大于A的右子树高度，是的话对A右旋转
            if (root.getRight() !=null && getHight(root.getRight().getLeft())>getHight(root.getRight().getRight())) {
                rightRotate(root.getRight());
            }
            leftRotate(root);
        }
    }
    /**
     * description:返回节点右子树最小的节点，并在该右子树删除
     *
     * @param node
     * @return cn.lsx.algorithm.datastructure.Node
     */
    private Node delRightMinNode(Node node){
        if (node.getRight() == null) {
            return null;
        }
        Node p = node;
        Node temp = node.getRight();
        while (temp.getLeft() != null){
            temp = temp.getLeft();
        }
        p.setLeft(null);
        return temp;
    }
    /**
     * description:左旋转
     *
     * @param
     * @return void
     */
    private void leftRotate(Node target) {
        Node node = new Node(target.getData());
        node.setRight(target.getRight().getLeft());
        node.setLeft(target.getLeft());
        target.setData(target.getRight().getData());
        target.setRight(target.getRight().getRight());
        target.setLeft(node);
    }

    /**
     * description:右旋转
     *
     * @param
     * @return void
     */
    private void rightRotate(Node target) {
        Node node = new Node(target.getData());
        node.setRight(target.getRight());
        node.setLeft(target.getLeft().getRight());
        target.setData(target.getLeft().getData());
        target.setLeft(target.getLeft().getLeft());
        target.setRight(node);
    }

    private int getLeftHight() {
        return getHight(root.getLeft());
    }

    private int getRightHight() {
        return getHight(root.getRight());
    }

    private int getHight(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHight = getHight(node.getLeft()) + 1;
        int rightHight = getHight(node.getRight()) + 1;
        return leftHight > rightHight ? leftHight : rightHight;
    }

    private void levelOrder(){
        LinkedList<List<Node>> list = new LinkedList<>();
        List rootList = new LinkedList();
        rootList.add(root);
        list.add(rootList);
        boolean allNull = false;
        while (list.getLast() !=null && !list.getLast().isEmpty()){
            List<Node> temp = list.getLast();
            if (allNull){
                break;
            }
            allNull = true;
            LinkedList<Node> addList = new LinkedList<>();
            for (Node node : temp) {
                if (node == null){
                    addList.add(null);
                    addList.add(null);
                    continue;
                }
                allNull = false;
                addList.add(node.getLeft());
                addList.add(node.getRight());
            }
            if (allNull){
                continue;
            }
            list.add(addList);
        }
        list.removeLast();
        for (int i = 0; i < list.size(); i++) {
            List<Node> nodes = list.get(i);
            for (Node node : nodes) {
                System.out.print(node==null?"-":String.valueOf(node.getData()));
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        BalancedBinaryTree tree = new BalancedBinaryTree();
        tree.add(10);
        tree.add(11);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.levelOrder();
        tree.delete(7);
        tree.levelOrder();
        tree.DLR();
        tree.LDR();
        tree.LRD();
    }

}

class Node {
    public Node(int data) {
        this.data = data;
    }

    private int data;
    private Node left;
    private Node right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
