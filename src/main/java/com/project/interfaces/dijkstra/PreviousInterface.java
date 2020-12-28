package com.project.interfaces.dijkstra;

import com.project.interfaces.graph.VertexInterface;

/**
 * The Previous interface for dijkstra algorithm.
 */
public interface PreviousInterface
{
    /**
     * Set the father of object
     * @param object any vertex
     * @param father any other vertex
     */
    void setFatherOf(VertexInterface object, VertexInterface father);
    /**
     * Get the father of object
     * @param object any vertex
     * @return the father of object
     */
    VertexInterface getFatherOf(VertexInterface object);
}
