package test;

import implement.graph.Graph;
import implement.graph.Vertex;
import interfaces.graph.VertexInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest
{
    Graph g;
    Vertex a;
    Vertex b;
    Vertex c;
    Vertex d;

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
        d = new Vertex(4);

        // define graph
        ArrayList<VertexInterface> lst = new ArrayList<>();
        lst.add(a);
        lst.add(b);
        lst.add(c);

        ab = 1;
        ac = 4;
        bc = Integer.MAX_VALUE;

        // symmetric graph
        int[][] weight = {
                {0, ab, ac},
                {ab, 0, bc},
                {ac, bc, 0}
        };

        g = new Graph(lst, weight);
    }

    @Test
    void contains()
    {
        assertTrue(g.contains(a));
        assertTrue(g.contains(b));
        assertTrue(g.contains(c));
        assertFalse(g.contains(d));
    }

    @Test
    void isSuccessor()
    {
        assertTrue(g.isSuccessor(a, b));
        assertTrue(g.isSuccessor(a, c));
        assertFalse(g.isSuccessor(b, c));
        assertFalse(g.isSuccessor(a, d));
    }

    @Test
    void weight()
    {
        assertEquals(ab, g.weight(a, b));
        assertEquals(ac, g.weight(a, c));
        assertEquals(bc, g.weight(b, c));
        assertEquals(Integer.MAX_VALUE, g.weight(a, d)); // not in the graph => +inf
    }

    @Test
    void size()
    {
        assertEquals(3, g.size());
    }

    @Test
    void iterator()
    {
        for (VertexInterface v : g)
        {
            assertTrue(g.contains(v));
        }
    }
}