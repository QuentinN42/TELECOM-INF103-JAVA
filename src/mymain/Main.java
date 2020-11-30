package mymain;

import IO.File;

public class Main
{
    public static void main(String[] args)
    {
        String[][] content = File.readChars("data/1");
        for (String[] e: content)
        {
            System.out.println(String.join("-", e));
        }
    }
}
