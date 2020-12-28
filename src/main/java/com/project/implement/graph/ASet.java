package com.project.implement.graph;

import com.project.interfaces.graph.ASetInterface;
import com.project.interfaces.graph.VertexInterface;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Implement ASetInterface using HashSet
 */
public class ASet implements ASetInterface
{
    private final HashSet<VertexInterface> vertexes = new HashSet<>();

    /**
     * @param element the element to test
     * @return if the element is in the set
     */
    @Override
    public boolean contains(Object element)
    {
        if (element instanceof VertexInterface)
        {
            return vertexes.contains(element);
        }
        else
        {
            return false;
        }
    }

    /**
     * @param element the element to add
     */
    @Override
    public void add(VertexInterface element)
    {
        vertexes.add(element);
    }

    /**
     * @return the set size ie number of items in the set
     */
    @Override
    public int size()
    {
        return vertexes.size();
    }

    /**
     * Iterate over the set
     * @return Iterator
     */
    @Override
    public Iterator<VertexInterface> iterator()
    {
        return vertexes.iterator();
    }
}
