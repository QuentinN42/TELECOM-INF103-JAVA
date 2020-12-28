package com.project.error;

public class MazeException extends Exception
{
    /**
     * Constructs a new instance of IOError with the specified cause. The
     * IOError is created with the detail message of
     * {@code (cause==null ? null : cause.toString())} (which typically
     * contains the class and detail message of cause).
     *
     * @param cause The cause of this error, or {@code null} if the cause
     *              is not known
     */
    public MazeException(Throwable cause)
    {
        super(cause);
    }

    public MazeException(String cause)
    {
        super(cause);
    }
}