package com.project.implement.maze;

import com.project.implement.maze.box.Box;
import com.project.io.File;
import com.project.error.MazeException;
import com.project.implement.dijkstra.Dijkstra;
import com.project.interfaces.graph.GraphInterface;
import com.project.interfaces.graph.VertexInterface;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * GraphInterface implementation from text file with a maze.
 */
public class Maze implements GraphInterface, AutoCloseable, Serializable
{
    @Serial
    private static final long serialVersionUID = 1905122041950251207L;
    private final HashMap<Position, Box> boxes;
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

    public Maze(Map<Position, Box> boxes, int height, int width)
    {
        this.boxes = (HashMap<Position, Box>) boxes;
        this.height = height;
        this.width = width;
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
                boxes.put(new Position(j, i), Box.newBox(j, i, data[i][j]));
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
                Box box = boxes.get(new Position(j, i));
                data[i][j] = box.getLabel();
            }
        }
        File.writeChars(fileName, data);
    }

    public final void printSolution()
    {
        List<Box> path = this.path("D", "A");
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < this.height; i++)
        {
            for (int j = 0; j < this.width; j++)
            {
                Box box = boxes.get(new Position(j, i));
                if(Arrays.asList("D", "A").contains(box.getLabel()))
                {
                    out.append(box.getLabel());
                }
                else if(path.contains(box))
                {
                    out.append(Arrays.asList(
                        ">","<","v","^"
                    ).get(box.getCoords().neighbours().indexOf(
                            path.get(1 + path.indexOf(box)).getCoords()))
                    );
                }
                else
                {
                    out.append(box.getLabel());
                }
            }
            out.append('\n');
        }
        System.out.println(out.toString());
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


    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Maze that = (Maze) o;
        return height == that.height && width == that.width && Objects.equals(new HashSet<>(boxes.values()), new HashSet<>(that.boxes.values()));
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(boxes, height, width);
    }

    public String toString()
    {
        return "Maze(" + boxes.toString() + ")";
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

            if (!(f.isSolid()) && (!c.isSolid()))
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

    @Override
    public Iterator<VertexInterface> successors(VertexInterface vertex)
    {
        if(vertex instanceof Box)
        {
            Position pos = ((Box) vertex).getCoords();
            return pos.neighbours().stream().map(this::get).filter(box -> this.isSuccessor(box, vertex)).map(VertexInterface.class::cast).iterator();
        }
        else
        {
            return null;
        }
    }

    /**
     * @param pos pos in the maze.
     * @return Box at this pos.
     */
    public final Box get(Position pos)
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
        //noinspection SuspiciousNameCombination
        return this.get(new Position(yPos, xPos));
    }

    /**
     * @param label label of a box in the maze.
     * @return first Box with this label.
     */
    public final Box get(String label)
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
        return this.path(this.get(fromLabel), to);
    }

    public List<Box> path(Box from, String toLabel)
    {
        return this.path(from, this.get(toLabel));
    }

    public List<Box> path(String fromLabel, String toLabel)
    {
        return this.path(this.get(fromLabel), this.get(toLabel));
    }

    @Override
    public void close()
    {
        // Do nothing to close the Maze
    }
}
