package implement.maze;

import error.MazeException;

class MazeTest
{
    public static void main(String[] args) throws MazeException
    {
        Maze maze = new Maze("file1.txt");
        System.out.println(maze.size());
    }
}