package cn.lsx.algorithm;

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
        String start;
        String end;
        int weight;

        public Edge(String start, String end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{<"  + start + "," + end + ">=" + weight +"}";
        }
    }


}
