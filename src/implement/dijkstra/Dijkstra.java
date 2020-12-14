package implement.dijkstra;

import implement.graph.ASet;
import implement.graph.Graph;
import implement.graph.Vertex;
import interfaces.dijkstra.PiInterface;
import interfaces.dijkstra.PreviousInterface;
import interfaces.graph.ASetInterface;
import interfaces.graph.GraphInterface;
import interfaces.graph.VertexInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra
{
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
        a.add(r);
        VertexInterface pivot = r;
        for (VertexInterface x: g)
        {
            pi.setValueOf(x, Integer.MAX_VALUE);
        }
        pi.setValueOf(r, 0);

        for (int i = 0; i < g.size() - 1; i++)
        {
            for (VertexInterface y : g)
            {
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
        return previous;
    }
}