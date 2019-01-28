// TODO: copyright

package com.mongodb.crypt.capi;

public interface MongoCryptLibrary extends AutoCloseable {
    /**
     * Create a new context for encryption/decryption operations
     * @return a MongoCrypt instance
     */
    MongoCrypt create();

    void close();
}
