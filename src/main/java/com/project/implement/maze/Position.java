package com.project.implement.maze;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Position implements Serializable
{
    int x;
    int y;

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }

    @Override
    public String toString()
    {
        return "P(" + x + ", " + y + ')';
    }

    /**
     * Get neighbourhood of this.
     * @return all neighbours
     */
    public List<Position> neighbours()
    {
        return Arrays.asList(
                new Position(this.x + 1, this.y),
                new Position(this.x - 1, this.y),
                new Position(this.x, this.y + 1),
                new Position(this.x, this.y - 1)
        );
    }
}
