package main;

import java.io.*;
import java.util.*;


public class Graph {
    private final int V;
    private final LinkedList<Integer>[] adj;

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public String BFS(int s) {
        if (V == 0)
            return "";

        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);
        StringBuilder resultBuilder = new StringBuilder();
        while (queue.size() != 0) {
            s = queue.poll();
            resultBuilder.append(s).append(" ");

            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        return resultBuilder.substring(0, resultBuilder.toString().length() - 1);
    }

}