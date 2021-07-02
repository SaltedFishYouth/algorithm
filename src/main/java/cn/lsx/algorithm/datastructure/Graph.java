package cn.lsx.algorithm.datastructure;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author linShengxi
 * @date 2021/7/2
 */

public class Graph {
    private int[][] graphArr;
    private List<String> names = new LinkedList<>();
    public void insert(String value) {
        names.add(value);
    }

    public void buildEdge(String v1,String v2,int weight){
        if(graphArr == null) {
            int size = names.size();
            graphArr = new int[size][size];
        }
        int v1Index = names.indexOf(v1);
        int v2Index = names.indexOf(v2);
        if (v1Index < 0 || v2Index < 0 || v1Index == v2Index) {
            System.out.println("节点输入有误");
        }

        graphArr[v1Index][v2Index] = weight;
        graphArr[v2Index][v1Index] = weight;
    }

    public void showGraph() {
        System.out.print(" ");
        for (String name : names) {
            System.out.print(" "+name);
        }
        System.out.println();
        for (int i = 0; i < graphArr.length; i++) {
            System.out.print(names.get(i));
            for (int weight : graphArr[i]) {
                System.out.print(" "+weight);
            }
            System.out.println();
        }
    }

    /**
     * description:广度优先遍历算法
     *
     * @param
     * @return void
     */
    private void bfs() {
        System.out.println("广度优先遍历算法");
        int size = names.size();
        boolean[] isVisited = new boolean[size];
        for (int i = 0; i < size; i++) {
            bfs(isVisited,i);
        }
        System.out.println();
    }

    private void bfs(boolean[] isVisited,int index) {
        //判断是否访问过
        if (isVisited[index]) {
            return;
        }
        System.out.print(names.get(index)+"->");
        //访问本次节点，并设置为已访问
        isVisited[index] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addFirst(index);

        //循环中是广度遍历该节点的所有子节点
        while (!queue.isEmpty()) {
            Integer last = queue.removeLast();

            int nextNeighbor = getNextNeighbor(isVisited, last);
            while (nextNeighbor > -1) {
                queue.addFirst(nextNeighbor);
                System.out.print(names.get(nextNeighbor)+"->");
                isVisited[nextNeighbor] = true;
                nextNeighbor = getNextNeighbor(isVisited, last);
            }
        }
    }

    /**
     * description: 深度优先遍历算法
     *
     * @param
     * @return void
     */
    public void dfs() {
        System.out.println("深度优先遍历算法");
        int size = names.size();
        boolean[] isVisited = new boolean[size];
        for (int i = 0; i < size; i++) {
            dfs(isVisited,i);
        }
        System.out.println();
    }

    private void dfs(boolean[] isVisited,int index) {
        //判断是否访问过
        if (isVisited[index]) {
            return;
        }
        System.out.print(names.get(index)+"->");
        //访问本次节点，并设置为已访问
        isVisited[index] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(index);
        while (!stack.isEmpty()) {
            Integer last = stack.pop();
            int next = getNextNeighbor(isVisited, last);
            while (next>0) {
                System.out.print(names.get(next)+"->");
                stack.push(next);
                isVisited[next] = true;
                //深度优先遍历就拿自己的子节点
                next = getNextNeighbor(isVisited, next);
            }
        }
    }

    private int getNextNeighbor(boolean[] isVisited,int target){
        //目标下的所有节点
        int[] neighbors = graphArr[target];

        for (int i = 0; i < neighbors.length; i++) {
            int weight = neighbors[i];
            //剔除已经访问过节点
            if (weight == 0 || isVisited[i]){
                continue;
            }
            return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] names = {"1","2","3","4","5","6","7","8"};

        Graph graph = new Graph();
        for (String name : names) {
            graph.insert(name);
        }
        graph.buildEdge("1","2",1);
        graph.buildEdge("1","3",1);
        graph.buildEdge("2","4",1);
        graph.buildEdge("2","5",1);
        graph.buildEdge("3","6",1);
        graph.buildEdge("3","7",1);
        graph.buildEdge("4","8",1);
        graph.buildEdge("5","8",1);
        graph.buildEdge("6","7",1);

        graph.showGraph();

        graph.bfs();

        graph.dfs();

        /*
              1 2 3 4 5 6 7 8
            1 0 1 1 0 0 0 0 0
            2 1 0 0 1 1 0 0 0
            3 1 0 0 0 0 1 1 0
            4 0 1 0 0 0 0 0 1
            5 0 1 0 0 0 0 0 1
            6 0 0 1 0 0 0 1 0
            7 0 0 1 0 0 1 0 0
            8 0 0 0 1 1 0 0 0

            广度优先遍历算法
            1->2->3->4->5->6->7->8->

            深度优先遍历算法
            1->2->4->8->5->3->6->7->

        */
    }
}
