package com.project.io;

import com.project.error.MazeException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class File
{
    File()
    {
        throw new IllegalStateException("Utility class");
    }

    /**
     * @param fileName the file path
     * @return content of the file
     */
    public static String read(String fileName) throws MazeException
    {
        try(InputStream file = new FileInputStream(fileName))
        {
            return new String(file.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException error)
        {
            error.printStackTrace();
            throw new MazeException("Can't open " + fileName);
        }
    }

    /**
     * @param fileName the file path
     * @return content of the file : each line as an element of the array
     */
    public static String[] readLines(String fileName) throws MazeException
    {
        return read(fileName).split("\n");
    }

    /**
     * @param fileName the file path
     * @return content of the file : each char as an element of the array
     */
    public static String[][] readChars(String fileName) throws MazeException
    {
        String[] txts = readLines(fileName);
        int ma = Collections.max(Arrays.stream(txts).map(txt -> txt.split("").length).collect(Collectors.toList()));

        String[][] out = new String[txts.length][ma];
        Arrays.stream(txts).map(txt -> txt.split("")).collect(Collectors.toList()).toArray(out);

        return out;
    }

    /**
     * @param fileName the file path
     * @param data content of the file
     */
    public static void write(String fileName, String data) throws MazeException
    {
        try(OutputStream file = new FileOutputStream(fileName))
        {
            file.write(data.getBytes());
        } catch (IOException error)
        {
            error.printStackTrace();
            throw new MazeException("Can't open " + fileName);
        }
    }

    /**
     * @param fileName the file path
     * @param data content of the file : each line as an element of the array
     */
    public static void writeLines(String fileName, String[] data) throws MazeException
    {
        File.write(fileName, String.join("\n", data));
    }

    /**
     * @param fileName the file path
     * @param data content of the file : each char as an element of the array
     */
    public static void writeChars(String fileName, String[][] data) throws MazeException
    {
        String[] lines = new String[data.length];
        for (int i = 0; i < data.length; i++)
        {
            lines[i] = String.join("", data[i]);
        }
        File.writeLines(fileName, lines);
    }
}
