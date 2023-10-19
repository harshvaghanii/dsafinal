package Graphs;

import java.util.*;

// Taking an input using adjacency list
public class Graph {
    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void addEdge(int[][] graph, int i, int j) {
        graph[i][j] = 1;
        graph[j][i] = 1;
    }

    public static void printGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    System.out.println(i + "=>" + j);
                }
            }
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(source + "=>");
        for (int i : graph.get(source)) {
            if (!visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }

    public static void dfs(int[][] graph, int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(source + "=>");

        for (int j = 0; j < graph[source].length; j++) {
            if (graph[source][j] == 1 && !visited[j]) {
                dfs(graph, j, visited);
            }
        }

    }

    public static void bfs(ArrayList<ArrayList<Integer>> graph, int source, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        while (!q.isEmpty()) {
            int node = q.remove();
            System.out.print(node + "=>");
            for (int i : graph.get(node)) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void bfs(int[][] graph, boolean[] visited, int source) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        while (!q.isEmpty()) {
            int node = q.remove();
            System.out.print(node + "=>");
            for (int i = 0; i < graph.length; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void printGraph(ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.println(i + " => " + graph.get(i).get(j));
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }
        addEdge(list, 0, 1);
        addEdge(list, 0, 2);
        addEdge(list, 1, 2);
        addEdge(list, 1, 3);
        addEdge(list, 2, 4);
        dfs(list, 0, new boolean[V]);
        System.out.println("End of DFS for List");
        bfs(list, 0, new boolean[V]);
        System.out.println("End of BFS for List");
        // printGraph(list);

        // Creating an adjacency matrix

        int[][] adj = new int[V][V];
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        dfs(adj, 0, new boolean[V]);
        System.out.println("End of DFS for Mat");
        bfs(adj, new boolean[V], 0);
        System.out.println("End of BFS for Mat");
        // printGraph(adj);
    }
}
