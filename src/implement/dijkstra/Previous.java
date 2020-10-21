package implement.dijkstra;

import interfaces.dijkstra.PreviousInterface;
import interfaces.graph.VertexInterface;

import java.util.HashMap;

public class Previous implements PreviousInterface
{
    private final HashMap<VertexInterface, VertexInterface> viviHashMap = new HashMap<>();

    @Override
    public void setFatherOf(VertexInterface object, VertexInterface father)
    {
        this.viviHashMap.put(object, father);
    }

    @Override
    public VertexInterface getFatherOf(VertexInterface object)
    {
        return this.viviHashMap.getOrDefault(object, null);
    }
}
