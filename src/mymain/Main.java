package mymain;

import IO.File;
import error.MazeError;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            String[][] content = File.readChars("data/1");
            for (String[] e: content)
            {
                System.out.println(String.join("-", e));
            }
        }
        catch (MazeError e)
        {
            e.printStackTrace();
        }
    }
}
