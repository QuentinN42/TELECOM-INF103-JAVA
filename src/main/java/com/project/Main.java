package com.project;

import com.project.error.MazeException;
import com.project.implement.maze.Box;
import com.project.implement.maze.Maze;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main
{
    private static final Logger logger = Logger.getLogger("com.com.project.Main");

    public static void main(String[] args)
    {
        Maze maze = null;
        try
        {
            maze = new Maze("data/maze3");
        }
        catch (MazeException e)
        {
            logger.throwing("Main", "main", e);
        }
        assert maze != null;

        List<Box> path = maze.path("D", "A");
        Iterable<String> pathStr = path.stream().map(Box::toString).collect(Collectors.toList());

        logger.info(() -> String.join(" -> ", pathStr));
    }
}
