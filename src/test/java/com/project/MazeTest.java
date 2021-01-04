package com.project;

import com.project.error.MazeException;
import com.project.implement.maze.box.Box;
import com.project.implement.maze.Maze;
import com.project.io.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MazeTest
{
    Box box1;
    Box box2;
    Box box3;
    Box box4;
    Maze maze1;

    @BeforeEach
    void setUp() throws MazeException
    {
        box1 = Box.newBox(0,0, "D");
        box2 = Box.newBox(0,1, "E");
        box4 = Box.newBox(1,0, "W");
        box3 = Box.newBox(1,1, "A");

        maze1 = new Maze(
            new HashMap<>() {{
                put(box1.getCoords(), box1);
                put(box2.getCoords(), box2);
                put(box3.getCoords(), box3);
                put(box4.getCoords(), box4);
            }},
            2,
            2
        );
    }

    @Test
    void equals()
    {
        assertEquals(maze1, maze1);
        assertEquals(maze1, new Maze(
                new HashMap<>() {{
                    put(box1.getCoords(), box1);
                    put(box2.getCoords(), box2);
                    put(box3.getCoords(), box3);
                    put(box4.getCoords(), box4);
                }},
                2,
                2
        ));
    }

    @Test
    void initFromTextFile() throws MazeException
    {
        Maze maze2 = new Maze("src/test/resources/maze1");
        assertEquals(maze1, maze2);
    }

    @Test
    void saveToTextFile() throws MazeException
    {
        maze1.saveToTextFile("src/test/resources/maze2");
        assertEquals(File.read("src/test/resources/maze1"), File.read("src/test/resources/maze2"));
    }

    @Test
    void contains()
    {
    }

    @Test
    void isSuccessor()
    {
    }

    @Test
    void weight()
    {
    }

    @Test
    void size()
    {
    }

    @Test
    void iterator()
    {
    }

    @Test
    void get()
    {
    }

    @Test
    void testGet()
    {
    }

    @Test
    void getByLabel()
    {
    }

    @Test
    void path()
    {
    }

    @Test
    void testPath()
    {
    }

    @Test
    void testPath1()
    {
    }

    @Test
    void testPath2()
    {
    }
}