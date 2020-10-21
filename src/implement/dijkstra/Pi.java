package implement.dijkstra;

import interfaces.dijkstra.PiInterface;
import interfaces.graph.VertexInterface;

import java.util.HashMap;

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
        if (this.vertexes.containsKey(object))
        {
            return vertexes.get(object);
        }
        else
        {
            return Integer.MAX_VALUE;
        }
    }
}
