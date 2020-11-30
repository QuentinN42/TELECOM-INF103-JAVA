package IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class File
{
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

    public static String[] readLines(String filename)
    {
        return read(filename).split("\n");
    }

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
