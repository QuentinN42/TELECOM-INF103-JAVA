package IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class File
{
    /**
     * @param filename the file path
     * @return content of the file
     */
    public static String read(String filename)
    {
        InputStream file = null;
        try
        {
            file = new FileInputStream(filename);
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
        return "ERROR";
    }

    /**
     * @param filename the file path
     * @return content of the file : each line as an element of the array
     */
    public static String[] readLines(String filename)
    {
        return read(filename).split("\n");
    }

    /**
     * @param filename the file path
     * @return content of the file : each char as an element of the array
     */
    public static String[][] readChars(String filename)
    {
        String[] txts = readLines(filename);
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
}
