package implement.maze;

public abstract class Box implements interfaces.maze.Box
{
    private final int x;
    private final int y;
    private String label;

    /**
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    Box(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    protected void setLabel(String label)
    {
        this.label = label;
    }

    public String getLabel()
    {
        return label;
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
}
