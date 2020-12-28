package com.project.implement.dijkstra;

import com.project.interfaces.dijkstra.PiInterface;
import com.project.interfaces.graph.VertexInterface;

import java.util.HashMap;


/**
 * Implement PiInterface using HashMap
 */
public class Pi implements PiInterface
{
    private final HashMap<VertexInterface, Integer> vertexes = new HashMap<>();

    /**
     * @param object The object to value
     * @param value The value for this object
     */
    @Override
    public void setValueOf(VertexInterface object, int value)
    {
        vertexes.put(object, value);
    }

    /**
     * @param object The object
     * @return The value of this object
     */
    @Override
    public int getValueOf(VertexInterface object)
    {
        return vertexes.getOrDefault(object, Integer.MAX_VALUE);
    }
}
