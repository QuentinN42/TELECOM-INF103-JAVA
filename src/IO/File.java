package IO;

import error.MazeError;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class File
{
    /**
     * @param fileName the file path
     * @return content of the file
     */
    public static String read(String fileName) throws MazeError
    {
        InputStream file = null;
        try
        {
            file = new FileInputStream(fileName);
            return new String(file.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException error)
        {
            error.printStackTrace();
        } finally
        {
            try
            {
                assert file != null;
                file.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        throw new MazeError("Can't open " + fileName);
    }

    /**
     * @param fileName the file path
     * @return content of the file : each line as an element of the array
     */
    public static String[] readLines(String fileName) throws MazeError
    {
        return read(fileName).split("\n");
    }

    /**
     * @param fileName the file path
     * @return content of the file : each char as an element of the array
     */
    public static String[][] readChars(String fileName) throws MazeError
    {
        String[] txts = readLines(fileName);
        int ma = -1;
        for(String txt: txts)
        {
            int v = txt.split("").length;
            if (v > ma)
            {
                ma = v;
            }
        }
        String[][] out = new String[txts.length][ma];

        for (int i = 0; i < txts.length; i++)
        {
            out[i] = txts[i].split("");
        }

        return out;
    }

    /**
     * @param fileName the file path
     * @param data content of the file
     */
    public static void write(String fileName, String data) throws MazeError
    {
        // TODO
        // open file
        // write data
        // close file
    }

    /**
     * @param fileName the file path
     * @param data content of the file : each line as an element of the array
     */
    public static void writeLines(String fileName, String[] data) throws MazeError
    {
        // TODO
        // join "\n" each line
        // call write
    }

    /**
     * @param fileName the file path
     * @param data content of the file : each char as an element of the array
     */
    public static void writeChars(String fileName, String[][] data) throws MazeError
    {
        // TODO
        // join "" in each line
        // call writeLines
    }
}
