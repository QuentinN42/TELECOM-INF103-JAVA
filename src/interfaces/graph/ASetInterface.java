package interfaces.graph;

import java.util.Iterator;

/**
 * Set interface : object that contain objects
 */
public interface ASetInterface extends Iterable<VertexInterface>
{
    /**
     * @param element the element to test
     * @return if element is in set
     */
    boolean contains(Object element);

    /**
     * @param element the element to add into the set
     */
    void add(VertexInterface element);

    /**
     * @return the set size ie number of items in the set
     */
    int size();

    /**
     * Iterate over the set
     * @return Iterator
     */
    Iterator<VertexInterface> iterator();
}
