package test;

import implement.graph.Vertex;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VertexTest
{
    Vertex v1;
    Vertex v1Second;
    Vertex v2;
    Vertex v3;

    @BeforeEach
    void setUp()
    {
        // define 4 vertexes
        v1 = new Vertex(1);
        v1Second = new Vertex(1);
        v2 = new Vertex(2);
        v3 = new Vertex(3);
    }

    @Test
    void getId()
    {
        assertEquals(1, v1.getId());
        assertEquals(2, v2.getId());
        assertEquals(3, v3.getId());
    }

    @Test
    void testToString()
    {
        assertEquals("Vertex(1)", v1.toString());
        assertEquals("Vertex(2)", v2.toString());
        assertEquals("Vertex(3)", v3.toString());
    }

    @Test
    void testEquals()
    {
        // ==
        assertEquals(v1, v1);
        assertEquals(v1, v1Second);

        // !=
        assertNotEquals(v1, v2);
        assertNotEquals(v1, v3);
    }
}