package com.project.gui;


import com.project.error.MazeException;
import com.project.implement.maze.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serial;
import java.util.logging.Logger;


public class GUI extends JFrame implements ActionListener
{
    private static final Logger logger = Logger.getLogger("com.project.gui.GUI");

    @Serial
    private static final long serialVersionUID = 1L;
    public static final int SAMPLE_CANVAS_WIDTH  = 500;
    public static final int SAMPLE_CANVAS_HEIGHT = 500;
    final JFileChooser fc = new JFileChooser();
    private boolean solve;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }

    private MazeGUI mazeGUI;
    private Maze maze;

    public GUI()
    {

        this.makeMenu();

        maze = null;
        mazeGUI = new MazeGUI(null, false);

        this.drawMaze();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Maze");
        setVisible(true);
    }

    private void makeMenu()
    {
        MenuBar mBar = new MenuBar();
        setMenuBar(mBar);

        Menu file = new Menu("File");
        mBar.add(file);
        file.add(new MenuItem("Open"));
        file.add(new MenuItem("Solve"));
        file.addActionListener(this);

        Menu exit = new Menu("Exit");
        mBar.add(exit);
        exit.add(new MenuItem("Close"));
        exit.addActionListener(this);
    }

    private void drawMaze()
    {
        mazeGUI.setPreferredSize(new Dimension(SAMPLE_CANVAS_WIDTH, SAMPLE_CANVAS_HEIGHT));
        Container containerPane = getContentPane();
        containerPane.add(mazeGUI);
        pack();

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Close"))
        {
            logger.info(() -> "Quit.");
            System.exit(0);
        }
        if (e.getActionCommand().equals("Open"))
        {
            logger.info(() -> "Open file.");
            if(this.openFile())
                this.solve = false;
        }
        if (e.getActionCommand().equals("Solve"))
        {
            logger.info(() -> "Solving.");
            this.solve = true;
        }
        this.mazeGUI = new MazeGUI(maze, solve);
        this.drawMaze();
    }

    private boolean openFile()
    {
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            File file = fc.getSelectedFile();

            logger.info(() -> "Opening: " + file.getAbsolutePath() + ".");
            return this.initMaze(file.getAbsolutePath());
        }
        else
        {
            logger.info(() -> "Open command cancelled by user.");
            return false;
        }
    }

    private boolean initMaze(String absolutePath)
    {
        try(Maze tmp = new Maze(absolutePath))
        {
            this.maze = tmp;
            return true;
        }
        catch (MazeException ex)
        {
            logger.throwing("GUI", "initMaze", ex);
            return false;
        }
    }
}
