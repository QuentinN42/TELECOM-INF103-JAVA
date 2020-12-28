package com.project.implement.dijkstra;

import com.project.interfaces.dijkstra.PreviousInterface;
import com.project.interfaces.graph.VertexInterface;

import java.util.HashMap;

/**
 * Implement PreviousInterface using HashMap
 */
public class Previous implements PreviousInterface
{
    private final HashMap<VertexInterface, VertexInterface> viviHashMap = new HashMap<>();

    /**
     * @param object The object to add father
     * @param father The father of object
     */
    @Override
    public void setFatherOf(VertexInterface object, VertexInterface father)
    {
        this.viviHashMap.put(object, father);
    }

    /**
     * @param object The object to get father
     * @return The father of object or null
     */
    @Override
    public VertexInterface getFatherOf(VertexInterface object)
    {
        return this.viviHashMap.getOrDefault(object, null);
    }
}
