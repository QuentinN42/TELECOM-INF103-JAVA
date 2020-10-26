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

    /**
     * @param vertexes List of all vertexes
     * @param weights incidence matrix
     */
    public Graph(List<VertexInterface> vertexes, int[][] weights)
    {
        // TODO(Quentin Lieumont): Add tests
        //  Verify list size == w len == w height
        this.vertexes = (ArrayList<VertexInterface>) vertexes;
        this.weights = weights;
    }

    /**
     * @param element the element to test
     * @return if the element is in the graph
     */
    @Override
    public boolean contains(VertexInterface element)
    {
        return vertexes.contains(element);
    }

    /**
     * @param father first
     * @param child second
     * @return if first -> second is a valid edge
     */
    @Override
    public boolean isSuccessor(VertexInterface father, VertexInterface child)
    {
        return this.weight(father, child) != Integer.MAX_VALUE;
    }

    /**
     * @param one first
     * @param two second
     * @return the value of first -> second if both are in the graph else +inf
     */
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

    /**
     * @return the graph size ie number of vertexes
     */
    @Override
    public int size()
    {
        return this.vertexes.size();
    }

    /**
     * Iterate over the graph
     * @return Iterator
     */
    @Override
    public Iterator<VertexInterface> iterator()
    {
        return this.vertexes.iterator();
    }
}
