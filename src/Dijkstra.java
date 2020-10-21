public class Dijkstra
{
    private PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface A, PiInterface pi, PreviousInterface previous)
    {
        A.add(r);
        VertexInterface pivot = r;
        g.fill(Integer.MAX_VALUE);
        pi.setValueOf(r, 0);

        for (int i = 0; i < g.size() - 1; i++)
        {
            for (VertexInterface y : g)
            {
                if (!A.contains(y) && g.isSuccessor(pivot, y) && pi.getValueOf(pivot) + g.weight(pivot, y) < pi.getValueOf(y))
                {
                    pi.setValueOf(y, pi.getValueOf(pivot) + g.weight(pivot, y));
                    previous.setFatherOf(y, pivot);
                }
            }
            // min
            VertexInterface m = null;
            for (VertexInterface s : g)
            {
                if (!A.contains(s) && (m == null || pi.getValueOf(m) > pi.getValueOf(s)))
                {
                    m = s;
                }
            }
            pivot = m;
            A.add(m);
        }
        return previous;
    }
}