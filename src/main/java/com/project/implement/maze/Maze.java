package com.project.implement.maze;

import com.project.io.File;
import com.project.error.MazeException;
import com.project.implement.dijkstra.Dijkstra;
import com.project.interfaces.graph.GraphInterface;
import com.project.interfaces.graph.VertexInterface;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GraphInterface implementation from text file with a maze.
 */
public class Maze implements GraphInterface
{
    private final HashMap<int[], Box> boxes;
    private int height;
    private int width;

    public Maze()
    {
        boxes = new HashMap<>();
    }

    public Maze(String fileName) throws MazeException
    {
        this();
        this.initFromTextFile(fileName);
    }


    /**
     * @param fileName the maze file path.
     * @throws MazeException if can't init maze.
     */
    public final void initFromTextFile(String fileName) throws MazeException
    {
        String[][] data = File.readChars(fileName);
        this.height = data.length;
        this.width = data[0].length;
        for (int i = 0; i < this.height; i++)
        {
            if(data[i].length != this.width)
                throw new MazeException("Invalid lines length in '" + fileName + "' !");
            for (int j = 0; j < this.width; j++)
            {
                boxes.put(new int[]{j, i}, Box.newBox(j, i, data[i][j]));
            }
        }
    }

    /**
     * @param fileName the maze file path.
     * @throws MazeException if can't init maze.
     */
    public final void saveToTextFile(String fileName) throws MazeException
    {
        String[][] data = new String[this.height][this.width];
        for (int i = 0; i < this.height; i++)
        {
            for (int j = 0; j < this.width; j++)
            {
                int[] pos = new int[]{j, i};
                Box box = boxes.get(pos);
                data[i][j] = box.getLabel();
            }
        }
        File.writeChars(fileName, data);
    }

    /**
     * @param element the element to test
     * @return if the element is in the maze
     */
    @Override
    public boolean contains(VertexInterface element)
    {
        return element instanceof Box && boxes.containsValue(element);
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
        return this.boxes.values().stream().map(VertexInterface.class::cast).iterator();
    }

    /**
     * @param pos pos in the maze.
     * @return Box at this pos.
     */
    public final Box get(int[] pos)
    {
        return this.boxes.get(pos);
    }

    /**
     * @param xPos pos in the x axis.
     * @param yPos pos in the y axis.
     * @return Box at this pos.
     */
    public final Box get(int xPos, int yPos)
    {
        // Warning inverting x and y : x for <-> and y for v^
        return this.get(new int[]{yPos, xPos});
    }

    /**
     * @param label label of a box in the maze.
     * @return first Box with this label.
     */
    public final Box getByLabel(String label)
    {
        for (Box box: this.boxes.values())
        {
            if(label.equals(box.getLabel()))
                return box;
        }
        return null;
    }

    public List<Box> path(Box from, Box to)
    {
        return (new Dijkstra()).shortedPath(this, from, to).stream().map(Box.class::cast).collect(Collectors.toList());
    }

    public List<Box> path(String fromLabel, Box to)
    {
        return this.path(this.getByLabel(fromLabel), to);
    }

    public List<Box> path(Box from, String toLabel)
    {
        return this.path(from, this.getByLabel(toLabel));
    }

    public List<Box> path(String fromLabel, String toLabel)
    {
        return this.path(this.getByLabel(fromLabel), this.getByLabel(toLabel));
    }
}
