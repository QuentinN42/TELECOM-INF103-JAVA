package com.project.interfaces.maze;

import com.project.implement.maze.Position;

public interface BoxInterface
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
    Position getCoords();
}
