// TODO: copyright

package com.mongodb.crypt.internal.logging;

/**
 * This class is not part of the public API.
 */
public final class Loggers {
    private static final String NAME = "org.mongodb.driver.embedded.capi";

    private static final boolean USE_SLF4J = shouldUseSLF4J();

    /**
     * @return the logger
     */
    public static Logger getLogger() {
        if (USE_SLF4J) {
            return new SLF4JLogger(NAME);
        } else {
            return new JULLogger(NAME);
        }
    }

    private Loggers() {
    }

    private static boolean shouldUseSLF4J() {
        try {
            Class.forName("org.slf4j.Logger");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
