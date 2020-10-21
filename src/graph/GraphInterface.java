package graph;

import java.util.Iterator;

public interface GraphInterface extends Iterable<VertexInterface>
{
    boolean contains(VertexInterface element);
    boolean isSuccessor(VertexInterface father, VertexInterface child);
    int weight(VertexInterface one, VertexInterface two);
    int size();
    Iterator<VertexInterface> iterator();
    void fill(int value);
}
