package interfaces.graph;

import java.util.Iterator;

/**
 * Graph interface : a graph of vertexes
 */
public interface GraphInterface extends Iterable<VertexInterface>
{
    /**
     * @param element the element to test
     * @return if the element is in the graph ie a vertex of the graph
     */
    boolean contains(VertexInterface element);

    /**
     * @param father the father
     * @param child the child
     * @return if father is a father of child
     */
    boolean isSuccessor(VertexInterface father, VertexInterface child);

    /**
     * @param one first vertex
     * @param two second vertex
     * @return the weight between the first and the second vertex
     */
    int weight(VertexInterface one, VertexInterface two);

    /**
     * @return the graph size ie nb of vertexes
     */
    int size();

    /**
     * Iterate over the graph
     * @return Iterator
     */
    Iterator<VertexInterface> iterator();
}
