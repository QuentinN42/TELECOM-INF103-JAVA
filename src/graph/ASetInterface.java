package graph;

import java.util.Iterator;

public interface ASetInterface extends Iterable<VertexInterface>
{
    boolean contains(Object element);
    void add(VertexInterface element);
    int size();
    Iterator<VertexInterface> iterator();
}
