package implement.maze;

import error.MazeError;
import implement.graph.Graph;
import interfaces.graph.VertexInterface;

import java.util.*;

public class Maze extends Graph
{
    /**
     * Init empty maze
     */
    public Maze()
    {
        super();
    }

    /**
     * @param vertexes List of all vertexes
     * @param weights incidence matrix
     */
    public Maze(List<VertexInterface> vertexes, int[][] weights)
    {
        super.vertexes = (ArrayList<VertexInterface>) vertexes;
        super.weights = weights;
    }

    /**
     * Generate a graph from a given 2D array of string.
     * Generate all boxes and after check if this box is connected to it.
     * @param boxes all boxes in a 2D array.
     * @throws MazeError if error in file
     */
    public Maze(String[][] boxes) throws MazeError
    {
        this();

        int height = boxes.length;
        int width = boxes[0].length;
        // TODO: test if square box.

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
                                    default -> throw new MazeError("String : '" +
                                            boxes[i][j] + "' doesn't match A W D or E.");
                                });
                for (int k = 0; k < height; k++)
                {
                    for (int l = 0; l < width; l++)
                    {
                        int pos2 = k * height + l;
                        weights[pos1][pos2] = switch (boxes[k][l])
                                {
                                    case "A" -> true;
                                    case "W" -> false;
                                    case "D" -> true;
                                    case "E" -> true;
                                    default -> throw new MazeError("String : '" +
                                            boxes[k][l] + "' doesn't match A W D or E.");
                                }? 1 : Integer.MAX_VALUE;
                    }
                }
            }
        }
        super.vertexes = vertexes;
        super.weights = weights;
    }

    /**
     * @param filename path to maze
     * @throws MazeError if error in file
     */
    public Maze(String filename) throws MazeError
    {
        this(IO.File.readChars(filename));
    }
}
