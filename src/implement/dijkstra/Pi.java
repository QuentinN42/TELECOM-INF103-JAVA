package implement.dijkstra;

import interfaces.dijkstra.PiInterface;
import interfaces.graph.VertexInterface;

import java.util.HashMap;


/**
 * Implement PiInterface using HashMap
 */
public class Pi implements PiInterface
{
    private final HashMap<VertexInterface, Integer> vertexes = new HashMap<>();

    @Override
    public void setValueOf(VertexInterface object, int value)
    {
        vertexes.put(object, value);
    }

    @Override
    public int getValueOf(VertexInterface object)
    {
        return vertexes.getOrDefault(object, Integer.MAX_VALUE);
    }
}
