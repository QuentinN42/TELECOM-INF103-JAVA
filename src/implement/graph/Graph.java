package implement.graph;

import interfaces.graph.GraphInterface;
import interfaces.graph.VertexInterface;

import java.util.ArrayList;
import java.util.Iterator;

public class Graph implements GraphInterface
{
    private ArrayList<VertexInterface> vertexes = new ArrayList<>();
    private int[][] weights;

    public Graph(ArrayList<VertexInterface> vertexes, int[][] weights)
    {
        this.vertexes = vertexes;
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

    @Override
    public void fill(int value)
    {

    }
}
