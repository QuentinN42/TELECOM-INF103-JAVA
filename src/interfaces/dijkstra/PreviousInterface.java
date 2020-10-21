package interfaces.dijkstra;

import interfaces.graph.VertexInterface;

public interface PreviousInterface
{
    void setFatherOf(VertexInterface object, VertexInterface father);
    VertexInterface getFatherOf(VertexInterface object);
}
