package test;

import main.Graph;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Task2Test {
    @Test
    void TestEmptyGraph(){
        Graph g = new Graph(0);
        assertEquals("", g.BFS(0));
    }

    @Test
    void TestOneVertexGraph(){
        Graph g = new Graph(1);
        assertEquals("0", g.BFS(0));
    }

    @Test
    void TestThreeVertexGraphFromZero(){
        Graph g = new Graph(3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);

        assertEquals("0 1 2", g.BFS(0));
    }

    @Test
    void TestThreeVertexGraphFromOne(){
        Graph g = new Graph(3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);

        assertEquals("1 0 2", g.BFS(1));
    }

    @Test
    void TestEightVertexGraph(){
        Graph g = new Graph(8);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 3);
        g.addEdge(1, 5);
        g.addEdge(1, 6);
        g.addEdge(2, 6);
        g.addEdge(3, 7);
        g.addEdge(4, 6);
        g.addEdge(6, 7);

        assertEquals("0 1 4 3 5 6 7 2", g.BFS(0));
    }

}
