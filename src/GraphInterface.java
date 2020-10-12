import java.util.Iterator;

public interface GraphInterface extends Iterable<VertexInterface>
{
    boolean contain(VertexInterface element);
    boolean isSuccessor(VertexInterface father, VertexInterface child);
    int weight(VertexInterface one, VertexInterface two);
    int size();
    Iterator<VertexInterface> iterator();
}
