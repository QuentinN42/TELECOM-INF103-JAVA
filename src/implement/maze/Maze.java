package implement.maze;

import implement.graph.Graph;
import interfaces.graph.VertexInterface;

import java.util.*;

public class Maze extends Graph
{

    /**
     * Generate a graph from a given
     * @param boxes all boxes in a 2D array.
     */
    public Maze(String[][] boxes) throws Exception
    {
        super();
        int height = boxes.length;
        int width = boxes[0].length;
        int size = height * width;
        var vertexes = new ArrayList<VertexInterface>();
        int[][] weights = new int[size][size];
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                int pos1 = i * height + j;
                vertexes.add(
                        switch (boxes[i][j])
                                {
                                    case "A" -> new ABox(i, j);
                                    case "W" -> new WBox(i, j);
                                    case "D" -> new DBox(i, j);
                                    case "E" -> new EBox(i, j);
                                    default -> throw new Exception("String : '" +
                                            boxes[i][j] + "' doesn't match A W D or E.");
                                });
                for (int k = 0; k < height; k++)
                {
                    for (int l = 0; l < width; l++)
                    {
                        int pos2 = k * height + l;
                        if(switch (boxes[k][l])
                                {
                                    case "A" -> true;
                                    case "W" -> false;
                                    case "D" -> true;
                                    case "E" -> true;
                                    default -> throw new Exception("String : '" +
                                            boxes[k][l] + "' doesn't match A W D or E.");
                                })
                        {
                            weights[pos1][pos2] = 1;
                        }
                        else
                        {
                            weights[pos1][pos2] = Integer.MAX_VALUE;
                        }
                    }
                }
            }
        }
        super.vertexes = vertexes;
        super.weights = weights;
    }
}
