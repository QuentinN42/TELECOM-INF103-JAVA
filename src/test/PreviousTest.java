package test;

import implement.dijkstra.Previous;
import implement.graph.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreviousTest
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
     * Test both setFatherOf and getFatherOf
     */
    @Test
    void fatherStored()
    {
        Previous pr = new Previous();

        // nothing defined => all at null
        assertNull(pr.getFatherOf(v1));
        assertNull(pr.getFatherOf(v2));
        assertNull(pr.getFatherOf(v3));

        // store value
        pr.setFatherOf(v1, v3);
        pr.setFatherOf(v2, v2);

        // retrieve value
        assertEquals(v3, pr.getFatherOf(v1));
        assertEquals(v2, pr.getFatherOf(v2));
        assertNull(pr.getFatherOf(v3));

        // change value
        pr.setFatherOf(v1, v2);

        // retest
        assertEquals(v2, pr.getFatherOf(v1));
    }
}