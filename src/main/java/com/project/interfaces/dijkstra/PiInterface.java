package com.project.interfaces.dijkstra;

import com.project.interfaces.graph.VertexInterface;

/**
 * The Pi interface for dijkstra algorithm.
 */
public interface PiInterface
{
    /**
     * Set the value of pi(object) at value
     * @param object any vertex
     * @param value any value
     */
    void setValueOf(VertexInterface object, int value);

    /**
     * Get value of pi(object)
     * @param object any object
     * @return pi(object)
     */
    int getValueOf(VertexInterface object);
}
