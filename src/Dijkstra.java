public class Dijkstra
{
    private PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface A, PiInterface pi, PreviousInterface previous)
    {
        A.add(r);
        VertexInterface pivot = r;
        pi.setValueOf(r, 0);
        for (VertexInterface x : g)
        {
            pi.setValueOf(x, Integer.MAX_VALUE);
        }

        for (int i = 0; i < g.size() - 1; i++)
        {
            for (VertexInterface y : g)
            {
                if (!A.contain(y) && g.isSuccessor(pivot, y) && pi.getValueOf(pivot) + g.weight(pivot, y) < pi.getValueOf(y))
                {
                    pi.setValueOf(y, pi.getValueOf(pivot) + g.weight(pivot, y));
                    previous.setFatherOf(y, pivot);
                }
            }
            // TODO(Quentin Lieumont): continue
            //  z <- min(_ forall _ not in A)
            //  ...
        }
        
        return previous;
    }
}