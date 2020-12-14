package mymain;

import error.MazeError;
import implement.maze.Box;
import implement.maze.Maze;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main
{
    private static final Logger logger = Logger.getLogger("com.mymain.Main");

    public static void main(String[] args)
    {
        try
        {
            Maze maze = new Maze("data/maze2");
            List<Box> path = maze.path("D", "A");
            Iterable<String> pathStr = path.stream().map(Box::toString).collect(Collectors.toList());

            logger.info(() -> String.join(" -> ", pathStr));
        }
        catch (MazeError e)
        {
            e.printStackTrace();
        }
    }
}
