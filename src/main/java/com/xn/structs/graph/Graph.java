package com.xn.structs.graph;

public class Graph {

    // 顶点集合
    private char[] vertex;

    // 邻接矩阵
    private int[][] matrix;

    /**
     * @param vexs  顶点集合{'A', 'B', 'C', 'D'}
     * @param edges 边集合{{'A', 'C'}, {'B', 'A'}, {'B', 'D'}, {'C', 'B'}, {'C', 'D'},{'D', 'B'}}
     */
    public Graph(char[] vexs, char[][] edges) {

        int vLen = vexs.length;
        int eLen = edges.length;

        // 初始化顶点集合
        this.vertex = new char[vLen];
        System.arraycopy(vexs, 0, this.vertex, 0, vLen);
        // 边
        this.matrix = new int[vLen][vLen]; // 4x4矩阵
        for (int i = 0; i < eLen; i++) {
            int p1 = getPosition(edges[i][0]); // A:0 C:2
            int p2 = getPosition(edges[i][1]); // B:1 D:3
            this.matrix[p1][p2] = 1;
        }
    }

    private int getPosition(char c) {
        for (int i = 0; i < this.vertex.length; i++) {
            if (vertex[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < this.vertex.length; i++) {
            for (int j = 0; j < this.vertex.length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        char vexs[] = {'A', 'B', 'C', 'D'};
        char edges[][] = {{'A', 'C'}, {'B', 'A'}, {'B', 'D'}, {'C', 'B'}, {'C', 'D'},{'D', 'B'}};
        Graph graph = new Graph(vexs, edges);
        graph.print();
    }
}
