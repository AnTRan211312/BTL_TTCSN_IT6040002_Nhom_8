/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ttcsn;

import com.mycompany.ttcsn.Graph;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author nguyentoan
 */
public class BacktrackingMIS {
    private int maxSetSize = 0; // Kích thước tập độc lập lớn nhất
    private Set<Integer> maxSet = new HashSet<>(); // Lưu tập độc lập lớn nhất
    
    
    // Hàm tìm kiếm qua các đỉnh (Backtracking)
    private void findMaxIndependentSet(int node, Set<Integer> currentSet, boolean[][] graph, int n) {
        if (node == n) {
            if (currentSet.size() > maxSetSize) {
                maxSetSize = currentSet.size();
                maxSet = new HashSet<>(currentSet);
            }
            return;
        }
        // Không chọn đỉnh hiện tại
        findMaxIndependentSet(node + 1, currentSet, graph, n);
        
        // Kiểm tra có thể chọn đỉnh hiện tại hay không
        boolean canAdd = true;
        for (int neighbor : currentSet) {
            if (graph[node][neighbor]) {
                canAdd = false;
                break;
            }
        }
        if (canAdd) {
            currentSet.add(node); // Chọn đỉnh
            findMaxIndependentSet(node + 1, currentSet, graph, n); // Tiến hành tìm kiếm
            currentSet.remove(node); // Quay lại (backtrack)
        }
    }
    
    public void solve(Graph graph) {
        findMaxIndependentSet(0, new HashSet<>(), graph.getAdjacencyMatrix(), graph.getNumberOfVertices());
        System.out.println("kich thuoc lon nhat (Backtracking): " + maxSetSize);
        System.out.println("tap doc lap lon nhat: " + maxSet);
    }
}
