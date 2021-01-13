package com.project.implement.dijkstra;

import com.project.implement.graph.ASet;
import com.project.interfaces.dijkstra.PiInterface;
import com.project.interfaces.dijkstra.PreviousInterface;
import com.project.interfaces.graph.ASetInterface;
import com.project.interfaces.graph.GraphInterface;
import com.project.interfaces.graph.VertexInterface;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class Dijkstra
{
    private static final Logger logger = Logger.getLogger("com.project.implement.dijkstra.Dijkstra");
    /**
     * @param g any graph
     * @param from the starting node on the graph
     * @param to the node you want to go to
     * @return your path : a list of nodes
     */
    public List<VertexInterface> shortedPath(GraphInterface g, VertexInterface from, VertexInterface to)
    {
        PreviousInterface pi = this.dijkstra(g, from, new ASet(), new Pi(), new Previous());

        ArrayList<VertexInterface> path = new ArrayList<>();

        while (!to.equals(from))
        {
            path.add(to);
            to = pi.getFatherOf(to);
        }
        path.add(to);
        Collections.reverse(path);
        return path;
    }

    /**
     * @param g any graph
     * @param r starting node
     * @param a an empty set
     * @param pi an empty pi
     * @param previous an empty previous
     * @return a filled previous
     */
    private PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi, PreviousInterface previous)
    {
        logger.info("Starting");
        a.add(r);
        VertexInterface pivot = r;
        for (VertexInterface x: g)
        {
            pi.setValueOf(x, Integer.MAX_VALUE);
        }
        pi.setValueOf(r, 0);

        for (int i = 0; i < g.size() - 1; i++)
        {
            int finalI = i;
            logger.info(() -> MessageFormat.format("Steep : {0}/{1}", finalI, g.size()));
            for (Iterator<VertexInterface> it = g.successors(pivot); it.hasNext(); )
            {
                VertexInterface y = it.next();
                if (!a.contains(y) && g.isSuccessor(pivot, y) && pi.getValueOf(pivot) + g.weight(pivot, y) < pi.getValueOf(y))
                {
                    pi.setValueOf(y, pi.getValueOf(pivot) + g.weight(pivot, y));
                    previous.setFatherOf(y, pivot);
                }
            }
            // min
            VertexInterface m = null;
            for (VertexInterface s : g)
            {
                if (!a.contains(s) && (m == null || pi.getValueOf(m) > pi.getValueOf(s)))
                {
                    m = s;
                }
            }
            pivot = m;
            a.add(m);
        }
        logger.info("Done");
        return previous;
    }
}