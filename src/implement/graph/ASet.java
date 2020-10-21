package implement.graph;

import interfaces.graph.ASetInterface;
import interfaces.graph.VertexInterface;

import java.util.HashSet;
import java.util.Iterator;

public class ASet implements ASetInterface
{
    private final HashSet<VertexInterface> vertexes = new HashSet<>();

    @Override
    public boolean contains(Object element)
    {
        if (element instanceof VertexInterface)
        {
            return vertexes.contains(element);
        }
        else
        {
            return false;
        }
    }

    @Override
    public void add(VertexInterface element)
    {
        vertexes.add(element);
    }

    @Override
    public int size()
    {
        return vertexes.size();
    }

    @Override
    public Iterator<VertexInterface> iterator()
    {
        return vertexes.iterator();
    }
}
