package implement.graph;

import interfaces.graph.VertexInterface;

public class Vertex implements VertexInterface
{
    private final int id;

    public Vertex(int id)
    {
        this.id = id;
    }

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
}
