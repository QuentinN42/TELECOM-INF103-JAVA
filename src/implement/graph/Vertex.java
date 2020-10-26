package implement.graph;

import interfaces.graph.VertexInterface;

import java.util.Objects;

/**
 * Implement VertexInterface
 */
public class Vertex implements VertexInterface
{
    private final int id;

    public Vertex(int id)
    {
        this.id = id;
    }

    /**
     * @return the vertex id
     */
    public int getId() { return this.id; }

    /**
     * @param element the element to test
     * @return if this == element
     */
    @Override
    public boolean equals(Object element)
    {
        if (element instanceof Vertex)
        {
            return this.id == ((Vertex) element).id;
        }
        else
        {
            return false;
        }
    }

    /**
     * @return a hash value of this
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

}
