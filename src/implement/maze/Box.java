package implement.maze;

import error.MazeError;
import interfaces.graph.VertexInterface;
import interfaces.maze.BoxInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public abstract class Box implements BoxInterface, VertexInterface
{
    private final int x;
    private final int y;
    private String label;
    private final ArrayList<String> solidBoxes = new ArrayList<>(Collections.singletonList("W"));

    /**
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    Box(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public static Box newBox(int i, int j, String type) throws MazeError
    {
        return switch (type)
                {
                    case "A" -> new ABox(i, j);
                    case "D" -> new DBox(i, j);
                    case "E" -> new EBox(i, j);
                    case "W" -> new WBox(i, j);
                    default -> throw new MazeError("Type " + type + " not recognized.");
                };
    }

    /**
     * @param x x pos.
     * @param y x pos.
     * @return the distance from this box to (x, y)
     */
    public double distanceTo(int x, int y)
    {
        return Math.sqrt((x - this.getX())^2 + (y - this.getY())^2);
    }

    /**
     * @param box another box
     * @return the distance from this box to box
     */
    public double distanceTo(Box box)
    {
        return this.distanceTo(box.getX(), box.getY());
    }

    protected void setLabel(String label)
    {
        this.label = label;
    }

    public String getLabel()
    {
        return label;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Box box = (Box) o;
        return x == box.x && y == box.y && Objects.equals(label, box.label);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y, label);
    }

    /**
     * @return The x coordinate.
     */
    @Override
    public int getX()
    {
        return this.x;
    }

    /**
     * @return The y coordinate.
     */
    @Override
    public int getY()
    {
        return this.y;
    }

    /**
     * @return The x and the y coordinates.
     */
    @Override
    public int[] getCoords()
    {
        return new int[]{this.getX(), this.getY()};
    }

    public boolean isSolid()
    {
        return this.solidBoxes.contains(this.getLabel());
    }

    @Override
    public String toString()
    {
        return label + "Box{x=" + x + ", y=" + y + '}';
    }
}
