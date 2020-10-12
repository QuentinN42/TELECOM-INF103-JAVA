import java.util.Iterator;

public interface ASetInterface extends Iterable<VertexInterface>
{
    boolean contain(Object element);
    void add(VertexInterface element);
    int size();
    Iterator<VertexInterface> iterator();
}
