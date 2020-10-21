package implement.graph;

import interfaces.graph.ASetInterface;
import interfaces.graph.VertexInterface;

import java.util.Iterator;

public class ASet implements ASetInterface
{
    @Override
    public boolean contains(Object element)
    {
        return false;
    }

    @Override
    public void add(VertexInterface element)
    {

    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public Iterator<VertexInterface> iterator()
    {
        return null;
    }
}
