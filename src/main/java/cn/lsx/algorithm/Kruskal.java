package cn.lsx.algorithm;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;

/**
 * 克鲁斯卡尔算法
 *
 * @author linShengxi
 * @date 2021/7/31
 */

public class Kruskal {

    private String[] vertexs;//顶点数组
    private int[][] matrix;//邻接矩阵
    private static int NO = 999;//不能联通

    public Kruskal(String[] vertexs, int[][] matrix) {
        this.vertexs = vertexs;
        this.matrix = matrix;
    }

    public static void main(String[] args) {
        String[] vertexs = new String[]{"A","B","C","D","E","F","G"};

        //邻接矩阵
        int matrix[][] = {
                     /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0 ,  12,  NO,  NO,  NO,  16,  14},
                /*B*/ {12,   0,  10,  NO,  NO,   7,  NO},
                /*C*/ {NO,  10,   0,   3,   5,   6,  NO},
                /*D*/ {NO,  NO,   3,   0,   4,  NO,  NO},
                /*E*/ {NO,  NO,   5,   4,   0,   2,   8},
                /*F*/ {16,   7,   6,  NO,   2,   0,   9},
                /*G*/ {14,  NO,  NO,  NO,   8,   9,   0}
        };

        Kruskal kruskal = new Kruskal(vertexs,matrix);

        kruskal.show();
        kruskal.calculate();

    }

    private void calculate() {
        //创建边
        List<Edge> edgeList = buildEdge();
        //对边进行从小大打排序
        bubbleSort(edgeList);

        //节点的链接的最大节点 当两个节点的 最大节点相同时 就不能相连会构成回路
        int[] edgeEndVertex = new int[vertexs.length];
        for (int i = 0; i < edgeEndVertex.length; i++) {
            edgeEndVertex[i] = i;
        }
        List<Edge> result = new LinkedList<>();

        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            //最大节点相同 构成回路 不可以相连
            int startVertex = getEnds(edgeEndVertex,edge.start);
            int endVertex = getEnds(edgeEndVertex,edge.end);

            if (startVertex == endVertex) {
                continue;
            }

            int maxEndVertex = startVertex>endVertex?startVertex:endVertex;
//            edgeEndVertex[edge.start] = maxEndVertex;
            setEnds(edgeEndVertex,edge.start,maxEndVertex);
            result.add(edge);
        }

        System.out.println("打印结果");
        for (Edge edge : result) {
            System.out.println(edge);
        }
    }

    /**
     * description:获取节点的最大节点
     *
     * @param edgeEndVertex
     * @param i
     * @return int
     */
    private int getEnds(int[] edgeEndVertex ,int i){

        while (edgeEndVertex[i] != i) {
            i = edgeEndVertex[i];
        }
        return i;
    }
    /**
     * description:获取节点的最大节点
     *
     * @param edgeEndVertex
     * @param i
     * @return int
     */
    private int setEnds(int[] edgeEndVertex ,int i,int end){

        while (edgeEndVertex[i] != i) {
            i = edgeEndVertex[i];
            edgeEndVertex[i] = end;
        }
        edgeEndVertex[i] = end;
        return i;
    }

    private List<Edge> buildEdge() {
        int length = vertexs.length;
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int weight = matrix[i][j];
                if (weight == NO || weight==0) {
                    continue;
                }
                edgeList.add(new Edge(i,j,weight));
            }
        }
        return edgeList;
    }

    private void bubbleSort(List<Edge> list) {
        //如果某一次排序时，没有发生交换说明已经排序完成无须接着排序
        boolean okFlag = true;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size() - i; j++) {
                if (list.get(j - 1).weight > list.get(j).weight) {
                    Edge temp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                    okFlag = false;
                }
            }
            if (okFlag) {
                return;
            }
        }
    }

    /**
     * description:打印矩阵图
     *
     * @param
     * @return void
     */
    public void show() {
        System.out.print("    ");
        for (String vertex : vertexs) {
            System.out.print(showContext(vertex)+" ");
        }

        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(vertexs[i] + ":  ");
            for (int j = 0; j < matrix[i].length; j++) {
                String value = String.valueOf(matrix[i][j]);

                System.out.print(showContext(value) + ",");
            }
            System.out.println();
        }
    }

    private String showContext(String context) {
        int add = 5 - context.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < add; i++) {
            builder.append(" ");
        }

        builder.append(context);
        return builder.toString();
    }

    class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{<"  + vertexs[start] + "," + vertexs[end] + ">=" + weight +"}";
        }
    }


}
