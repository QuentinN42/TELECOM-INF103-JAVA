package mymain;

import error.MazeError;
import implement.maze.Box;
import implement.maze.Maze;

import java.util.List;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Maze maze = new Maze("data/maze");
            List<Box> path = maze.path("D", "A");
            Iterable<String> pathStr = path.stream().map(Box::toString).collect(Collectors.toList());

            System.out.println(String.join(" -> ", pathStr));
        }
        catch (MazeError e)
        {
            e.printStackTrace();
        }
    }
}
