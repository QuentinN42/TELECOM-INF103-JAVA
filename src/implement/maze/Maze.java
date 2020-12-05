package implement.maze;

import error.MazeError;
import interfaces.graph.GraphInterface;
import interfaces.graph.VertexInterface;

import java.util.HashMap;
import java.util.Iterator;

/**
 * GraphInterface implementation from text file with a maze.
 */
public class Maze implements GraphInterface
{
    private final HashMap<int[], VertexInterface> boxes;
    private int height;
    private int width;

    public Maze()
    {
        boxes = new HashMap<>();
    }

    public Maze(String fileName) throws MazeError
    {
        this();
        this.initFromTextFile(fileName);
    }


    public final void initFromTextFile(String fileName) throws MazeError
    {
        String[][] data = IO.File.readChars(fileName);
        this.height = data.length;
        this.width = data[0].length;
        for (int i = 0; i < this.height; i++)
        {
            if(data[i].length != this.width)
                throw new MazeError("Invalid lines length in '" + fileName + "' !");
            for (int j = 0; j < this.width; j++)
            {
                boxes.put(new int[]{i, j}, Box.newBox(i, j, data[i][j]));
            }
        }
    }

    /**
     * @param element the element to test
     * @return if the element is in the maze
     */
    @Override
    public boolean contains(VertexInterface element)
    {
        return boxes.containsValue(element);
    }

    /**
     * @param father first
     * @param child second
     * @return if first to second is a valid edge
     */
    @Override
    public boolean isSuccessor(VertexInterface father, VertexInterface child)
    {
        if (this.contains(father) && this.contains(child) && father instanceof Box && child instanceof Box)
        {
            Box f = (Box) father;
            Box c = (Box) child;

            if (!(f.isSolid()) &&(!c.isSolid()))
                return f.distanceTo(c) == 1;
        }
        return false;
    }

    /**
     * @param one first
     * @param two second
     * @return the value of first to second if both are in the graph else +inf
     */
    @Override
    public int weight(VertexInterface one, VertexInterface two)
    {
        return this.isSuccessor(one, two) ? 1 : Integer.MAX_VALUE;
    }

    /**
     * @return the graph size ie number of vertexes
     */
    @Override
    public int size()
    {
        return this.boxes.size();
    }

    /**
     * Iterate over the graph
     * @return Iterator
     */
    @Override
    public Iterator<VertexInterface> iterator()
    {
        return this.boxes.values().iterator();
    }
}
