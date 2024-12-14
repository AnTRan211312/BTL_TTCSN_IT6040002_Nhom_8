package com.mycompany.ttcsn;

public class Graph {
    private int n; // Số đỉnh
    private boolean[][] adjacencyMatrix; // Ma trận kề

    // Constructor
    public Graph(int n) {
        this.n = n;
        this.adjacencyMatrix = new boolean[n][n];
    }

    // Thêm cạnh vào đồ thị
    public void addEdge(int u, int v) {
        if (u >= 0 && v >= 0 && u < n && v < n) {
            adjacencyMatrix[u][v] = true;
            adjacencyMatrix[v][u] = true; // Đồ thị vô hướng
        } else {
            System.out.println("Cạnh không hợp lệ: (" + u + ", " + v + ")");
        }
    }

    // Hiển thị ma trận kề
    public void printGraph() {
        System.out.println("Ma trận kề của đồ thị:");
        for (boolean[] row : adjacencyMatrix) {
            for (boolean cell : row) {
                System.out.print(cell ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    // Getter cho số đỉnh
    public int getNumberOfVertices() {
        return n;
    }

    // Getter cho ma trận kề
    public boolean[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }
}
