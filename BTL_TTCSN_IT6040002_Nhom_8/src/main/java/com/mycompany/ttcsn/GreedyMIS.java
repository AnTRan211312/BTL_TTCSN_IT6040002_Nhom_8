/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ttcsn;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguyentoan
 */
public class GreedyMIS {
    public void solve(Graph graph) {
        int n = graph.getNumberOfVertices();
        boolean[][] adjacencyMatrix = graph.getAdjacencyMatrix();

        boolean[] visited = new boolean[n];
        List<Integer> independentSet = new ArrayList<>();

        // Duyệt qua từng đỉnh trong đồ thị
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                independentSet.add(i); // Chọn đỉnh i
                // Đánh dấu các đỉnh kề với i là đã thăm
                for (int j = 0; j < n; j++) {
                    if (adjacencyMatrix[i][j]) { // Đánh dấu các đỉnh kề
                        visited[j] = true;
                    }
                }
            }
        }
        System.out.println("Kich thuoc tap doc lap lon nhat (Greedy): " + independentSet.size());
        System.out.println("Tap doc lap lon nhat: " + independentSet);
    }
}
