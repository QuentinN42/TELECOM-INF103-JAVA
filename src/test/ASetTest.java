package test;

import implement.graph.ASet;
import implement.graph.Vertex;
import interfaces.graph.VertexInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ASetTest
{
    Vertex v1;
    Vertex v2;

    @BeforeEach
    void setUp()
    {
        v1 = new Vertex(1);
        v2 = new Vertex(2);
    }

    @Test
    void contains()
    {
        ASet set = new ASet();
        assertFalse(set.contains(v1));
        assertFalse(set.contains(1));

        set.add(v1);

        assertTrue(set.contains(v1));
        assertFalse(set.contains(1));
    }

    @Test
    void add()
    {
        ASet set = new ASet();
        set.add(v1);

        assertTrue(set.contains(v1));

        set.add(v2);

        assertTrue(set.contains(v1));
        assertTrue(set.contains(v2));
    }

    @Test
    void size()
    {
        ASet set = new ASet();
        assertEquals(0,set.size());
        set.add(v1);
        assertEquals(1,set.size());
        set.add(v2);
        assertEquals(2,set.size());

    }

    @Test
    void iterator()
    {

        ASet set = new ASet();
        set.add(v1);
        set.add(v2);

        for (VertexInterface v : set)
        {
            assertTrue(set.contains(v));
        }
    }
}