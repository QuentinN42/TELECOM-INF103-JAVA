package implement.maze;

public class Box implements interfaces.maze.Box
{
    private int x;
    private int y;

    Box(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX()
    {
        return this.x;
    }

    @Override
    public int getY()
    {
        return this.y;
    }

    @Override
    public int[] getCoords()
    {
        return new int[]{this.getX(), this.getY()};
    }
}
