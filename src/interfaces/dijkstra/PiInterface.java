package interfaces.dijkstra;

import interfaces.graph.VertexInterface;

public interface PiInterface
{
    void setValueOf(VertexInterface object, int value);
    int getValueOf(VertexInterface object);
}