package test;

import implement.dijkstra.Pi;
import implement.graph.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PiTest
{
    Vertex v1;
    Vertex v2;
    Vertex v3;

    @BeforeEach
    void setUp()
    {
        v1 = new Vertex(1);
        v2 = new Vertex(2);
        v3 = new Vertex(3);
    }

    /**
     * Test both getValueOf and setValueOf
     */
    @Test
    void valueStored()
    {
        Pi pi = new Pi();

        // nothing defined => all at +inf
        assertEquals(Integer.MAX_VALUE, pi.getValueOf(v1));
        assertEquals(Integer.MAX_VALUE, pi.getValueOf(v2));
        assertEquals(Integer.MAX_VALUE, pi.getValueOf(v3));

        // store value
        pi.setValueOf(v1, 10); // any int
        pi.setValueOf(v2, Integer.MAX_VALUE); // +inf

        // retrieve value
        assertEquals(10, pi.getValueOf(v1));        // because as been set at 10
        assertEquals(Integer.MAX_VALUE, pi.getValueOf(v2)); // because as been set at +inf
        assertEquals(Integer.MAX_VALUE, pi.getValueOf(v3)); // because as not been set
    }
}