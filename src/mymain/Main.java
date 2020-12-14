package mymain;

import error.MazeError;
import implement.maze.Box;
import implement.maze.Maze;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Maze maze = new Maze("data/maze");
            for (Box box : maze.path("D", "A"))
            {
                System.out.println(box);
            }
        }
        catch (MazeError e)
        {
            e.printStackTrace();
        }
    }
}
