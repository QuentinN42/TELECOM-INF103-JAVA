package implement.graph;

import interfaces.graph.GraphInterface;
import interfaces.graph.VertexInterface;

import java.util.Iterator;

public class Graph implements GraphInterface
{
    @Override
    public boolean contains(VertexInterface element)
    {
        return false;
    }

    @Override
    public boolean isSuccessor(VertexInterface father, VertexInterface child)
    {
        return false;
    }

    @Override
    public int weight(VertexInterface one, VertexInterface two)
    {
        return 0;
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

    @Override
    public void fill(int value)
    {

    }
}