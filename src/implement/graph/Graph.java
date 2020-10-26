package implement.graph;

import interfaces.graph.GraphInterface;
import interfaces.graph.VertexInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * GraphInterface implementation using weighs 2D array and vertex ArrayList
 */
public class Graph implements GraphInterface
{
    private final ArrayList<VertexInterface> vertexes;
    private final int[][] weights;

    public Graph(List<VertexInterface> vertexes, int[][] weights)
    {
        this.vertexes = (ArrayList<VertexInterface>) vertexes;
        this.weights = weights;
    }

    @Override
    public boolean contains(VertexInterface element)
    {
        return vertexes.contains(element);
    }

    @Override
    public boolean isSuccessor(VertexInterface father, VertexInterface child)
    {
        return this.weight(father, child) != Integer.MAX_VALUE;
    }

    @Override
    public int weight(VertexInterface one, VertexInterface two)
    {
        if (this.contains(one) && this.contains(two))
        {
            return weights[this.vertexes.indexOf(one)][this.vertexes.indexOf(two)];
        }
        else
        {
            return Integer.MAX_VALUE;
        }
    }

    @Override
    public int size()
    {
        return this.vertexes.size();
    }

    @Override
    public Iterator<VertexInterface> iterator()
    {
        return this.vertexes.iterator();
    }
}
