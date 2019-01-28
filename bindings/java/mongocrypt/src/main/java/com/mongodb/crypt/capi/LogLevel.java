// TODO: copyright

package com.mongodb.crypt.capi;

/**
 * LogLevel represents the supported logging levels for the embedded mongod
 */
public enum LogLevel {
    /**
     * Turn off logging
     */
    NONE(0),

    /**
     * Log to stdout
     */
    STDOUT(1),

    /**
     * Log to stderr
     */
    STDERR(2),

    /**
     * Log via the {@code org.mongodb.embedded.capi} logger
     */
    LOGGER(4);

    private final int level;

    /**
     * @return the logging level
     */
    public int getLevel(){
        return level;
    }

    LogLevel(final int level){
        this.level = level;
    }
}
