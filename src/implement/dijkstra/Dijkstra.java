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
    public List<Vertex> shortedPath(Graph g, Vertex from, Vertex to)
    {
        Previous pi = (Previous) this.dijkstra(g, from, new ASet(), new Pi(), new Previous());

        ArrayList<Vertex> path = new ArrayList<>();

        while (!pi.getFatherOf(from).equals(to))
        {
            path.add(from);
            from = (Vertex) pi.getFatherOf(from);
        }
        path.add(to);
        Collections.reverse(path);
        return path;
    }

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