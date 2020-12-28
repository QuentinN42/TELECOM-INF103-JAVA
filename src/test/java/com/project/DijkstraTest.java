package com.project;

import com.project.implement.dijkstra.Dijkstra;
import com.project.implement.graph.Graph;
import com.project.implement.graph.Vertex;
import com.project.interfaces.graph.VertexInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest
{
    Graph g;
    Vertex a;
    Vertex b;
    Vertex c;

    int ab;
    int ac;
    int bc;

    @BeforeEach
    void setUp()
    {
        // init vertexes
        a = new Vertex(1);
        b = new Vertex(2);
        c = new Vertex(3);

        // define graph
        ArrayList<VertexInterface> lst = new ArrayList<>();
        lst.add(a);
        lst.add(b);
        lst.add(c);

        ab = 1;
        ac = 4;
        bc = 2;

        // symmetric graph
        int[][] weight = {
                {0, ab, ac},
                {ab, 0, bc},
                {ac, bc, 0}
        };

        g = new Graph(lst, weight);
    }

    @Test
    void shortedPath()
    {
        ArrayList<Vertex> expected1 = new ArrayList<>(Arrays.asList(a, b, c));
        ArrayList<VertexInterface> path1 = (ArrayList<VertexInterface>) (new Dijkstra()).shortedPath(g, a, c);

        assertEquals(expected1, path1);


        ArrayList<Vertex> expected2 = new ArrayList<>(Arrays.asList(a, b));
        ArrayList<VertexInterface> path2 = (ArrayList<VertexInterface>) (new Dijkstra()).shortedPath(g, a, b);

        assertEquals(expected2, path2);


        ArrayList<Vertex> expected3 = new ArrayList<>(Arrays.asList(b, c));
        ArrayList<VertexInterface> path3 = (ArrayList<VertexInterface>) (new Dijkstra()).shortedPath(g, b, c);

        assertEquals(expected3, path3);
    }
}