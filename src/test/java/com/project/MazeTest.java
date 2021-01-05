package com.project;

import com.project.error.MazeException;
import com.project.implement.maze.box.Box;
import com.project.implement.maze.Maze;
import com.project.interfaces.graph.VertexInterface;
import com.project.io.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest
{
    Box box1;
    Box box2;
    Box box3;
    Box box4;
    List<Box> boxes;
    Maze maze1;

    @BeforeEach
    void setUp() throws MazeException
    {
        box1 = Box.newBox(0,0, "D");
        box2 = Box.newBox(0,1, "E");
        box4 = Box.newBox(1,0, "W");
        box3 = Box.newBox(1,1, "A");

        boxes = Arrays.asList(box1, box2, box3, box4);

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
        maze1.saveToTextFile("src/test/resources/maze1.out");
        assertEquals(File.read("src/test/resources/maze1"), File.read("src/test/resources/maze1.out"));
    }

    @Test
    void contains() throws MazeException
    {
        for (Box box: boxes)
            assertTrue(maze1.contains(box));

        assertTrue(maze1.contains(Box.newBox(1,1, "A")));

        assertFalse(maze1.contains(Box.newBox(1,1, "W")));
    }

    @Test
    void isSuccessor()
    {
        assertTrue(maze1.isSuccessor(box1,box2));
        assertTrue(maze1.isSuccessor(box2,box3));

        assertFalse(maze1.isSuccessor(box1, box4));
        assertFalse(maze1.isSuccessor(box3, box4));
    }

    @Test
    void weight()
    {
        assertEquals(1, maze1.weight(box1,box2));
        assertEquals(1, maze1.weight(box2,box3));

        assertEquals(Integer.MAX_VALUE, maze1.weight(box1, box4));
        assertEquals(Integer.MAX_VALUE, maze1.weight(box3, box4));
    }

    @Test
    void size()
    {
        assertEquals(4, maze1.size());
    }

    @Test
    void iterator()
    {
        Set<Box> test = new HashSet<>();
        for (VertexInterface box: maze1)
            test.add((Box) box);
        assertEquals(new HashSet<>(boxes), test);
    }

    @Test
    void get()
    {
        for (Box box: boxes)
        {
            assertEquals(box, maze1.get(box.getCoords()));
            assertEquals(box, maze1.get(box.getLabel()));
            assertEquals(box, maze1.get(box.getY(), box.getX()));
        }
    }

    @Test
    void path()
    {
        List<Box> path = Arrays.asList(box1, box2, box3);
        assertEquals(path, maze1.path(box1, box3));
        assertEquals(path, maze1.path("D", box3));
        assertEquals(path, maze1.path(box1, "A"));
        assertEquals(path, maze1.path("D", "A"));
    }
}