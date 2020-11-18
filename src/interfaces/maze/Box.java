package interfaces.maze;

public interface Box
{
    /**
     * @return the x coordinate.
     */
    int getX();

    /**
     * @return the y coordinate.
     */
    int getY();

    /**
     * @return [x, y].
     */
    int[] getCoords();
}
