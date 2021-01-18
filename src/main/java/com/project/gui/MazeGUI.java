package com.project.gui;

import com.project.implement.maze.Maze;
import com.project.implement.maze.box.Box;
import com.project.interfaces.graph.VertexInterface;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.io.Serial;

class MazeGUI extends JPanel
{
    private final boolean needSolve;
    Maze maze;

    public MazeGUI(Maze maze, boolean needSolve)
    {
        this.maze = maze;
        this.needSolve = needSolve;
    }

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public void paintComponent(Graphics graphics)
    {
        this.initGraphic(graphics);
        if(maze != null)
            this.drawMaze(graphics);
    }

    private void initGraphic(Graphics graphics)
    {
        super.paintComponent(graphics);
        setBackground(Color.GRAY);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Monospaced", Font.PLAIN, 12));
    }

    private void drawMaze(Graphics graphics)
    {
        graphics.setColor(Color.BLACK);
        for (VertexInterface vi: maze)
        {
            Box box = ((Box) vi);
            int x = box.getX();
            int y = box.getY();
            graphics.drawRect(x*25, y*25, 25, 25);
            graphics.drawString(box.getLabel(), x*25+10, y*25+15);
        }
        if(needSolve)
            this.addSolution(graphics);
    }

    private void addSolution(Graphics graphics)
    {
        graphics.setColor(Color.RED);
        for (Box box: maze.path("D", "A"))
        {
            int x = box.getX();
            int y = box.getY();
            graphics.drawRect(x*25, y*25, 25, 25);
            graphics.drawString(box.getLabel(), x*25+10, y*25+15);
        }
    }
}