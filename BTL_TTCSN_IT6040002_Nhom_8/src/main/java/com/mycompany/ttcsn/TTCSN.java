package com.mycompany.ttcsn;

import java.util.Scanner;

public class TTCSN {

    public static void main(String[] args) {
        // Nhập dữ liệu đầu vào
        Graph graph = inputGraph();
        graph.printGraph();

        // Đo thời gian và chạy Backtracking
        System.out.println("\n=== Thuật toán Backtracking ===");
        // do trước khi chạy thuật toán 
        // yeu cau don dep truoc khi do
        System.gc();
        long backtrackingStart = System.nanoTime();
        long backtrackingMemoryStart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        BacktrackingMIS backtracking = new BacktrackingMIS();
        backtracking.solve(graph);
        // do sau khi chay thuật toán
        //  thêm thời gian chờ để đảm bảo JMV ghi nhận được sự thay đổi bộ nhớ
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            e.printStackTrace();
        }      
        long backtrackingEnd = System.nanoTime();
        long backtrackingMemoryEnd = Runtime.getRuntime().totalMemory() -Runtime.getRuntime().freeMemory();

        // Đo thời gian và chạy Greedy
        System.out.println("\n=== Thuật toán Greedy ===");
        // do trước khi thực hiện 
        // yeu cau don dep truoc khi bo  nho do
        System.gc();
        long greedyStart = System.nanoTime();
         long greedyMemoryStart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        GreedyMIS greedy = new GreedyMIS();
        greedy.solve(graph);
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            e.printStackTrace();
        }   
        long greedyEnd = System.nanoTime();
        long greedyMemoryEnd = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Phân tích và so sánh hiệu suất
        System.out.println("\n=== Phân tích kết quả ===");
        System.out.println("Thoi gian thuc thi thuat toan Backtracking: " 
            + (backtrackingEnd - backtrackingStart) / 1e6 + " ms");
        System.out.println("Bo nho su dung boi thuat toan Backtracking: " + 
                (backtrackingMemoryEnd - backtrackingMemoryStart) + " bytes");
        System.out.println("Thoi gian thuc thi thuat toan Greedy: " 
            + (greedyEnd - greedyStart) / 1e6 + " ms");
        System.out.println("Bo nho su dung boi thuat toan Greedy: " +
                (greedyMemoryEnd - greedyMemoryStart) + " bytes");
    }

    private static Graph inputGraph() {
        Scanner scanner = new Scanner(System.in);
        // Nhập số đỉnh
        System.out.print("nhap so dinh cua do thi: ");
        int n = scanner.nextInt();
        // Tạo đồ thị
        Graph graph = new Graph(n);
        // Nhập số cạnh
        System.out.print("nhap so canh cua do thi: ");
        int m = scanner.nextInt();

        System.out.println("nhap danh do thi (dạng u v, với 0 <= u, v < " + n + "):");
        for (int i = 0; i < m; i++) {
            System.out.print("Canh " + (i + 1) + ": ");
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }
        return graph;
    }
}
