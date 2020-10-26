package main;

import implement.dijkstra.Dijkstra;
import implement.graph.Graph;
import implement.graph.Vertex;
import interfaces.graph.VertexInterface;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        // init vertexes
        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);
        Vertex c = new Vertex(3);

        // define graph
        ArrayList<VertexInterface> lst = new ArrayList<>();
        lst.add(a);
        lst.add(b);
        lst.add(c);

        int ab = 1;
        int ac = 4;
        int bc = 2;

        // symmetric graph
        int[][] weight = {
                {0, ab, ac},
                {ab, 0, bc},
                {ac, bc, 0}
        };

        Graph g = new Graph(lst, weight);

        // use Dijkstra

        ArrayList<Vertex> path = (ArrayList<Vertex>) (new Dijkstra()).shortedPath(g, a, c);
        System.out.println(path.size());
        for(Vertex e : path)
        {
            System.out.println(e);
        }
    }
}
