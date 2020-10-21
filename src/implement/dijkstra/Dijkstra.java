package implement.dijkstra;

import interfaces.dijkstra.PiInterface;
import interfaces.dijkstra.PreviousInterface;
import interfaces.graph.ASetInterface;
import interfaces.graph.GraphInterface;
import interfaces.graph.VertexInterface;

public class Dijkstra
{
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